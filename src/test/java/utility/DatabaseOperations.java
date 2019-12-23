package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseOperations {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseOperations.class);
    private Connection connection = null;
    private Statement stmt;

	 public List<String> executeQuery(String query, String databaseColumName,String databaseConnectionURL, String username,
	            String password) throws ClassNotFoundException {

	        List<String> tableColumnValues = new ArrayList<String>();

	        try {
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            connection = DriverManager.getConnection(databaseConnectionURL, username, password);
	            
	            stmt = connection.createStatement();
	            try (ResultSet rs = stmt.executeQuery(query)) {
	                while (rs.next()) {
	                	tableColumnValues.add(rs.getString(databaseColumName));
	                }
	            }
	            stmt.close();
	            connection.close();

	        } catch (SQLException e) {
	        }
	        return tableColumnValues;
	    }
	
}