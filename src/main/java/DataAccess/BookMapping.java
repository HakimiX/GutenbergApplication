/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DomainLayer.book;
import DomainLayer.location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mustafahakimi
 */
public class BookMapping {
    
    public book getBook(Connection con, String UID){
        
        book returnBook = new book("","","");
        
        String SQLString1 = "SELECT * FROM book WHERE UID = ?";
        
        PreparedStatement statement = null;
        
        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, UID);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                returnBook = new book(rs.getString(1), rs.getString(2), rs.getString(3));

            }
            
            System.out.println(returnBook.getTitle());
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
        
        return returnBook;
    }
}
