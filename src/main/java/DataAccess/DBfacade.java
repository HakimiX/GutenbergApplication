
package DataAccess;

import DomainLayer.author;
import DomainLayer.book;
import DomainLayer.location;
import java.sql.Connection;


// SINGELTON
// One connection to the database 
// One instance of the class

public class DBfacade {
 
    private AuthorMapping authorMapping;
    private LocationMapping locationMapping;
    private BookMapping bookMapping;
    private Connection con;
    
    // Singleton
    private static DBfacade instance;
    
    // Private Constructor 
    private DBfacade(){
        authorMapping = new AuthorMapping();
        locationMapping = new LocationMapping();
        bookMapping = new BookMapping();
        con = new DBconnectorMysql().getConnection();  
        // the connection will be released upon program 
        // termination by the garbage collector		
    }
    
    public static DBfacade getInstance(){
        if(instance == null){
            instance = new DBfacade();
        }
        return instance;
    }
    
    public author getAuthor(String UID){
        return authorMapping.getAuthor(con, UID);
    }
    
    public location getLocation(String UID){
        return locationMapping.getLocation(con, UID);
    }
    
    public book getBook(String UID){
        return bookMapping.getBook(con, UID);
    }
}
