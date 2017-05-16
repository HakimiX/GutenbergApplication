/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer;

import DataAccess.DBfacade;

/**
 *
 * @author mustafahakimi
 */
public class Controller {
    
    private DBfacade dbf;
    
    public Controller(){
        dbf = DBfacade.getInstance();
    }
    
    public author getAuthor(String UID){
        return dbf.getAuthor(UID);
    }
    
    public location getLocation(String UID){
        return dbf.getLocation(UID);
    }
    
    public book getBook(String UID){
        return dbf.getBook(UID);
    }
}
