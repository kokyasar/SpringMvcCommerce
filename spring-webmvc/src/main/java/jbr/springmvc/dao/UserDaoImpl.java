package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Item;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users values(?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
  }

  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

	public List<User> getUser() {
		return jdbcTemplate.query("select * from users", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User e = new User();
				e.setUsername(rs.getString(1));
				e.setPassword(rs.getString(2));
				e.setFirstname(rs.getString(3));
				e.setLastname(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setAddress(rs.getString(6));
				e.setPhone(rs.getInt(7));
				return e;
			}
		});
	}
	
	public List<Item> getItem() {
		return jdbcTemplate.query("select * from item", new RowMapper<Item>() {
			public Item mapRow(ResultSet rs, int row) throws SQLException {
				Item e = new Item();
				e.setId(rs.getInt(1));
				e.setItemName(rs.getString(2));
				e.setItemDetail(rs.getString(3));
				e.setItemPrice(rs.getInt(4));
				e.setCategoryId(rs.getInt(5));
				return e;
			}
		});
	}
  
  
}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));

    return user;
  }
}