package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory
{
	public static Connection createConnection(String dbName)
	{
		String connectionData = "jdbc:mysql://localhost:3306/"+dbName;

		try
		{
			Connection con = DriverManager.getConnection(connectionData,"jaita","jaita");
			System.out.println("Connessione al db riuscita");
			return con;
		}catch (Exception e)
		{
			System.out.println("CONNESSIONE AL DB FALLITA");
			System.exit(-1);
			return null;
		}
	}
}
