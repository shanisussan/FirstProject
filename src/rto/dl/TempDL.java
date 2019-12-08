package rto.dl;
import java.sql.*;
import java.util.ArrayList;

import rto.dto.TempDTO;
public class TempDL
{
	public static int addTempoRequest(TempDTO temp)
	{
		int result=0;
		String query;
		PreparedStatement ps=null;
		Connection con;
		try
		{
			con=DBHelper.getConnection();
			query="insert into tb_temp_request(application_no,cus_name,cus_email,cus_phone,cus_address,cus_adhar,"
					+ "chassis_no,engine_no,ownership,v_type,v_class,fuel,purchase_date,seating,color,sale_amount,company_name,status)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1,temp.getApplication_no());
			ps.setString(2,temp.getCus_name());
			ps.setString(3, temp.getCus_email());
			ps.setLong(4, temp.getCus_phone());
			ps.setString(5, temp.getCus_address());
			ps.setString(6, temp.getCus_adhar());
			ps.setString(7, temp.getApplication_no());
			ps.setString(8, temp.getApplication_no());
			ps.setString(9, temp.getOwnership());
			ps.setString(10, temp.getV_type());
			ps.setString(11, temp.getV_class());
			ps.setString(12, temp.getFuel());
			ps.setString(13,temp.getPuchase_date());
			ps.setInt(14,temp.getSeating());
			ps.setString(15, temp.getColor());
			ps.setDouble(16,temp.getSale_amount());
			ps.setString(17, temp.getCompany_name());
			ps.setInt(18, temp.getStatus());
			result=ps.executeUpdate();
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**Error**: TempDL:addTempoRequest:"+e.getMessage());
		}
		return result;
	}
	public static ArrayList<TempDTO> getTempRequests()
	{
		ArrayList<TempDTO> temps=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		TempDTO temp=null;
		try
		{
			temps=new ArrayList<TempDTO>();
			
			String sql="select * from tb_temp_request";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next())
			{
				temp=new TempDTO();
				temp.setApplication_no(resultSet.getString("application_no"));
				temp.setCus_name(resultSet.getString("cus_name"));
				temp.setCus_email(resultSet.getString("cus_email"));
				temp.setCus_address(resultSet.getString("cus_address"));
				temp.setCus_adhar(resultSet.getString("cus_adhar"));
				temp.setChassis_no(resultSet.getString("chassis_no"));
				temp.setEngine_no(resultSet.getString("engine_no"));
				temp.setOwnership(resultSet.getString("ownership"));
				temp.setV_type(resultSet.getString("v_type"));
				temp.setV_class(resultSet.getString("v_class"));
				temp.setFuel(resultSet.getString("fuel"));
				temp.setColor(resultSet.getString("color"));
				temp.setCompany_name(resultSet.getString("company_name"));
				temp.setPuchase_date(resultSet.getString("purchase_date"));
				temp.setCus_phone(resultSet.getLong("cus_phone"));
				temp.setSeating(resultSet.getInt("seating"));
				temp.setSale_amount(resultSet.getDouble("sale_amount"));
				
				temps.add(temp);
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch(Exception e)
		{
		
			System.out.println("**Error**: TempDL:getTempRequests():"+e.getMessage());
		}
		return temps;
	}
	public static int deleteTempRequest(String application_no)
	{
		String query;
		PreparedStatement ps=null;
		Connection con;
		int result=0;
		try
		{
			con=DBHelper.getConnection();
			query="delete from tb_temp_request where application_no=?";
			ps=con.prepareStatement(query);
			ps.setString(1,application_no);
			result=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("**Error**: TempDL:deleteTempRequest:"+e.getMessage());
		}
		return result;
	}
	public static TempDTO getTempRequest(String application_no)
	{
		TempDTO temp=null;
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try
		{
			String sql="select * from tb_temp_request where application_no='"+application_no + "'";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
				temp=new TempDTO();
				temp.setApplication_no(resultSet.getString("application_no"));
				temp.setCus_name(resultSet.getString("cus_name"));
				temp.setCus_email(resultSet.getString("cus_email"));
				temp.setCus_address(resultSet.getString("cus_address"));
				temp.setCus_adhar(resultSet.getString("cus_adhar"));
				temp.setChassis_no(resultSet.getString("chassis_no"));
				temp.setEngine_no(resultSet.getString("engine_no"));
				temp.setOwnership(resultSet.getString("ownership"));
				temp.setV_type(resultSet.getString("v_type"));
				temp.setV_class(resultSet.getString("v_class"));
				temp.setFuel(resultSet.getString("fuel"));
				temp.setColor(resultSet.getString("color"));
				temp.setCompany_name(resultSet.getString("company_name"));
				temp.setPuchase_date(resultSet.getString("purchase_date"));
				temp.setCus_phone(resultSet.getLong("cus_phone"));
				temp.setSeating(resultSet.getInt("seating"));
				temp.setSale_amount(resultSet.getDouble("sale_amount"));
				
			}
			resultSet.close();
			statement.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("**Error**: TempDL:getTempRequest:"+e.getMessage());
			e.printStackTrace();
		}
		return temp;
	}
	
	public static int updateTempRequest(TempDTO temp)
	{
		String query;
		PreparedStatement ps=null;
		Connection con;
		int result=0;
		try
		{
			con=DBHelper.getConnection();				
			query="UPDATE tb_temp_request SET cus_name=?,cus_email=?,cus_phone=?,cus_address=?,cus_adhar=?,"
					+ "chassis_no=?,engine_no=?,ownership=?,v_type=?,v_class=?,fuel=?,purchase_date=?,"
					+ "seating=?,color=?,sale_amount=?,company_name=?,status=? WHERE application_no=?";
			ps=con.prepareStatement(query);
			ps.setString(1,temp.getCus_name());
			ps.setString(2, temp.getCus_email());
			ps.setLong(3, temp.getCus_phone());
			ps.setString(4, temp.getCus_address());
			ps.setString(5, temp.getCus_adhar());
			ps.setString(6, temp.getApplication_no());
			ps.setString(7, temp.getApplication_no());
			ps.setString(8, temp.getOwnership());
			ps.setString(9, temp.getV_type());
			ps.setString(10, temp.getV_class());
			ps.setString(11, temp.getFuel());
			ps.setString(12,temp.getPuchase_date());
			ps.setInt(13,temp.getSeating());
			ps.setString(14, temp.getColor());
			ps.setDouble(15,temp.getSale_amount());
			ps.setString(16, temp.getCompany_name());
			ps.setString(17,temp.getApplication_no());
			ps.setInt(18, temp.getStatus());
			result=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			result=-1;
			System.out.println("**Error**: TempDL:updateBook:"+e.getMessage());
		}
		return result;
	}
	public static int getCount()
	{
		Connection con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		int count_tp_request=0;
		TempDTO temp=null;
		try
		{
			String sql="select count(*) as total from tb_temp_request where status=0 ";
			con=DBHelper.getConnection();
			statement=con.createStatement();
			resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
				count_tp_request=resultSet.getInt("total");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("**Error**: TempDL:getCount:"+e.getMessage());
		}
		return count_tp_request;
	}
	
}
