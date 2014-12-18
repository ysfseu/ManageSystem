package fr.eisti.yushaofeng.DAO;

import java.sql.SQLException;
import java.util.List;

import fr.eisti.yushaofeng.model.Metier;

public interface MetierDAO {
	public List<Metier> getAllMetiers() throws SQLException;

	public Metier getMetier(int id) throws SQLException;
	
	public void addMetier(Metier metier) throws SQLException;

	public boolean updateMetier(Metier metier) throws SQLException;

	boolean deleteMetier(Metier metier) throws SQLException;

}
