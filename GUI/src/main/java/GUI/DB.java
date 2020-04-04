/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author afaro
 */
public class DB {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;

    public DB() {
    
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/messenger","root","");
            st =  con.createStatement();
            
            
            
        } catch (Exception e) {
        
            System.out.println("Error: "+e);
        
        }
    
       
        
        
    }
    
    public void AddtoDB(String name,String message){
    
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String query = String.format("insert into messages (Name,Message,Time) values('%s','%s','%s')",name,message,sdf.format(cal.getTime()));
        
        st.executeUpdate(query);
            
        } catch (Exception e) {
            
            System.out.println("Error: "+e);
        }
        
    
    }
    
    
}
