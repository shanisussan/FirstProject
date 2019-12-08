<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,rto.dl.*,rto.dto.*,rto.bl.*"%>
    <%!
	String application_no,cus_name,temp_no,chassis_no,ExpireDate,TempAllotDate;
    int result=0,result2=0,status=1;
    
   TempDTO temp=null;
    %>
    <%
   temp= new TempDTO();
    try
    {
    application_no=request.getParameter("application_no");
    cus_name=request.getParameter("cus_name");
    temp_no=request.getParameter("temp_no");
    chassis_no=request.getParameter("chassis_no");
    TempAllotDate=request.getParameter("TempAllotDate");
    ExpireDate=request.getParameter("ExpireDate");
    System.out.println("app"+application_no);
    System.out.println("app"+cus_name);
    System.out.println("app"+temp_no);
    System.out.println("app"+chassis_no);
    System.out.println("app"+TempAllotDate);
    System.out.println("app"+ExpireDate);
    
    
	 temp.setApplication_no(application_no)  ;                                                                   
     temp.setCus_name(cus_name);
     temp.setTemp_no(temp_no);
     temp.setChassis_no(chassis_no);
     temp.setTp_allot_date(TempAllotDate);
     temp.setExpiry_date(ExpireDate);
     temp.setStatus(status); 
     result=TempDL.allotedTP(temp);
     result2=TempDL.UpdateStatus(temp);
     
     if(result>0){
    	 session.setAttribute("message","Temporary Number Alloted");
    	 
     }
     else{
    	 
    	 session.setAttribute("message", "Temporary Number Not Alloted");
    	 
    	 
     }
    
response.sendRedirect("tp_approve.jsp");
}

    catch(Exception e)
    {
    	System.out.println("**errorr** RTO: Register_process.jsp:"+e.getMessage());
    	session.setAttribute("message", "please enter a valid number");
    	response.sendRedirect("RTOHome.jsp");
    }
%>