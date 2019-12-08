package rto.dl;
import java.sql.*;
import java.util.ArrayList;

import rto.dl.DBHelper;
import rto.dto.PmRequestDTO;
import rto.dto.RtoDTO;
import rto.dto.TempDTO;

public class PmRequestDL {

//method to add permenant request to database while submitting

			public static int addPmRequest(PmRequestDTO pmRequest)
			{
				int result=0;
				String query;
				PreparedStatement ps=null;
				Connection con;
				try
				{
					con=DBHelper.getConnection();
					query="INSERT INTO tb_pm_request(application_no,Temp_no,cus_name,chassis_no,tp_allot_date,status) VALUES(?,?,?,?,?,?)";
					ps=con.prepareStatement(query);
					ps.setString(1,pmRequest.getApplication_no());
					ps.setString(2, pmRequest.getTemp_no());
					ps.setString(3, pmRequest.getCus_name());
					ps.setString(4, pmRequest.getChassis_no());
					ps.setString(5,pmRequest.getTp_allot_date());
					ps.setInt(6,pmRequest.getCount());
                    result=ps.executeUpdate();
					
					
					
				}
				catch(Exception e)
				{
					result = -1;
					System.out.print("**error**:addpmRequest"+e.getMessage());
					
				}
				return result;
			}
			public static int getCount()
			{
				Connection con=null;
				Statement statement=null;
				ResultSet resultSet=null;
				int count_pm_request=0;
				PmRequestDTO pm=null;
				try
				{
					String sql="select count(*) as total from tb_pm_request where status=0 ";
					con=DBHelper.getConnection();
					statement=con.createStatement();
					resultSet=statement.executeQuery(sql);
					if(resultSet.next())
					{
						count_pm_request=resultSet.getInt("total");
					}
					
				}
				catch(Exception e)
				{
					System.out.println("**Error**: PmRequestDL:getCount:"+e.getMessage());
				}
				return count_pm_request;
			}
			
			public static ArrayList<PmRequestDTO> getPMRequests()
			{
				ArrayList<PmRequestDTO> pms=null;
				Connection con=null;
				Statement statement=null;
				ResultSet resultSet=null;
				PmRequestDTO pm=null;
				try
				{
					pms=new ArrayList<PmRequestDTO>();
					con=DBHelper.getConnection();
					statement=con.createStatement();
					String sql="select * from tb_pm_request";
					resultSet=statement.executeQuery(sql);
					while(resultSet.next())
					{
						pm=new PmRequestDTO();
						pm.setApplication_no(resultSet.getString("application_no"));
						pm.setTemp_no(resultSet.getString("Temp_no"));
						pm.setCus_name(resultSet.getString("cus_name"));
						pm.setChassis_no(resultSet.getString("chassis_no"));
						pm.setTp_allot_date(resultSet.getString("tp_allot_date"));
						pms.add(pm);
					}
					resultSet.close();
					statement.close();
					con.close();
				}
				catch(Exception e)
				{
				
					System.out.println("**Error**: PmRequestDL:getPmRequests():"+e.getMessage());
				}
				return pms;
			}
			public static PmRequestDTO getPmAllot( String temp_no)
			{
				Connection con=null;
				PmRequestDTO pm=null;
				Statement statement=null;
				ResultSet resultSet=null;
				try
				{
					con=DBHelper.getConnection();
					statement = con.createStatement();
					String sql="select * from tb_pm_request where temp_no='"+temp_no+"'";
					resultSet = statement.executeQuery(sql);
					if(resultSet.next())
					{
						pm=new PmRequestDTO();
						pm=new PmRequestDTO();
						pm.setApplication_no(resultSet.getString("application_no"));
						pm.setTemp_no(resultSet.getString("Temp_no"));
						pm.setCus_name(resultSet.getString("cus_name"));
						pm.setChassis_no(resultSet.getString("chassis_no"));
						pm.setTp_allot_date(resultSet.getString("tp_allot_date"));
					
						}
					
				}
				catch(Exception e)
				{
					System.out.print("**error**:RtoDl:getRto"+e.getMessage());
					
				}
				return pm;
			}
		
}