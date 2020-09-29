/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa;

import au.com.bytecode.opencsv.*;
import hibernate.baza.data.Osoby;
import hibernate.baza.data.Paragraf;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Paweł
 */
public class ImportCSVFile {

    public void ReadCSVFile() throws FileNotFoundException, IOException, ParseException {

        CSVReader reader = new CSVReader(new FileReader("wojsko.csv"), ';');
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine.length > 1) {
                Date date = null;
                try {
                    SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
                    date = sm.parse(new String(nextLine[6]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Osoby osoba = new Osoby(new String(nextLine[1]), new String(nextLine[0]), new String(nextLine[2]), date, new String(nextLine[3]), new String(nextLine[4]), new String(nextLine[5]), new String(nextLine[7]), new String(nextLine[9]), new String(nextLine[10]), new String(nextLine[11]), new String(nextLine[12]));
                System.out.println(osoba);
                osoba.SavePerson();
            }

        }
    }

    public static void ImportChoroby() throws FileNotFoundException, IOException, ParseException {

        CSVReader reader = new CSVReader(new FileReader("xd.csv"), ';');
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine.length > 1) {
                System.out.println(Integer.valueOf(nextLine[0]) + " " + Integer.valueOf(nextLine[1]) + " " + String.valueOf(nextLine[2] ));
                Paragraf p = new Paragraf(Integer.valueOf(nextLine[0]),Integer.valueOf(nextLine[1]), String.valueOf(nextLine[2] ));
                p.SaveParagraf();
    //Osoby osoba = new Osoby(new String(nextLine[1]), new String(nextLine[0]), new String(nextLine[2]), date, new String(nextLine[3]), new String(nextLine[4]), new String(nextLine[5]), new String(nextLine[7]), new String(nextLine[9]), new String(nextLine[10]), new String(nextLine[11]), new String(nextLine[12]));
                //System.out.println(osoba);
                //osoba.SavePerson();
            }
        }
    }

}
