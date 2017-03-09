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

	Connection connection;

	/**
	 * 
	 * Ce constructeur permet la connexion à la BDD mySQL
	 * 
	 */

	private void ouvrirConnection() {

		try {

			ResourceBundle bundle = ResourceBundle.getBundle("conf/jdbc");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			String adresse = bundle.getString("adresse");

			connection = DriverManager.getConnection(adresse, user, password);

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}
	}

	private void fermerConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {

		ouvrirConnection();

		try (Statement statement = connection.createStatement();
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

			fermerConnection();

			return liste;

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);

		}

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SaveDaoException {

		ouvrirConnection();

		try (PreparedStatement updatePizzaSt = connection
				.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)")) {

			updatePizzaSt.setString(1, pizza.getCode());
			updatePizzaSt.setString(2, pizza.getNom());
			updatePizzaSt.setFloat(3, pizza.getPrix().floatValue());
			updatePizzaSt.setString(4, pizza.getCategorie().toString());
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new SaveDaoException(e);
		}

		fermerConnection();

	}

	@Override
	public void updatePizza(String code, Pizza pizza) throws UpdateDaoException {

		ouvrirConnection();

		try (PreparedStatement updatePizzaSt = connection
				.prepareStatement("UPDATE PIZZA SET code=? ,nom=? ,prix=? ,categorie = ? WHERE CODE=?")) {

			updatePizzaSt.setString(1, pizza.getCode());
			updatePizzaSt.setString(2, pizza.getNom());
			updatePizzaSt.setFloat(3, pizza.getPrix().floatValue());
			updatePizzaSt.setString(4, pizza.getCategorie().toString());
			updatePizzaSt.setString(5, code);
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new UpdateDaoException(e);
		}

		fermerConnection();

	}

	@Override
	public void deletePizza(String code) throws DeleteDaoException {

		ouvrirConnection();

		try (PreparedStatement updatePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE CODE=?")) {

			updatePizzaSt.setString(1, code);
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new DeleteDaoException(e);
		}

		fermerConnection();

	}

}
