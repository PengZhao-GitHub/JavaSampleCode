import java.sql.*;

public class MyTest {
	
	public static void main(String argv[]) {

		try {
			//Loading Drivers
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			//Making the Connection
			String url = "jdbc:odbc:MyOra";
			Connection con = DriverManager.getConnection(url,"deriva","deriva");
			System.out.println("Connected");
			/*
			/**
			 * DDL: create table, drop table , alter table		
			 */	
			//Create a statement object
			Statement stmt = con.createStatement();
			
			//Dorp the table jdbcTestTable
			String dropSql	= "drop table jdbcTestTable";
			stmt.executeUpdate(dropSql);			

			//Create a table
			String createSql = "create table jdbcTestTable( a char(5), b char(5), c char(5))";
			stmt.executeUpdate(createSql);	
			con.commit();

			//Alter a table
			String alterSql = "alter table jdbcTestTable " + 
					  "add d char(5)";
			stmt.executeUpdate(alterSql);

			/**
			  * DML: insert, select, delete, update
			  */
			//Insert records to the table
			stmt.executeUpdate(
				"insert into jdbcTestTable " + 
				"values('a1','b1','c1')");
			stmt.executeUpdate(
				"insert into jdbcTestTable " + 
				"values('a2','b2','c2')");
			stmt.executeUpdate(
				"insert into jdbcTestTable " + 
				"values('a3','a3','a3')");
			con.commit();

			//Retrieving Values from Result sets
			ResultSet rs = stmt.executeQuery("select * from jdbcTestTable");
			
			while(rs.next()) {
				System.out.print(rs.getString("a") + " ");
				System.out.print(rs.getString("b") + " ");
				System.out.println(rs.getString("c") + " ");
			}

			//Update the table
			stmt.executeUpdate(
				"update jdbcTestTable " +
				"set a ='DOWN'");	
			*/
			rs = stmt.executeQuery("select * from jdbcTestTable");
			ResultSet rs2;
			while(rs.next()) {
				System.out.print(rs.getString("a") + " ");
				System.out.print(rs.getString("b") + " ");
				System.out.println(rs.getString("c") + " ");
				rs2 = stmt.executeQuery("select * from ccy");
				while(rs2.next()) {
					System.out.print(rs2.getString(1));		
				}
			}

			/*
			//Delete from the table
			String deleteSql = "delete from jdbcTestTable";
			stmt.executeUpdate(deleteSql);

			/**
			 * DCL: grant, revoke
			 */
			String grantSql = "GRANT SELECT ON jdbcTestTable TO test";
			stmt.execute(grantSql);
			*/
	
		}
		catch (ClassNotFoundException ex1) {
			System.out.println(ex1);
		}
		catch (SQLException ex2) {
			System.out.println(ex2);

		}
		
	}

}
