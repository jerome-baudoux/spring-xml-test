package com.springtest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.springtest.api.Person;

public class PersonDaoJdbcImpl extends JdbcDaoSupport implements PersonDao {

	public List<Person> getAllPersons() {
		return getJdbcTemplate().query("SELECT * from Person", new RowMapper<Person>() {
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setId(rs.getInt("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				return person;
			}
		});
	}

	public int addPerson(Person person) {
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getJdbcTemplate());
		
		// Params
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firstName", person.getFirstName());
		params.put("lastName", person.getLastName());
		MapSqlParameterSource sqlParams = new MapSqlParameterSource(params);
		
		// Id
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update("INSERT INTO Person (FIRST_NAME, LAST_NAME) VALUES (:firstName, :lastName);", sqlParams, keyHolder);
		
		return keyHolder.getKey().intValue();
	}
}
