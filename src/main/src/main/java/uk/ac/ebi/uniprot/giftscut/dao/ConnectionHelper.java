package uk.ac.ebi.uniprot.giftscut.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHelper {
    private Properties prop;
    private static ConnectionHelper instance;

    private ConnectionHelper() {
        try {
            loadProperties();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
            ex.printStackTrace();
        }
    }

    private void loadProperties() {
        prop = new Properties();
        String propFileName = "config.properties";
        try (InputStream inputStream=    getClass().getClassLoader().getResourceAsStream(propFileName)) {

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch(IOException e) {

        }

    }

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.prop.getProperty("url"), instance.prop.getProperty("user"), instance.prop
                    .getProperty("password"));
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}