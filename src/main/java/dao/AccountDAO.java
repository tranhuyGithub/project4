package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import context.DBContext;
import model.Account;

// Insert information of an account (a) into "Account" table 

public class AccountDAO {
	public void insert(Account a) {
		
		String sql = "insert into Account values(?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBContext.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, a.getUsr());
			pstmt.setString(2, a.getPwd());
			pstmt.setInt(3, a.getRole());
			pstmt.setString(4, a.getName());
			pstmt.setString(5, a.getAddress());
			pstmt.setString(6, a.getPhone());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	// Query and return distinct account from "Account" table by user  and pwd
	public Account getAccount(String usr, String pwd) throws Exception {
		Account a = new Account();
		
		String sql = "select top 1 * from Account where user_mail = ? and password = ?";
		try (
			Connection conn = DBContext.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			   ResultSet rs = pstmt.executeQuery();
			   if(!rs.next()) return null;
			   toAccount(rs, a);
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
		return a;
		
		
	}
	public void toAccount(ResultSet rs , Account a) throws SQLException{
		a.setUsr(rs.getString(1));
		a.setPwd(rs.getString(2));
		a.setRole(rs.getInt(3));
		a.setName(rs.getString(4));
		a.setAddress(rs.getString(5));
		a.setPhone(rs.getString(6));
		a.setCheck(0);
	}
	
	//Query and check account exits in "Account" table 
	public boolean checkAccount(String usr)throws Exception{
		
		String sql = "select top 1 * from Account where user_mail = ?";
		try (Connection conn = DBContext.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1,usr);
			ResultSet  rs = pstmt.executeQuery();
			if(rs.next()) {return true;}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	// get list information of account in "Account" table
	public List<Account> getList () throws Exception{
	    String sql = "select * from Account";
		
		List<Account> ls = new ArrayList<Account>() ;
		try (
				Connection conn = DBContext.getConnection();
				Statement stmt = conn.createStatement();
				
			){
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account a = new Account();
				toAccount(rs, a);
				ls.add(a);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}
	
	
	
	
}
