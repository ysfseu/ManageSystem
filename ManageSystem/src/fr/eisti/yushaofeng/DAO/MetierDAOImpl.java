package fr.eisti.yushaofeng.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eisti.yushaofeng.db.ConnectionFactory;
import fr.eisti.yushaofeng.db.DbUtil;
import fr.eisti.yushaofeng.model.Metier;

public class MetierDAOImpl implements MetierDAO {

	private  Statement statement;
	private Connection connection;
	List<Metier> metiers;
	public MetierDAOImpl(){
		metiers=new ArrayList<Metier>();
		connection=ConnectionFactory.getConnection();
	}
	@Override
	public List<Metier> getAllMetiers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metier getMetier(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Metier WHERE id=" + id;
        ResultSet rs = null;
        Metier metier = new Metier();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
				metier.setId(rs.getInt("id"));
				metier.setName(rs.getString(2));
				metier.setId(rs.getInt(3));
				
			}
            
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return metier;
	}

	@Override
	public void addMetier(Metier metier) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateMetier(Metier metier) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMetier(Metier metier) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
