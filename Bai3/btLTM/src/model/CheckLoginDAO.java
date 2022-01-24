package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckLoginDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test888", "root", "");
		    System.out.println( "database successfully opened.");
		    return con;
		}
		  catch(SQLException | ClassNotFoundException e) {
		    System.out.println("SQLException caught: " +e.getMessage());
		  }
		return null;
	}
	
	public boolean isExitUser ( String user, String pass) {
        boolean v = true;
		try {
			
		    Connection con = getConnection();
	        PreparedStatement stmt = con.prepareStatement("select * from user where userName = ? and password = ? ");
	        stmt.setString(1, user);
	        stmt.setString(2, pass);
	        ResultSet rs = stmt.executeQuery();
	    	   
		       	if(rs.next()) {
		       		System.out.println("heheheh");
		       		v = true;
		       	}
		       	else {
		       		v = false;
		       	}
		       	
	        
	       	stmt.close();
	        con.close();
		  }
		  catch(SQLException e) {
		    System.out.println("SQLException caught: " +e.getMessage());
		  }
		return v;
	}
	
	public boolean createUser(String fname, String lname, String username,String pass , String role) {
		Connection con = getConnection();
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("insert into user values (null,? , ?, ? ,? , ?)");
			stmt.setString(1, fname);
	        stmt.setString(2, lname);
	        stmt.setString(3, username);

	        stmt.setString(4, pass);
	        stmt.setString(5, role);
	        
	        stmt.execute();
	        return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;
	}
	
//	public ArrayList<Wife> getWifeList( String username) {
//		Connection con = getConnection();
//		
//		ArrayList<Wife> result = new ArrayList<Wife>();
//		PreparedStatement stmt;
//		try {
//			stmt = con.prepareStatement("select * from wife");
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.println(rs.getString(1));
//				Wife wife = new Wife();
//				wife.setName(rs.getString(1));
//				wife.setAddress(rs.getString(2));
//				wife.setAlive(rs.getBoolean(3));
//				result.add(wife);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	ResultSet getAll() {
		Connection con = getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from user");
	        ResultSet result = stmt.executeQuery();
	        return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	
	ResultSet getNV() {
		Connection con = getConnection();
		ArrayList<PhongBan> list = new ArrayList<PhongBan>();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from nhanvien ");
	        ResultSet result = stmt.executeQuery();
//	        while( result.next()) {
//	        	System.out.println(result.getString(3));
//	        	PhongBan pb = new PhongBan(result.getInt(1), result.getString(2), result.getString(3));
//	        	System.out.println(pb.getMoTa());
//	        	list.add(pb);
//	        }
	        return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
//		return list;
		return null;
	}
	
	ResultSet findUser(String field , String value) {
		Connection con = getConnection();
		PreparedStatement stmt;
		try {
			String query = "SELECT * FROM `user` WHERE "+ field +" LIKE '%"+ value+"%'";
			System.out.println(query);
			stmt = con.prepareStatement(query);
	        ResultSet result = stmt.executeQuery();
	        return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	
	ResultSet getOne_PB(int IDPB) {
		Connection con = getConnection();
		ArrayList<PhongBan> list = new ArrayList<PhongBan>();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from phongban where IDPB = ? ");
			stmt.setString(1, String.valueOf(IDPB));
	        ResultSet result = stmt.executeQuery();
	        return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	
	void  updatePB(String id, String TenPB, String MoTa) {
		Connection con = getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("update phongban set TenPB = ?, MoTa = ? where IDPB = ? ");
			stmt.setString(3, String.valueOf(id));
			stmt.setString(1, String.valueOf(TenPB));
			stmt.setString(2, String.valueOf(MoTa));
	        stmt.execute();
	        return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return;
	}
	
	void  deleteUser(String id) {
		Connection con = getConnection();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from user where id = ? ");
			stmt.setString(1, (id));
	        stmt.execute();
	        return;
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
}
