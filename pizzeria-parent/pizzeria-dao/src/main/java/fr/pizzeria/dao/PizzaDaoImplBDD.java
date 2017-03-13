package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

			return DriverManager.getConnection(adresse, user, password);

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}
	}

	@Override
	public List<Pizza> findAll() {

		try (Connection connection = ouvrirConnection();
				Statement statement = connection.createStatement();
				ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA")) {

			List<Pizza> liste = new ArrayList<>();

			while (resultats.next()) {
				Integer id = resultats.getInt("id");
				String code = resultats.getString("code");
				String name = resultats.getString("nom");
				float price = resultats.getFloat("prix");
				CategoriePizza categ = CategoriePizza.valueOf((resultats.getString("categorie")));

				Pizza p = new Pizza(code, name, price, categ);

				liste.add(p);
			}

			return liste;

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);

		}

	}

	/**
	 * @author Quelqun
	 *
	 */
	@FunctionalInterface
	interface Exec {

		/**
		 * @param st
		 * @throws SQLException
		 */
		void execute(PreparedStatement st) throws SQLException;
	}

	private void executeUpdate(String sql, Exec ex) {

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection.prepareStatement(sql)) {

			ex.execute(updatePizzaSt);

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}

	}

	@Override
	public void saveNew(Pizza pizza) throws SaveDaoException {

		executeUpdate("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)", st -> {

			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getNom());
			st.setFloat(3, pizza.getPrix().floatValue());
			st.setString(4, "" + pizza.getCategorie().name());
			st.executeUpdate();

		});

	}

	@Override
	public void update(String code, Pizza pizza) throws UpdateDaoException {

		executeUpdate("UPDATE PIZZA SET code=? ,nom=? ,prix=? ,categorie = ? WHERE CODE=?", st -> {

			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getNom());
			st.setFloat(3, pizza.getPrix().floatValue());
			st.setString(4, "" + pizza.getCategorie().name());
			st.setString(5, code);
			st.executeUpdate();

		});

	}

	@Override
	public void delete(String code) throws DeleteDaoException {

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE CODE=?")) {

			updatePizzaSt.setString(1, code);
			updatePizzaSt.executeUpdate();

		} catch (SQLException e) {
			throw new DeleteDaoException(e);
		}

	}

	@Override
	public void importer(IDao<Pizza, String> source) {

		List<Pizza> liste = source.findAll();

		List<List<Pizza>> listePartionne = ListUtils.partition(liste, 3);

		try (Connection connection = ouvrirConnection();
				PreparedStatement updatePizzaSt = connection
						.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)")) {

			connection.setAutoCommit(false);

			for (List<Pizza> pizl : listePartionne) {
				insererLot(updatePizzaSt, pizl, connection);
			}

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}

	}

	private void insererLot(PreparedStatement updatePizzaSt, List<Pizza> pizl, Connection connection)
			throws SQLException {

		for (Pizza pizza : pizl) {

			updatePizzaSt.setString(1, pizza.getCode());
			updatePizzaSt.setString(2, pizza.getNom());
			updatePizzaSt.setFloat(3, pizza.getPrix().floatValue());
			updatePizzaSt.setString(4, pizza.getCategorie().name());
			updatePizzaSt.executeUpdate();
		}

		connection.commit();

	}

}
