package fr.eisti.yushaofeng.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import fr.eisti.yushaofeng.db.ConnectionFactory;
import fr.eisti.yushaofeng.db.DbUtil;

public class QueryTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int colCount;
	Vector<String[]> cache;
	String tableName;
	String[] columnNames;
	//List<User> users;
	Connection con;
	Statement statement;
	ResultSet rs;
	ResultSetMetaData meta;
	/*{
		cache = new Vector();
		con = ConnectionFactory.getConnection();
		this.setQuery();
	}*/
	public QueryTableModel(String tableName) {
		super();
		cache = new Vector<String[]>();
		con = ConnectionFactory.getConnection();
		this.tableName=tableName;
		this.setQuery();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cache.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		return ((String[]) cache.elementAt(rowIndex))[columnIndex];
	}
	public String getColumnName(int column) {
	    return columnNames[column];
	}
	public void setQuery() {
		String q = "select * from "+tableName;
		cache = new Vector<String[]>();
		try {
			statement = (Statement) con.createStatement();
			rs = statement.executeQuery(q);
			meta = (ResultSetMetaData) rs.getMetaData();
			colCount = meta.getColumnCount();
			columnNames = new String[colCount];
			for (int h = 1; h <= colCount; h++) {
				columnNames[h-1] = meta.getColumnName(h);
				System.out.println(columnNames[h-1]);
			}
			while (rs.next()) {
				String[] record = new String[colCount];
				for (int i = 0; i < colCount; i++) {
					record[i] = rs.getString(i + 1);
				}
				cache.addElement(record);
			}
			fireTableChanged(null);
		} catch (Exception e) {
			cache = new Vector<String[]>();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(con);
		}
	}

}
