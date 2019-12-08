package rto.dl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rto.dl.DBHelper;
import rto.dto.User;
public class UserDL
{
	public static User validateUser(User user1)
	{
		User user2=null;
		Connection con=null;
		ResultSet resultSet=null;
		
		try
		{
			String sql="select * from tbl_login where user_ID=? and password=?";
			con=DBHelper.getConnection();
			PreparedStatement ps=null;
			ps=con.prepareStatement(sql);
			ps.setString(1, user1.getUser_ID());
			ps.setString(2, user1.getPassword());
			resultSet=ps.executeQuery();
			if(resultSet.next())
			{
				user2=new User();
				user2.setUser_ID(resultSet.getString("USER_ID"));
				user2.setUsername(resultSet.getString("USERNAME"));	
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("**Error**: UserDL:validateUser:"+e.getMessage());
		}
		return user2;
	}
	public static ResultSet validateUser1(String u,String p)
	{
		User user2=null;
		Connection con=null;
		ResultSet rs=null;
		
		try
		{
			String sql="select * from tbl_login where user_ID=? and password=?";
			con=DBHelper.getConnection();
			PreparedStatement ps=null;
			ps=con.prepareStatement(sql);
			ps.setString(1, u);
			ps.setString(2, p);
			rs=ps.executeQuery();
			
			
		}
		catch(Exception e)
		{
			System.out.println("**Error**: UserDL:validateUser1:"+e.getMessage());
		}
		return rs;
	}
}
