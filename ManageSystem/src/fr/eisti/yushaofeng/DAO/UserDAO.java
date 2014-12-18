package fr.eisti.yushaofeng.DAO;


import java.sql.SQLException;
import java.util.List;
import fr.eisti.yushaofeng.model.User;

public interface UserDAO {
	public List<User> getAllUsers() throws SQLException;

	public User getUser(int id) throws SQLException;
	
	public void addUser(User user) throws SQLException;

	public boolean updateUser(User user) throws SQLException;

	
	public User login(String userName,String password) throws SQLException;
	

	boolean deleteUser(User user) throws SQLException;

}
