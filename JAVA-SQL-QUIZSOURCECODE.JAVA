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
			// value1  = String.valueOf(value); 
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
	public static void user()
	{
		System.out.println("\t\t*****FORMAT OF THE GAME*****");
	    System.out.println("1.You should select correct answer to the questions from a given set of answers a,b,c,d");
	    System.out.println("2.It will accept boths capital and small letters as option");
	    System.out.println("3.you will get 4 points for each correct answer and -1 for wrong answers");
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
	public static void admin()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of questions");
		int NoOfQuestions = sc.nextInt();
		while(NoOfQuestions-- > 0)
		{
			//Scanner sc = new Scanner(System.in);  // Create a Scanner object

			 System.out.println("id");
		        int id = sc.nextInt();
		        sc.nextLine();

		        System.out.println("question");
		        String ques = sc.nextLine();

		        System.out.println("option1");
		        String op1 = sc.next();

		        System.out.println("option2");
		        String op2 = sc.next();

		        System.out.println("option3");
		        String op3 = sc.next();

		        System.out.println("option4");
		        String op4 = sc.next();

		        System.out.println("Enter correct answer");
		        String ans = sc.next();

		        System.out.println(id + " " + ques + " " + op1 + " " + op2 + " " + op3 + " " + op4 + " " + ans);
			    
		  
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Password987");
			PreparedStatement ps = con.prepareStatement("insert into Question values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,id );
			ps.setString(2,ques);
			ps.setString(3,op1 );
			ps.setString(4,op2 );
			ps.setString(5,op3 );
			ps.setString(6,op4 );
			ps.setString(7,ans );
			
			int count = ps.executeUpdate();
		
				if(count > 0)
				{
					System.out.println("Questions entered sucessfully");
					
				}
				else
				{
					System.out.println("error");
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	public static void start()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Admin\n2.User");
		int n = sc.nextInt();
		if(n==1)
			admin();
		else if(n==2)
			user();
		
		System.out.println("if u what to re enter");
		char a = sc.next().charAt(0);
		if(a == 'Y')
			start();
		else
			System.out.println("byeeee!");
		
	}
	public static void main(String args[])
	{
		
		start();
		
		
		
		
		
	}
}

