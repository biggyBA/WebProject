package ba.biggy.dao;

import java.util.List;

import ba.biggy.model.UserInfo;

public interface UserInfoDAO {
	
	
	public List<String> getUserRoles(String username);

}
