package ba.biggy.model;





public class UserInfo {
	
	private String username;
    private String password;
    private String usersName;
     
    public UserInfo()  {
         
    }
 
    public UserInfo(String username, String password, String usersName) {
        this.username = username;
        this.password = password;
        this.usersName = usersName;
    }
 
    
 
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
    
    

}
