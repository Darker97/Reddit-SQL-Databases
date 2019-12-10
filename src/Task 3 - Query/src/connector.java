import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.*;

/**
 * Here be Connector Object
  */
public class connector {

    connector(){
        Connection con = connect();
    }


    private Connection connect(){
        List<String> arr = getCredentials();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(arr.get(0)+":"+arr.get(1), arr.get(2), arr.get(3));
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
}
