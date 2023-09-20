
import java.util.*;
import java.sql.*;

public class QUIZ {
	
	Random rm = new Random();
	int value;
	String ans,ans1;
	int marks = 0;
	int k=3;
	String temp;
	Scanner sc = new Scanner(System.in);
	public static String call()
    {
        Scanner sc= new Scanner(System.in);
        String option;
        System.out.println("enter your option again:");
		option= sc.next();
		
        return option;
    }
	void connectDB()
	{
		Connection  con = null;
		while(k-->0)
		{
			value = rm.nextInt(5) + 1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Password987");
			//Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from Question where id=?");
			ps.setInt(1,value);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString("question"));
				System.out.println(rs.getString("option1"));
				System.out.println(rs.getString("option2"));
				System.out.println(rs.getString("option3"));
				System.out.println(rs.getString("option4"));
				ans1 = rs.getString("crtanswer");
			}
			System.out.println("Enter ur option");
			ans = sc.next();
			System.out.println(ans);
			if(ans.equals("a") ||ans.equals("b")||ans.equals("c") ||ans.equals("d")||ans.equals("A")||ans.equals("B")||ans.equals("C")||ans.equals("D") )
			{
			    System.out.println("valid options");
			}
			else
			{
			    System.out.println("Invalid options");
			    ans=call();
			}
			ans=ans.toUpperCase();
			if(ans.equals(ans1))
			{
				marks+=4;
				System.out.println("crt");
			}
			else if(!ans.equals(ans1))
			{
				marks -=1; 
				System.out.println("wrong");
			}
			
		}
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
	}
	public static void main(String args[])
	{
		
		System.out.println("\t\t*****FORMAT OF THE GAME*****");
	    System.out.println("1.You should select correct answer to the questions from a given set of ansers a,b,c,d");
	    System.out.println("2.It will accept boths capital and small letters as option");
	    System.out.println("3.you will get 4 points for each correct answer and -1 for wrong ansers\n\n\n");
	    System.out.println("4.if you enter an invalid option you can reenter the option only once\n\n\n");
	    
	    
	    System.out.println("ENETR UR NAME:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		
		
		QUIZ x = new QUIZ();
		x.connectDB();
		
		
		System.out.println("\n\n\n");
		System.out.println("\t\t*****RESULTS*****");
		System.out.println("\tNAME\t"+name+"\tMARKS\t"+x.marks);
		//System.out.println("ur score is:"+x.marks);
	}
}
