import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		//Login details
		String u=req.getParameter("Username");
		String p = req.getParameter("password");
        String cp = req.getParameter("cpwd");
		
		//Personal Details
		String n=req.getParameter("Name");
		String fn=req.getParameter("Fathername");
		String mn=req.getParameter("Mothername");
		String g=req.getParameter("Sex");
		String a=req.getParameter("Address");
		String e=req.getParameter("Email id");
		String m=req.getParameter("Mobile");
		
		//Course details
		String cn=req.getParameter("Course");
		String sm=req.getParameter("Semester");
		String se=req.getParameter("Session");
		String un=req.getParameter("University");
		String de=req.getParameter("Departments");
		//String fa=req.getParameter("Faculty");
		
		//Paper details
		String co=req.getParameter("Code");
		String title=req.getParameter("title");
		
		if(!p.equals(cp))
        {
            out.println("Password Doesn't Match! Form can't be submitted ");
            return;
        }
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","student");
		
		PreparedStatement pst =con.prepareStatement("insert into login_info values(?,?)");
		pst.setString(1,u);
		pst.setString(2,p);
		pst.executeUpdate();
		
		PreparedStatement pst1 =con.prepareStatement("insert into personal_info values(?,?,?,?,?,?,?)");
		pst1.setString(1,n);
		pst1.setString(2,fn);
		pst1.setString(3,mn);
		pst1.setString(4,g);
		pst1.setString(5,a);
		pst1.setString(6,e);
		pst1.setString(7,m);
		pst1.executeUpdate();
		
		PreparedStatement pst2 =con.prepareStatement("insert into course_info values(?,?,?,?,?)");
		pst2.setString(1,cn);
		pst2.setString(2,sm);
		pst2.setString(3,se);
		pst2.setString(4,un);
		pst2.setString(5,de);
		pst2.executeUpdate();
		
		PreparedStatement pst3 =con.prepareStatement("insert into paper_info values(?,?)");
		pst3.setString(1,co);
		pst3.setString(2,title);
		pst3.executeUpdate();
		
		out.print("Successfully Registered...");
		
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}

/*SQL> create table login_info (username varchar2(20) primary key, password varchar2(20));

Table created.

SQL> create table personal_info (name varchar2(20), fathername varchar2(20),mothername varchar2(20),
sex varchar2(20),address varchar2(20),email varchar2(20),mobile varchar2(12));

Table created.

SQL> create table course_info (course varchar2(20), sem varchar2(20),sess varchar2(20),university varchar2(40),
dept varchar2(40));

Table created.

SQL> create table paper_info (code varchar2(20),title varchar2(40));

Table created.*/
