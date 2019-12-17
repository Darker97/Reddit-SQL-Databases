import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.*;
import com.mysql.jdbc.Driver;

/**
 * Here be Connector Object
  */
public class connector {

	public Connection con;
	
	public connector() {
		this.con = connect();
	}
	



    private Connection connect(){
        List<String> arr = getCredentials();
        System.out.println("Starting Connection");
        
        String url = arr.get(0);
        String port = arr.get(1);
        String username = arr.get(2);
        String password = arr.get(3);
        String database = arr.get(4);
        String finalURL = "jdbc:mysql://" + url + ":" + port.toString() + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false" ;
        
        System.out.println("Connecting to:     " + finalURL
        		+ "\n" + " With Password: " + password
        		+ "\n" + " With Username: " + username);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(finalURL, username, password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getCredentials() {
        List<String> temp = new ArrayList<String>();
        try {
            File f = new File("DB.config");
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()){
                temp.add(sc.nextLine());
            }

            return temp;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public Connection getCon(){
         return this.con;
    }
}
