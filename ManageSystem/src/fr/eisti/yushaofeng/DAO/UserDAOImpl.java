package fr.eisti.yushaofeng.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eisti.yushaofeng.db.ConnectionFactory;
import fr.eisti.yushaofeng.db.DbUtil;
import fr.eisti.yushaofeng.model.User;

public class UserDAOImpl implements UserDAO {
	private  Statement statement;
	private Connection connection;
	List<User> users;
	public UserDAOImpl(){
		users=new ArrayList<User>();
		connection=ConnectionFactory.getConnection();
	}
	@Override
	public List<User> getAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM User";
        ResultSet rs = null;
        User user = new User();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				user.setMetierId(rs.getInt("MetierId"));
				users.add(user);
				
			}
            
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return users;

	}

	@Override
	public User getUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM User WHERE id=" + id;
        ResultSet rs = null;
        User user = new User();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				user.setMetierId(rs.getInt("MetierId"));
				
			}
            
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return user;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
		if(user.getId()>=0){
			String query = "UPDATE User SET User.password='"+user.getPassword()+"' WHERE id=" + user.getId();
			try {
				statement.executeUpdate(query);
				return true;
			} finally {
	            DbUtil.close(statement);
	            DbUtil.close(connection);
	        }
		}else if(user.getUsername()!=null){
			String query = "UPDATE User SET password='"+user.getPassword()+"' WHERE username='" + user.getUsername()+"'";
			try {
				statement.executeUpdate(query);
				return true;
			} finally {
	            DbUtil.close(statement);
	            DbUtil.close(connection);
	        }
		}else{
			return false;
		}

	}

	@Override
	public boolean deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
		if(user.getId()>=0){
			String query = "DELETE FROM User WHERE id=" + user.getId();
			try {
				statement.executeUpdate(query);
				return true;
			} finally {
	            DbUtil.close(statement);
	            DbUtil.close(connection);
	        }
		}else if(user.getUsername()!=null){
			String query = "DELETE FROM User WHERE username='" + user.getUsername()+"'";
			try {
				statement.executeUpdate(query);
				return true;
			} finally {
	            DbUtil.close(statement);
	            DbUtil.close(connection);
	        }
		}else{
			return false;
		}
			
		

	}
	public User login(String userName,String password) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM User WHERE UserName='" + userName+"'AND Password='"+password+"'";
        ResultSet rs = null;
        User user = new User();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int rowcount = 0;
            if (rs.last()) {
              rowcount = rs.getRow();
              rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }
            if(rowcount>0)
            {
            	while(rs.next()){
    				user.setId(rs.getInt("id"));
    				user.setFirstName(rs.getString("firstName"));
    				user.setLastName(rs.getString("lastName"));
    				user.setUsername(rs.getString("UserName"));
    				user.setPassword(rs.getString("Password"));
    				user.setMetierId(rs.getInt("MetierId"));	
    			}
            	return user;
            }else{
            	return null;
            }
            
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
		

	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO `User`( `FirstName`, `LastName`, `UserName`, `Password`, `metierId`)VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getUsername()+"','"+user.getPassword()+"',"+user.getMetierId()+")";
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch(Exception e)
        {
        	e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
	}


}
