package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CheckLoginBO {
	
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	
	public boolean isValidUser(String username, String password) {
		return checkLoginDAO.isExitUser(username, password);
	}
	
	public boolean checkLogin(String username, String pass) {
		return checkLoginDAO.isExitUser(username, pass);
	}
	
	public boolean createUser(String fname, String lname, String username, String pass, String role) {
		return checkLoginDAO.createUser(fname, lname, username, pass, role);
	}

	public ResultSet getAll() {
		return checkLoginDAO.getAll();
	}
//	
//	public ResultSet getNV() {
//		return checkLoginDAO.getNV();
//	}
	
//	public ResultSet getNVPB(int id) {
//		return checkLoginDAO.getNVPB(id);
//	}
	
//	public ResultSet getOne_PB(int id) {
//		return checkLoginDAO.getOne_PB(id);
//	}
//	
//	public void updatePB(String id, String TenPB, String MoTa) {
//		checkLoginDAO.updatePB(id, TenPB, MoTa);
//	}
	
	public void deleteUser(String id) {
		checkLoginDAO.deleteUser(id);
	}
	
	public ResultSet findUser(String field, String value) {
		return checkLoginDAO.findUser(field, value);
	}
	
	
	
	
//	public static void main(String[] args) {
//		ArrayList<PhongBan> data = checkLoginDAO.getPB();
//		System.out.println(data.size());
//		
//	}
}
