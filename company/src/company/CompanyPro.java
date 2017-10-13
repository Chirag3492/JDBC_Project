package company;
import java.sql.*;
import java.util.Scanner;

public class CompanyPro {
	
	void getData(){	//fetch the data from the database
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydemo","chirag3492", "root");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from employees");
			
			while(rs.next()){
				System.out.println("id is: " + rs.getInt(1));
				System.out.println("name is: " + rs.getString(2));
				System.out.println("age is: " + rs.getInt(3));
				System.out.println("address is: " + rs.getString(4));
				
				System.out.println("-----------------------------------------------");
			}
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
     	}
	
	}
	void insertData(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydemo","chirag3492", "root");
			
			Statement st = con.createStatement();
			
			String query = "insert into employees(emp_id, emp_name, emp_age, emp_addr) values(?, ?, ?,?)";
			
			PreparedStatement p = con.prepareStatement(query);
			
			System.out.println("Enter employee's id, name, age and  address:");
			Scanner sc = new Scanner(System.in);
			int emp_id = sc.nextInt();
			String emp_name = sc.next();
			int emp_age = sc.nextInt();
			String emp_addr = sc.next();
			
			p.setInt(1, emp_id);
			p.setString(2, emp_name);
			p.setInt(3, emp_age);
			p.setString(4, emp_addr);
			
			p.execute();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void deleteData(int emp_id){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydemo","chirag3492", "root");
			
			Statement st = con.createStatement();
			
			String query = "delete from employees where emp_id = ?";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, emp_id);
			
			p.execute();
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	void deleteRecord(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); //when we run our app, forName class will load the driver
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydemo","chirag3492", "root");
			
			Statement st = con.createStatement();
			
			String query = "drop table employees";
			
			PreparedStatement p = con.prepareStatement(query);
			
			p.execute();
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		CompanyPro c = new CompanyPro();
	    /*c.getData();
      	for(int i=0; i<2;i++){
	 	c.insertData();
		}
	
	   System.out.println("After insertion:");
		c.getData();
		*/
     //	c.deleteData(3);
		 
		c.deleteRecord();
		
     //c.getData();
	}

}


