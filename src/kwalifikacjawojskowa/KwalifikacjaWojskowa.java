/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa;

import ekrany.LoginPage;
import hibernate.baza.data.DBConnection;
import hibernate.baza.data.HQL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import org.hibernate.Session;

/**
 *
 * @author Paweł
 */
public class KwalifikacjaWojskowa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {

        
        
        HQL hql = new HQL();
        Stale.osobyWKomisji = hql.getAllOsobyWKomisji();  // Ustawianie wszystkich osob w kommisji
        Session session = DBConnection.openSession();
        PageManager.OpenLoginPage();
        
       // ImportCSVFile.ImportChoroby();
        
        //System.out.println(hql.getOpis(1, 2));
        /*ImportCSVFile csvFile = new ImportCSVFile();
        csvFile.ReadCSVFile();
        
      */
    }
    
}

