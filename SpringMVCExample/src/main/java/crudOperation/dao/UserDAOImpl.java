package crudOperation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import crudOperation.user.User;

public class UserDAOImpl implements UserDAO {

	HashMap<Integer, User> user = new HashMap<Integer, User>();

	@Autowired
	DataSource dataSource;

	// public void setDataSource(DataSource dataSource) {
	// this.dataSource = dataSource;
	// }

	int count = 1;

	public List<User> createUser(User u) {

		System.out.println(u.getAge());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into user(username,email,age,phone) values(?,?,?,?)";
		System.out.println("executing query");
		jdbcTemplate.update(sql, new Object[] { u.getUsername(), u.getEmail(), Integer.parseInt(u.getAge()),
				Long.parseLong(u.getPhone()) });

		List<User> list = showAll();

		return list;

	}

	public List<User> findUser(String username) {

		// User temp = new User();

		String sql = "select * from user where username='" + username + "'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<User> us = jdbcTemplate.query(sql, new RowMapper<User>() {

			public User mapRow(ResultSet arg0, int arg1) throws SQLException {

				User temp = new User();
				temp.setUsername(arg0.getString("username"));
				temp.setEmail(arg0.getString("email"));
				temp.setAge("" + arg0.getInt("age"));
				temp.setPhone("" + arg0.getLong("phone"));

				return temp;

			}

		});

		return us;

		// return null;
	}

	public List<User> update(User user) {

		String u = user.getUsername();
		
		List<User> list= delete(u);
		list.clear();
		list=createUser(user);
		
		return list;
				
		

	}

	public List<User> delete(String username) {

		// User temp= findUser(username);
		String sql = "delete from user where username='" + username + "' LIMIT 1";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
		List<User> list = showAll();
		return list;

	}

	public List<User> showAll() {
		String sql = "select * from user";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<User> allUsers = jdbcTemplate.query(sql, new RowMapper<User>() {

			public User mapRow(ResultSet arg0, int arg1) throws SQLException {

				User temp = new User();
				temp.setUsername(arg0.getString("username"));
				temp.setEmail(arg0.getString("email"));
				temp.setAge("" + arg0.getInt("age"));
				temp.setPhone("" + arg0.getLong("phone"));

				return temp;
			}

		});

		return allUsers;
	}

}
