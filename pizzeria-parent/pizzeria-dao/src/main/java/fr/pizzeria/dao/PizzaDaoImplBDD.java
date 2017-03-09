package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoRuntimeException;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 * 
 *         Cette classe implémente l'interface IDao avec une base de donnée
 *         mySQL
 *
 */
public class PizzaDaoImplBDD implements IDao<Pizza, String> {

	private Connection ouvrirConnection() {

		try {

			ResourceBundle bundle = ResourceBundle.getBundle("conf/jdbc");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			String adresse = bundle.getString("adresse");

			Connection connection = DriverManager.getConnection(adresse, user, password);

			return connection;
		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {

		try (Connection connection = ouvrirConnection();
				Statement statement = connection.createStatement();
				ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA")) {

			List<Pizza> liste = new ArrayList<>();

			while (resultats.next()) {
				Integer id = resultats.getInt("id");
				String code = resultats.getString("code");
				String name = resultats.getString("nom");
				float price = resultats.getFloat("prix");
				CategoriePizza categ = CategoriePizza.getEnum(resultats.getString("categorie"));

				Pizza p = new Pizza(id, code, name, price, categ);

				liste.add(p);
			}

			return liste;

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);

		}

	}

	@FunctionalInterface
	interface Exec {
		void execute(PreparedStatement st) throws SQLException;
	}

	public void ExecuteUpdate(String sql, Exec ex) {

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection.prepareStatement(sql)) {

			ex.execute(updatePizzaSt);

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SaveDaoException {

		ExecuteUpdate("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)", new Exec() {

			@Override
			public void execute(PreparedStatement st) throws SQLException {
				st.setString(1, pizza.getCode());
				st.setString(2, pizza.getNom());
				st.setFloat(3, pizza.getPrix().floatValue());
				st.setString(4, pizza.getCategorie().toString());
				st.executeUpdate();

			}
		});

	}

	@Override
	public void updatePizza(String code, Pizza pizza) throws UpdateDaoException {

		ExecuteUpdate("UPDATE PIZZA SET code=? ,nom=? ,prix=? ,categorie = ? WHERE CODE=?", new Exec() {

			@Override
			public void execute(PreparedStatement st) throws SQLException {
				st.setString(1, pizza.getCode());
				st.setString(2, pizza.getNom());
				st.setFloat(3, pizza.getPrix().floatValue());
				st.setString(4, pizza.getCategorie().toString());
				st.setString(5, code);
				st.executeUpdate();

			}
		});

	}

	@Override
	public void deletePizza(String code) throws DeleteDaoException {

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE CODE=?")) {

			updatePizzaSt.setString(1, code);
			updatePizzaSt.executeUpdate();

		} catch (SQLException e) {
			throw new DeleteDaoException(e);
		}

	}

	@Override
	public void importer() {

		List<Pizza> liste = new ArrayList<>();

		try (Stream<Path> files = Files.list(Paths.get("data\\"))) {

			liste = files.map(chemin -> {

				try (Stream<String> lines = Files.lines(chemin)) {

					String[] items = lines.findFirst().get().split(";");
					return new Pizza(Integer.parseInt(items[0]), items[1], items[2], Double.parseDouble(items[3]),
							CategoriePizza.getEnum(items[4]));
				} catch (IOException e) {
					throw new DaoRuntimeException(e);
				}

			}).collect(Collectors.toList());

		} catch (IOException e) {
			throw new DaoRuntimeException(e);
		}

		List<List<Pizza>> listePartionne = ListUtils.partition(liste, 3);

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection
						.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)")) {

			connection.setAutoCommit(false);

			for (List<Pizza> pizl : listePartionne) {
				insererLot(updatePizzaSt, pizl, connection);
			}

		} catch (

		SQLException e) {
			throw new DaoRuntimeException(e);
		}

	}

	void insererLot(PreparedStatement updatePizzaSt, List<Pizza> pizl, Connection connection) {

		try {
			if (pizl.size() == 3) {
				for (Pizza pizza : pizl) {

					updatePizzaSt.setString(1, pizza.getCode());
					updatePizzaSt.setString(2, pizza.getNom());
					updatePizzaSt.setFloat(3, pizza.getPrix().floatValue());
					updatePizzaSt.setString(4, pizza.getCategorie().toString());
					updatePizzaSt.executeUpdate();
				}

			}

			connection.commit();
		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}
	}

}
