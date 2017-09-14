
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectPstOrcl 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String un="scott";
		String pwd="tiger";
		try 
		{
			Connection c =DriverManager.getConnection(url, un, pwd);
		        PreparedStatement ps=c.prepareStatement("select * from emp where ename=?");
		        while(true)
		        {
		        	System.out.println(" enter name: ");
		        	String name=sc.next();
		        	ps.setString(1, name);
		        	ResultSet rs=ps.executeQuery();
		        	while(rs.next())
		        	{
		        		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		        	}
		        	System.out.println(" do you want continue");
		        	String sr=sc.next();
					   if(sr.equalsIgnoreCase("no"))
						   break;
		        }
	System.out.println("successfully.....");
	} catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
	
	
	
	
