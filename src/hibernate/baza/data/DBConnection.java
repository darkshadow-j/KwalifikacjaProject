/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Paweł
 */
public class DBConnection {
    
    private static SessionFactory sessionFactory=null;
    
    private static void DBConnection(){
        if(sessionFactory==null){
        sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();
        }
    }
    
    public static Session openSession(){
        DBConnection.DBConnection();
        return sessionFactory.openSession();
        
    }
}
