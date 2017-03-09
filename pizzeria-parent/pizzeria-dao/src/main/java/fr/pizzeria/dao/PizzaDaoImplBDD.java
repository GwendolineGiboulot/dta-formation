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

public class PizzaDaoImplBDD implements IDao<Pizza, String> {

	Connection connection;
	static final String ADRESSE_BASE = "localhost";

	public PizzaDaoImplBDD() {

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

	@Override
	public List<Pizza> findAllPizzas() {

		try (Statement statement = connection.createStatement()) {

			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");

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

			resultats.close();

			return liste;

		} catch (SQLException e) {
			throw new DaoRuntimeException(e);
		}

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SaveDaoException {

		try {

			PreparedStatement updatePizzaSt = connection
					.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)");
			updatePizzaSt.setString(1, pizza.code);
			updatePizzaSt.setString(2, pizza.nom);
			updatePizzaSt.setFloat(3, pizza.prix.floatValue());
			updatePizzaSt.setString(4, pizza.categorie.toString());
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new SaveDaoException(e);
		}

	}

	@Override
	public void updatePizza(String code, Pizza pizza) throws UpdateDaoException {

		try {

			PreparedStatement updatePizzaSt = connection
					.prepareStatement("UPDATE PIZZA SET code=? ,nom=? ,prix=? ,categorie = ? WHERE CODE=?");
			updatePizzaSt.setString(1, pizza.code);
			updatePizzaSt.setString(2, pizza.nom);
			updatePizzaSt.setFloat(3, pizza.prix.floatValue());
			updatePizzaSt.setString(4, pizza.categorie.toString());
			updatePizzaSt.setString(5, code);
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new UpdateDaoException(e);
		}

	}

	@Override
	public void deletePizza(String code) throws DeleteDaoException {

		try {

			PreparedStatement updatePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE CODE=?");
			updatePizzaSt.setString(1, code);
			updatePizzaSt.executeUpdate();

			updatePizzaSt.close();

		} catch (SQLException e) {
			throw new DeleteDaoException(e);
		}

	}

}
