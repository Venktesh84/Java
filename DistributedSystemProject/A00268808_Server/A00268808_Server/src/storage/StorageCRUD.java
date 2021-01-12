package storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StorageCRUD {

	/**
	 * Fetches list of all stored items
	 * @return List of storage model objects
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	@SuppressWarnings("null")
	public List<StorageModel> getAllStoredItemsInformation() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<StorageModel> itemsList = null;
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB","SA", "Passw0rd");
		Statement stmt = con.createStatement();
		ResultSet rs;
		String n = "y";
		rs = stmt.executeQuery("Select * from Items");
		itemsList = new ArrayList<StorageModel>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			int cabinet = rs.getInt("CABINET");
			String number = rs.getString("NUMBER");
			StorageModel it = new StorageModel(id, name, number, cabinet);
			itemsList.add(it);
		}

		return itemsList;
	}
	
	/**
	 * Fetches storage model object for single id
	 * @return storage model object
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	public StorageModel getStoredItemInfo(int id) throws ClassNotFoundException, SQLException {
		
		List<StorageModel> users = getAllStoredItemsInformation();
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		ResultSet rs;
		StorageModel user = null;
		String sql = "SELECT ID,NAME,NUMBER,CABINET FROM Items where ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		while (rs.next()) {

			int id1 = rs.getInt("ID");
			String name1 = rs.getString("NAME");
			int cabinet1 = rs.getInt("AREA");
			String number1 = rs.getString("NUMB");
			StorageModel item = new StorageModel(id1, name1, number1, cabinet1);
		}

		return user;

	}
	
	/**
	 * Inserts the items in the database
	 * @return Number of rows added in the database
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	public int storeItem(StorageModel pUser) throws ClassNotFoundException, SQLException {

		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		String sql = "insert into Items(ID,NAME,NUMBER,CABINET) values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st = con.prepareStatement(sql);
		st.setInt(1, pUser.getId());
		st.setString(2, pUser.getName());
		st.setString(3, pUser.getNumber());
		st.setInt(4, pUser.getCabinet());
		int num = st.executeUpdate();
		return num;
	}
	
	
	/**
	 * Updates the row in database
	 * @return number of rows updated
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	public int updateStoredItemInfo(StorageModel pUser) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd"); 
		String sql = "UPDATE Items SET ID =?,NAME =?,NUMBER =?,CABINET =? WHERE ID =? ";
		PreparedStatement st = con.prepareStatement(sql);
		st = con.prepareStatement(sql);
		st.setInt(1, pUser.getId());
		st.setString(2, pUser.getName());
		st.setString(3, pUser.getNumber());
		st.setInt(4, pUser.getCabinet());		
		st.setInt(5, pUser.getId());
		int num = st.executeUpdate();
		return num;
	}
	
	/**
	 * Deletes the item in the database
	 * @return List of storage model objects
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	public int deliverItem(int id) throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		String sql = "Delete from Items where ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		int num = st.executeUpdate();
		return num;
	}
	
	/**
	 * Fetches list of all stored items
	 * @return List of storage model objects
	 * @throws SQLException Issue related to the database
	 * @throws ClassNotFoundException Issue related to jdbc drivers
	 */
	private void saveItemList(List<StorageModel> userList) throws IOException {

		File file = new File("Users.dat");
		FileOutputStream fos;

		fos = new FileOutputStream(file);

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(userList);
		oos.close();

	}




}
