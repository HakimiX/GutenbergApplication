/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainLayer.author;
import DomainLayer.location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mustafahakimi
 */
public class LocationMapping {
    
     public location getLocation(Connection con, String UID){
        
        location returnLocation = new location("","","","");
        
        String SQLString1 = "SELECT * FROM location WHERE UID = ?";
        
        PreparedStatement statement = null;
        
        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                returnLocation = new location(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));

            }
            
            System.out.println(returnLocation.getName());
        } catch (Exception e) {
            System.out.println("Fail in mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }
        
        return returnLocation;
    }
    
}
