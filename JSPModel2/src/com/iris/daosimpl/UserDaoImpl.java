package com.iris.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.utility.ConnectionProvider;

public class UserDaoImpl implements UserDao {
	
	Connection conn=ConnectionProvider.getConn();
	
	@Override
	public boolean registerUser(User cObj) {
		try {
		PreparedStatement ps=conn.prepareStatement("insert into UserTab values(customerseq.nextval,?,?,?,?,?,?)");
		ps.setString(1, cObj.getFirstName());
		ps.setString(2, cObj.getLastName());
		ps.setString(3, cObj.getGender());
		ps.setString(4, cObj.getCity());
		ps.setString(5, cObj.getRole());
		ps.setString(6, cObj.getPassword());
		
		int i=ps.executeUpdate();
		if(i!=0) {
			return true;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User loginUser(int userId, String password) {
		try {
		PreparedStatement ps=conn.prepareStatement("select * from UserTab where UserId=? and Password=?");
		ps.setInt(1,userId);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			User cObj=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			return cObj;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from UserTab where role='User'");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				User uObj=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				userList.add(uObj);
				
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public boolean deleteUser(int userId) throws Exception {
			PreparedStatement ps=conn.prepareStatement("delete from UserTab where UserId=?");
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}

}
}
