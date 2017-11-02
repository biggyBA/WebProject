package ba.biggy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.biggy.dao.UserInfoDAO;
import ba.biggy.global.Constants;
import ba.biggy.model.UserInfo;



public class UserInfoDAOImpl implements UserInfoDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UserInfoDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<UserInfo> getAllAdmins() {
		String sql = "SELECT * FROM " + Constants.USER_ROLES_TABLE_NAME + " WHERE " + Constants.USER_ROLES_TABLE_ROLE_COLUMN + " = '"+ Constants.ROLE_ADMIN +"'" ;
		List<UserInfo> adminList = jdbcTemplate.query(sql,new RowMapper<UserInfo>() {

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userInfo = new UserInfo();
				
				userInfo.setUsername(rs.getString(Constants.USER_ROLES_TABLE_USERNAME_COLUMN));
				userInfo.setUsersName(rs.getString(Constants.USER_ROLES_TABLE_USERS_NAME_COLUMN));
				
				return userInfo;
			}
			
		});
		return adminList;
	}

	@Override
	public List<UserInfo> getAllServiceman() {
		String sql = "SELECT * FROM " + Constants.USER_ROLES_TABLE_NAME + " WHERE " + Constants.USER_ROLES_TABLE_ROLE_COLUMN + " = '"+ Constants.ROLE_SERVICEMAN +"'" ;
		List<UserInfo> servicemanList = jdbcTemplate.query(sql,new RowMapper<UserInfo>() {

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userInfo = new UserInfo();
				
				userInfo.setUsername(rs.getString(Constants.USER_ROLES_TABLE_USERNAME_COLUMN));
				userInfo.setUsersName(rs.getString(Constants.USER_ROLES_TABLE_USERS_NAME_COLUMN));
				
				return userInfo;
			}
			
		});
		return servicemanList;
	}

	@Override
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserByUsername(String username) {
		String sql = "SELECT usersName FROM users WHERE username = '"+ username +"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<UserInfo>() {

			@Override
			public UserInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserInfo userInfo = new UserInfo();
					
					userInfo.setUsersName(rs.getString(Constants.USERS_TABLE_USERS_NAME));
					
					return userInfo;
				}
				return null;
			}
			
		});
	}

	
  
 
    

}
