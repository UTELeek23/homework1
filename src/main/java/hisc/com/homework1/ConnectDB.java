package hisc.com.homework1;

import java.sql.*;

public class ConnectDB {
    private static String host = "jdbc:mysql://localhost:3306/homework1";
    private static String user = "root";
    private static String pass = "Lak@2302";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(host,user,pass);
    }
    public static void main(String[] args) {
        ConnectDB cdb = new ConnectDB();
        try{
            Connection con = cdb.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next()){
                System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)+" | "+rs.getString(7));
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
