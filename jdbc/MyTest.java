import java.sql.*;

public class MyTest {
	
	public static void main(String argv[]) {

		try {
			//Loading Drivers
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			//Making the Connection
			String url = "jdbc:odbc:suya";
			Connection con = DriverManager.getConnection(url,"system","manager");
			System.out.println("Connected");
		
			/**
			 * DDL: create table, drop table , alter table		
			 */	
			//Create a statement object
			Statement stmt = con.createStatement();
			
			//Dorp the table jdbcTestTable
			String dropSql	= "drop table peng";
			stmt.executeUpdate(dropSql);			

			//Create a table
			String createSql = "create table peng( a varchar(2000), b char(5), c char(5))";
			stmt.executeUpdate(createSql);	
			con.commit();

			ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM peng");
			ResultSetMetaData rsmd = rs.getMetaData();
 
			//a‚Ì’·‚³
			int len_a = rsmd.getColumnDisplaySize(1);
			System.out.println("varchar's lenght = "+len_a);

			String str = ""; 
			for (int i=0; i < 500; i++){
				str = str + "‚ ";
			}

			System.out.println("Insert string's length = " + str.getBytes().length);

			//Insert the str to db
			stmt.executeUpdate("Insert into peng(a) " + 
					  "values('" + str + "')"); 

			System.out.println("Inserted!");
		}
		catch (ClassNotFoundException ex1) {
			System.out.println(ex1);
		}
		catch (SQLException ex2) {
			System.out.println(ex2);

		}
		
	}

}
