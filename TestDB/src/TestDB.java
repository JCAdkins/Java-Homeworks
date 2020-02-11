import java.io.File;
import java.sql.*;
import com.microsoft.sqlserver.*;

public class TestDB {

	public static void main(String[] args) throws Exception {

		String userName = "jcadkins";
		String password = "Password2";

		String url = "jdbc:sqlserver://awsdb.c7xm7gdw2r6x.us-east-2.rds.amazonaws.com:1433;databaseName=redditdb";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try (Connection conn = DriverManager.getConnection(url, userName, password);) {
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT TOP (1000) * FROM [riotdb].[dbo].[Champion]");
			
			while(result.next()) {
			System.out.println(result.getString("Name") + ": " + result.getString("title") + "\n");
			}
		}

	}

}
