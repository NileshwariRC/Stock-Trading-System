package stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
    private Connection connection;
    //private String url = "jdbc:oracle:thin:@csoracle.utdallas.edu:1521:student";
//    private String username = "nrc180002";
//    private String password = "oracle";
    private String url ="jdbc:mysql://localhost:3306/stock";
    private String username = "root";
    private String password = "mysql100";
    
    
	
    private DBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    public Connection executePrepareStatement(String query) {
    	Connection con = getConnection();
    	return con;
    }
    
    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }

        return instance;
    }
}
