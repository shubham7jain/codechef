import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PushData
{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/user_service";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String args[])
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("ff_new.csv")));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = null;
			int c = 1;
			while ((line = bufferedReader.readLine()) != null)
			{
				// STEP 4: Execute a query
				String accountId = line.split("\t")[0];
				String privilegeId = line.split("\t")[1];
				String privilegeName = line.split("\t")[2];
				String value = line.split("\t")[3];
				String creationDate = line.split("\t")[4];
				String last_modified = line.split("\t")[5];
				String version = line.split("\t")[6];
				System.out.println("Inserting records into the table...");
				stmt = conn.createStatement();

				String sql =
				        "INSERT INTO Privilege " + "VALUES (" + accountId + ", " + privilegeId + ", " + privilegeName
				                + ", " + value + ", " + creationDate + ", " + last_modified + ", " + version + ");";
				stmt.executeUpdate(sql);
				System.out.println("Inserted records into the table...");
			}
		}
		catch (SQLException se)
		{
			// Handle errors for JDBC
			se.printStackTrace();
		}
		catch (Exception e)
		{

			// Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			// finally block used to close resources
			try
			{
				if (stmt != null)
					conn.close();
			}
			catch (SQLException se)
			{
			}// do nothing
			try
			{
				if (conn != null)
					conn.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}// end finally try
		}// end try
	}
}
