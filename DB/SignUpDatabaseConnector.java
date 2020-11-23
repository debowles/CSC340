package CSC340.DB;

//Author David Bowles
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpDatabaseConnector implements DBConnectorInterface{

    // Creating a connection to login database
    

    //reads a specific value of user info
    public static String readUserParameters(String label, int rowNum) throws SQLException {
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT " + label + " FROM USERSIGNUP");
            for (int i = 0; i < rowNum; i++) {
                results.next();
            }
            userInfo = results.getString(label);
            results.close();
            stmt.close();
        }
        return userInfo;
    }
    //returns a hashmap of a users info
    public static HashMap<String, String> readUserInfoDB(String id) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERSIGNUP");
            int rowNum = Integer.parseInt(id);
            for (int i = 0; i <= rowNum; i++) {
                results.next();
            }
            map.put("FIRST_NAME", results.getString("FIRST_NAME"));
            map.put("LAST_NAME", results.getString("LAST_NAME"));
            map.put("EMAIL", results.getString("EMAIL"));
            map.put("PHONENUMBER", results.getString("PHONENUMBER"));
            map.put("PASSWORD", results.getString("PASSWORD"));
            map.put("ZIPCODE", results.getString("ZIPCODE"));
            map.put("RADIUS", results.getString("RADIUS"));

            results.close();
            stmt.close();
        }
        return map;
    }

    //updates user info
    public static void updateUserInfoDB(String label, String variable, String id) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            if(label.equals("PHONENUMBER")||label.equals("ZIPCODE")||label.equals("RADIUS")||label.equals("ID")){
                System.out.println("UPDATE USERSIGNUP \nSET " + label + " = " + variable + " \nWHERE ID = " + id);
                stmt.executeUpdate("UPDATE USERSIGNUP SET " + label + " = " + variable + " WHERE ID = " + id);
            }else{
            System.out.println("UPDATE USERSIGNUP \nSET " + label + " = " + "'"+variable+"'" + " \nWHERE ID = " + id);
            stmt.executeUpdate("UPDATE USERSIGNUP SET " + label + " = " + "'"+variable+"'" + " WHERE ID = " + id);
            }
            stmt.close();
            System.out.println("DB Info Updated");
        }
    }
    //deletes a user from DB
    public static void deleteUserInfoDB(String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM USERSIGNUP WHERE id =" + id);
            stmt.executeUpdate("DELETE FROM USERSIGNUP WHERE id =" + id);
            stmt.close();
            System.out.println("DB Info Deleted");
        }

        /**
         *
         * @param map
         * @throws SQLException
         */
    }
    //Adds a User to the DB
    public static void addUserInfoDB(HashMap<String, String> map, String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            String statementLabels = "";
            String statementValues = "";           

            if (map.containsKey("FIRST_NAME")) {
                statementLabels = "FIRST_NAME";
                statementValues = "'"+ map.get("FIRST_NAME") + "'";
            }
            if (map.containsKey("LAST_NAME")) {
                statementLabels = statementLabels + ",LAST_NAME";
                statementValues = statementValues + "," +"'"+ map.get("LAST_NAME") + "'";
            }
            if (map.containsKey("EMAIL")) {
                statementLabels = statementLabels + ",EMAIL";
                statementValues = statementValues + "," +"'"+ map.get("EMAIL") + "'";
            }
            if (map.containsKey("PHONENUMBER")) {
                statementLabels = statementLabels + ",PHONENUMBER";
                statementValues = statementValues + ","+ "'"+ map.get("PHONENUMBER")+"'" ;
            }
            if (map.containsKey("PASSWORD")) {
                statementLabels = statementLabels + ",PASSWORD";
                statementValues = statementValues + "," +"'"+ map.get("PASSWORD")+ "'";
            }
            if (map.containsKey("ZIPCODE")) {
                statementLabels = statementLabels + ",ZIPCODE";
                statementValues = statementValues + ","+  map.get("ZIPCODE") ;
            }
            if (map.containsKey("RADIUS")) {
                statementLabels = statementLabels + ",RADIUS";
                statementValues = statementValues + "," +map.get("RADIUS");
            }           
            
                       
            
                statementLabels = statementLabels + ",ID"; 
                statementValues = statementValues + ","+ id;
            
            
            
            
            System.out.println(statementLabels);
            System.out.println(statementValues);

            System.out.println("INSERT INTO USERSIGNUP(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO USERSIGNUP(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }
        
        
        
    }
   
    
    public static boolean checkForValue(String parameter, String value) throws SQLException{
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT "+parameter+" FROM USERSIGNUP");
             
            while(results.next()){
                if(results.getString(parameter).equals(value)){
                    return true;
             }            
            
        }  
        results.close();
        stmt.close();
            return false;
            }
    }
    
}
