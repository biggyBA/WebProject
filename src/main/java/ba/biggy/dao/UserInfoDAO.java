package ba.biggy.dao;

import java.util.List;

import ba.biggy.model.UserInfo;

public interface UserInfoDAO {
	
	public List<UserInfo> getAllAdmins();
	
	public List<UserInfo> getAllServiceman();
	
	public List<UserInfo> getAllUsers();
	
	public UserInfo getUserById (int id);
	
	public UserInfo getUserByUsername (String username);

}
