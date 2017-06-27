package crudOperation.dao;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import crudOperation.user.User;

@org.springframework.transaction.annotation.Transactional
public class UserDAOImpl implements UserDAO {

	HashMap<Integer, User> user = new HashMap<Integer, User>();

	@Autowired
	@PersistenceContext
	EntityManager entityManager;

	// public void setDataSource(DataSource dataSource) {
	// this.dataSource = dataSource;
	// }

	int count = 1;
	
	public void createUser(User u) {

//		System.out.println(u.getAge());
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		String sql = "insert into user(username,email,age,phone) values(?,?,?,?)";
//		System.out.println("executing query");
//		jdbcTemplate.update(sql, new Object[] { u.getUsername(), u.getEmail(), Integer.parseInt(u.getAge()),
//				Long.parseLong(u.getPhone()) });
		
		entityManager.persist(u);

	}
	
	
	
	public List<User> findUser(String username) {

		// User temp = new User();

		String sql = "from User where username='" + username + "'";
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//		List<User> us = jdbcTemplate.query(sql, new RowMapper<User>() {
//
//			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
//
//				User temp = new User();
//				temp.setUsername(arg0.getString("username"));
//				temp.setEmail(arg0.getString("email"));
//				temp.setAge("" + arg0.getInt("age"));
//				temp.setPhone("" + arg0.getLong("phone"));
//
//				return temp;
//
//			}
//
//		});
		
		List<User> us=entityManager.createQuery(sql).getResultList();

		return us;

		// return null;
	}

	public void update(User user) {

		//String u = user.getUsername();

		//delete(u);
		//createUser(user);
		
		entityManager.merge(user);

	}

	public void delete(String username) {

		 List<User> temp= findUser(username);
//		String sql = "delete from user where username='" + username + "' LIMIT 1";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		jdbcTemplate.update(sql);
		
		System.out.println("in delete");
		System.out.println(username);
		entityManager.remove(temp.get(0));

	}

	@Transactional
	public List<User> show() {
		String sql = "from User";
		List<User> allUsers;
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		List<User> allUsers = jdbcTemplate.query(sql, new RowMapper<User>() {
//
//			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
//
//				User temp = new User();
//				temp.setUsername(arg0.getString("username"));
//				temp.setEmail(arg0.getString("email"));
//				temp.setAge("" + arg0.getInt("age"));
//				temp.setPhone("" + arg0.getLong("phone"));
//
//				return temp;
//			}
//
//		});

		allUsers=entityManager.createQuery(sql).getResultList();
		return allUsers;
	}

	@Transactional
	public void bulkUpload(List<User> list){

		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
//			if (i == 1)
//				throw new Exception("Something went Wrong");
			createUser(list.get(i));

		}

	}

}
