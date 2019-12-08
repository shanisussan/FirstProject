package rto.bl;
import java.util.ArrayList;

import rto.dl.PmRequestDL;
import rto.dl.RtoDL;
import rto.dl.TempDL;
import rto.dto.PmRequestDTO;
import rto.dto.PmRequestDTO;
import rto.dto.TempDTO;

public class PmRequestBL
{
	public static int addPmRequest(PmRequestDTO pmRequest)
	{
		int result=0;
		try
		{
			result=PmRequestDL.addPmRequest(pmRequest);
		}
		catch(Exception e)
		{
			System.out.print("**error**:addrto"+e.getMessage());
			
		}
		return result;
	
	}
	public static int getCount()
	{
		int count_pm_request=0;
		try
		{
			count_pm_request=PmRequestDL.getCount();	
		}
		catch(Exception e)
		{
			System.out.println("**Error**: PmRequestBL:getCount:"+e.getMessage());
		}
		return count_pm_request;
	}
	public static ArrayList<PmRequestDTO> getPMRequests()
	{
		ArrayList<PmRequestDTO> pms=null;
		
		
		try
		{
			pms=PmRequestDL.getPMRequests();
			
		}
		catch(Exception e)
		{
			System.out.println("**Error**: PmRequestBL:getPMRequests():"+e.getMessage());
		}
		return pms;
	}
	public static PmRequestDTO getPmAllot(String temp_no)
	{
		PmRequestDTO pm=null;
		try
		{
			pm=PmRequestDL.getPmAllot(temp_no);
		}
		catch(Exception e)
		{
			System.out.println("**Errorr**:RtoBL:geRto:"+e.getMessage());
		}
		return pm;
	}
}
