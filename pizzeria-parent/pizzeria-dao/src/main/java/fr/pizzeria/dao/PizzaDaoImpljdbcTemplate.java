package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoImpljdbcTemplate implements IDao<Pizza, String> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoImpljdbcTemplate(DataSource datasource) {

		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public class PizzaMapper implements RowMapper<Pizza> {
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("ID"));
			p.setNom(rs.getString("nom"));
			p.setCode(rs.getString("code"));
			p.setPrix(rs.getDouble("prix"));
			p.setCategorie(CategoriePizza.getEnum(rs.getString("categorie")));
			p.setUrlImage(rs.getString("url_image"));
			return p;
		}
	}

	@Override
	public List<Pizza> findAll() {

		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper());

	}

	@Override
	public void saveNew(Pizza pizza) throws SaveDaoException {

		String sql = "INSERT INTO PIZZA(code,nom,prix,categorie) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(),
				pizza.getCategorie().getLibelle());

	}

	@Override
	public void update(String code, Pizza pizza) throws UpdateDaoException {

		String sql = "UPDATE PIZZA SET code=? ,nom=? ,prix=? ,categorie = ? WHERE CODE=?";
		this.jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie());

	}

	@Override
	public void delete(String code) throws DeleteDaoException {

		String sql = "DELETE FROM PIZZA WHERE CODE=?";
		this.jdbcTemplate.update(sql, code);
	}

}
