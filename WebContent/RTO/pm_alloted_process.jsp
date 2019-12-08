<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,rto.dl.*,rto.dto.*,rto.bl.*"%>
    <%!
	String application_no,cus_name,temp_no,chassis_no,permanent_no;
    int result=0,result2=0;
    
   PmRequestDTO pm=null;
    %>
    <%
   pm= new PmRequestDTO();
    try
    {
    application_no=request.getParameter("application_no");
    cus_name=request.getParameter("cus_name");
    temp_no=request.getParameter("temp_no");
    chassis_no=request.getParameter("chassis_no");
    permanent_no=request.getParameter("permanent_no");
    
	 pm.setApplication_no(application_no)  ;                                                                   
     pm.setCus_name(cus_name);
     pm.setTemp_no(temp_no);
     pm.setChassis_no(chassis_no);
     pm.setPermanent_no(permanent_no);                                                                                                              
     result=PmRequestBL.allotedPM(pm);
     
     pm.setStatus(1);                                                                                                             
     result2=PmRequestBL.UpdateStatus(pm);
     
     if(result>0){
    	 session.setAttribute("message","Permanent Number Alloted");
    	 
     }
     else{
    	 
    	 session.setAttribute("message", "Permanent Number Alloted");
    	 
    	 
     }
    
response.sendRedirect("view_pm_request.jsp");
}

    catch(Exception e)
    {
    	System.out.println("**errorr** RTO: Register_process.jsp:"+e.getMessage());
    	session.setAttribute("message", "please enter a valid number");
    	response.sendRedirect("Rto_register.jsp");
    }
%>