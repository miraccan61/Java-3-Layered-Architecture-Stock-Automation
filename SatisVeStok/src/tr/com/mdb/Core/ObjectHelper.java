package tr.com.mdb.Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tr.com.mdb.Interfaces.CoreInterfaces;

public class ObjectHelper extends CoreFields implements CoreInterfaces {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("MySQL Connector yok");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
		} catch (SQLException e) {
			System.out.println("Baðlantý Baþarýsýz");
			e.printStackTrace();
		}

		return connection;
	}

}
