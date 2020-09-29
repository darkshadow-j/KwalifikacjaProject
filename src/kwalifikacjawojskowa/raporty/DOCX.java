/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa.raporty;

import hibernate.baza.data.HQL;
import hibernate.baza.data.NrOrzeczenia;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBElement;
import kwalifikacjawojskowa.Stale;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;

/**
 *
 * @author Paweł
 */
public class DOCX {

    private static String KAT_B_SZABLON = "Szablony//KatB.docx";
    private static String KAT_A_SZABLON = "Szablony//KatA.docx";
    private static String KAT_Ap_SZABLON = "Szablony//KatAp.docx";
    private static String KAT_E_SZABLON = "Szablony//KatE.docx";
    private static String KAT_D_SZABLON = "Szablony//KatD.docx";

    private WordprocessingMLPackage getTemplate(String name) throws Docx4JException, FileNotFoundException {
        WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(name)));

        return template;

    }

    private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {

        List<Object> result = new ArrayList<Object>();

        if (obj instanceof JAXBElement) {
            obj = ((JAXBElement<?>) obj).getValue();
        }

        if (obj.getClass().equals(toSearch)) {
            result.add(obj);
        } else if (obj instanceof ContentAccessor) {

            List<?> children = ((ContentAccessor) obj).getContent();

            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;

    }

    private void replacePlaceholder(WordprocessingMLPackage template, String name, String placeholder) throws IOException, InvalidFormatException {

    }

    private void writeDocxToStream(WordprocessingMLPackage template, String target) throws IOException, Docx4JException {

        File f = new File(target);
        template.save(f);

    }

    public String ListaParagrafow(ArrayList<String> Uzasadnienie) {
        String Paragrafy = "";
        char[] par = {167};
        if (Uzasadnienie.size() != 0) {
            for (String paragraf : Uzasadnienie) {
                if (paragraf.length() != 0 && (paragraf.indexOf(String.valueOf(par)) != -1)) {
                    Paragrafy += paragraf.substring(paragraf.indexOf(String.valueOf(par))) + ", ";
                }
            }
            if (Paragrafy != "") {
                Paragrafy = Paragrafy.substring(0, Paragrafy.lastIndexOf(","));
                if(Paragrafy.contains(",")){
                    StringBuilder myName = new StringBuilder(Paragrafy);
                   // myName.setCharAt(Paragrafy.lastIndexOf(","), 'i');
                    myName.replace(Paragrafy.lastIndexOf(","), Paragrafy.lastIndexOf(",")+1, " oraz");
                    Paragrafy = myName.toString();
                }
            }

        }

        return Paragrafy;
    }

    public void WydajKatA() throws FileNotFoundException, IOException, InvalidFormatException, InterruptedException {

       

        FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
        InputStream fs = new FileInputStream(KAT_A_SZABLON);
        HQL hql = new HQL();
        //XWPFDocument hdoc=new XWPFDocument(fs);
        XWPFDocument document = new XWPFDocument(OPCPackage.open(fs));

        XWPFTable poleData = document.getTableArray(0);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
        Date now = new Date();
        poleData.getRow(0).getCell(0).setText(sdfDate.format(now));
        
        Stale.nrOrzeczenia = UpdateNrOrzeczenia(Stale.wyszukanaOsoba.getPesel());
        XWPFTable poleNumer = document.getTableArray(1);
        poleNumer.getRow(0).getCell(0).setText(Stale.nrOrzeczenia.getNrOrzeczenia().toString());

        XWPFTable poleKomisja = document.getTableArray(2);
        poleKomisja.getRow(1).getCell(1).setText(Stale.przewodniczacy.toString());
        poleKomisja.getRow(2).getCell(1).setText(Stale.sekretarz.toString());
        poleKomisja.getRow(3).getCell(1).setText(Stale.Pielegniarka.toString());

        XWPFTable table = document.getTableArray(3);

        setRun(getParagraph(table, 0, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        //table.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        //paragraph = rowOne.getCell(3).getParagraphArray(0);
        //setRun(paragraph.createRun() , "Calibre LIght" , 11, "2b5079" , Stale.wyszukanaOsoba.getImieOjca().toUpperCase() , true, false);
        setRun(getParagraph(table, 0, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getImieOjca().toUpperCase(), true, false);
        //table.getRow(0).getCell(3).setText(Stale.wyszukanaOsoba.getImieOjca().toUpperCase());
        // XWPFTableRow rowOne = table.getRow(0);
        //XWPFParagraph paragraph = table.getRow(null).getCell(1).getParagraphArray(0);
        setRun(getParagraph(table, 1, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getDataUrodznia().toString(), true, false);
        //table.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getDataUrodznia().toString());
        setRun(getParagraph(table, 1, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getPesel().toUpperCase(), true, false);
        //table.getRow(1).getCell(3).setText(Stale.wyszukanaOsoba.getPesel().toUpperCase());
        setRun(getParagraph(table, 2, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //table.getRow(2).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable polePrzewodniczacyDol = document.getTableArray(4);
        polePrzewodniczacyDol.getRow(0).getCell(0).setText(Stale.przewodniczacy.toString());

        XWPFTable poleOrzymuja = document.getTableArray(5);
        setRun(getParagraph(poleOrzymuja, 0, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        // poleOrzymuja.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        setRun(getParagraph(poleOrzymuja, 1, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //  poleOrzymuja.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleSekretarzDOL = document.getTableArray(6);
        poleSekretarzDOL.getRow(0).getCell(0).setText(Stale.sekretarz.toString());

        document.write(out);
        //UpdateNrOrzeczenia();
        hql.UpdateCheckPerson(1, Stale.wyszukanaOsoba.getPesel());

        openOrzeczenie(Stale.wyszukanaOsoba.getPesel());

    }

    public void WydajKATB(ArrayList<String> Uzasadnienie) throws FileNotFoundException, IOException, InvalidFormatException, InterruptedException {

        System.out.println("PARAGRAFY: " + this.ListaParagrafow(Uzasadnienie));
        FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
        InputStream fs = new FileInputStream(KAT_B_SZABLON);
        HQL hql = new HQL();
        //XWPFDocument hdoc=new XWPFDocument(fs);
        XWPFDocument document = new XWPFDocument(OPCPackage.open(fs));

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("$1")) {
                        text = text.replace("$1", this.ListaParagrafow(Uzasadnienie));
                        r.setText(text, 0);
                    }
                }
            }
        }
        //      XWPFDocument document= new XWPFDocument();
        XWPFTable poleData = document.getTableArray(0);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
        Date now = new Date();
        poleData.getRow(0).getCell(0).setText(sdfDate.format(now));
        
        Stale.nrOrzeczenia = UpdateNrOrzeczenia(Stale.wyszukanaOsoba.getPesel());
        XWPFTable poleNumer = document.getTableArray(1);
        poleNumer.getRow(0).getCell(0).setText(Stale.nrOrzeczenia.getNrOrzeczenia().toString());

        XWPFTable poleKomisja = document.getTableArray(2);
        poleKomisja.getRow(1).getCell(1).setText(Stale.przewodniczacy.toString());
        poleKomisja.getRow(2).getCell(1).setText(Stale.sekretarz.toString());
        poleKomisja.getRow(3).getCell(1).setText(Stale.Pielegniarka.toString());

        XWPFTable table = document.getTableArray(3);

        setRun(getParagraph(table, 0, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        //table.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        //paragraph = rowOne.getCell(3).getParagraphArray(0);
        //setRun(paragraph.createRun() , "Calibre LIght" , 11, "2b5079" , Stale.wyszukanaOsoba.getImieOjca().toUpperCase() , true, false);
        setRun(getParagraph(table, 0, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getImieOjca().toUpperCase(), true, false);
        //table.getRow(0).getCell(3).setText(Stale.wyszukanaOsoba.getImieOjca().toUpperCase());
        // XWPFTableRow rowOne = table.getRow(0);
        //XWPFParagraph paragraph = table.getRow(null).getCell(1).getParagraphArray(0);
        setRun(getParagraph(table, 1, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getDataUrodznia().toString(), true, false);
        //table.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getDataUrodznia().toString());
        setRun(getParagraph(table, 1, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getPesel().toUpperCase(), true, false);
        //table.getRow(1).getCell(3).setText(Stale.wyszukanaOsoba.getPesel().toUpperCase());
        setRun(getParagraph(table, 2, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //table.getRow(2).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleUzasadnienie = document.getTableArray(4);
        XWPFParagraph para = poleUzasadnienie.getRow(0).getCell(0).getParagraphs().get(0);
        for (String text : Uzasadnienie) {
            XWPFRun run = para.createRun();
            run.setText(text.trim());
            run.addBreak();
        }

        XWPFTable polePrzewodniczacyDol = document.getTableArray(5);
        polePrzewodniczacyDol.getRow(0).getCell(0).setText(Stale.przewodniczacy.toString());

        XWPFTable poleOrzymuja = document.getTableArray(6);
        setRun(getParagraph(poleOrzymuja, 0, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        // poleOrzymuja.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        setRun(getParagraph(poleOrzymuja, 1, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //  poleOrzymuja.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleSekretarzDOL = document.getTableArray(7);
        poleSekretarzDOL.getRow(0).getCell(0).setText(Stale.sekretarz.toString());

        document.write(out);
        //UpdateNrOrzeczenia();
        hql.UpdateCheckPerson(1, Stale.wyszukanaOsoba.getPesel());
        openOrzeczenie(Stale.wyszukanaOsoba.getPesel());

    }

    public void WydajKatE(ArrayList<String> Uzasadnienie) throws FileNotFoundException, IOException, InvalidFormatException, InterruptedException {

        System.out.println("PARAGRAFY: " + this.ListaParagrafow(Uzasadnienie));
        FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
        InputStream fs = new FileInputStream(KAT_E_SZABLON);
        HQL hql = new HQL();
        //XWPFDocument hdoc=new XWPFDocument(fs);
        XWPFDocument document = new XWPFDocument(OPCPackage.open(fs));

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("$1")) {
                        text = text.replace("$1", this.ListaParagrafow(Uzasadnienie));
                        r.setText(text, 0);
                    }
                }
            }
        }
        //      XWPFDocument document= new XWPFDocument();
        XWPFTable poleData = document.getTableArray(0);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
        Date now = new Date();
        poleData.getRow(0).getCell(0).setText(sdfDate.format(now));

        Stale.nrOrzeczenia = UpdateNrOrzeczenia(Stale.wyszukanaOsoba.getPesel());
        XWPFTable poleNumer = document.getTableArray(1);
        poleNumer.getRow(0).getCell(0).setText(Stale.nrOrzeczenia.getNrOrzeczenia().toString());
        

        XWPFTable poleKomisja = document.getTableArray(2);
        poleKomisja.getRow(1).getCell(1).setText(Stale.przewodniczacy.toString());
        poleKomisja.getRow(2).getCell(1).setText(Stale.sekretarz.toString());
        poleKomisja.getRow(3).getCell(1).setText(Stale.Pielegniarka.toString());

        XWPFTable table = document.getTableArray(3);

        setRun(getParagraph(table, 0, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        //table.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        //paragraph = rowOne.getCell(3).getParagraphArray(0);
        //setRun(paragraph.createRun() , "Calibre LIght" , 11, "2b5079" , Stale.wyszukanaOsoba.getImieOjca().toUpperCase() , true, false);
        setRun(getParagraph(table, 0, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getImieOjca().toUpperCase(), true, false);
        //table.getRow(0).getCell(3).setText(Stale.wyszukanaOsoba.getImieOjca().toUpperCase());
        // XWPFTableRow rowOne = table.getRow(0);
        //XWPFParagraph paragraph = table.getRow(null).getCell(1).getParagraphArray(0);
        setRun(getParagraph(table, 1, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getDataUrodznia().toString(), true, false);
        //table.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getDataUrodznia().toString());
        setRun(getParagraph(table, 1, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getPesel().toUpperCase(), true, false);
        //table.getRow(1).getCell(3).setText(Stale.wyszukanaOsoba.getPesel().toUpperCase());
        setRun(getParagraph(table, 2, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //table.getRow(2).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleUzasadnienie = document.getTableArray(4);
        XWPFParagraph para = poleUzasadnienie.getRow(0).getCell(0).getParagraphs().get(0);
        for (String text : Uzasadnienie) {
            XWPFRun run = para.createRun();
            run.setText(text.trim());
            run.addBreak();
        }

        XWPFTable polePrzewodniczacyDol = document.getTableArray(5);
        polePrzewodniczacyDol.getRow(0).getCell(0).setText(Stale.przewodniczacy.toString());

        XWPFTable poleOrzymuja = document.getTableArray(6);
        setRun(getParagraph(poleOrzymuja, 0, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        // poleOrzymuja.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        setRun(getParagraph(poleOrzymuja, 1, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //  poleOrzymuja.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleSekretarzDOL = document.getTableArray(7);
        poleSekretarzDOL.getRow(0).getCell(0).setText(Stale.sekretarz.toString());

        document.write(out);
        //UpdateNrOrzeczenia();
        hql.UpdateCheckPerson(1, Stale.wyszukanaOsoba.getPesel());
        openOrzeczenie(Stale.wyszukanaOsoba.getPesel());

    }

    public void WydajKatD(ArrayList<String> Uzasadnienie) throws FileNotFoundException, IOException, InvalidFormatException, InterruptedException {

        System.out.println("PARAGRAFY: " + this.ListaParagrafow(Uzasadnienie));
        FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
        InputStream fs = new FileInputStream(KAT_D_SZABLON);
        HQL hql = new HQL();
        //XWPFDocument hdoc=new XWPFDocument(fs);
        XWPFDocument document = new XWPFDocument(OPCPackage.open(fs));

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("$1")) {
                        text = text.replace("$1", this.ListaParagrafow(Uzasadnienie));
                        r.setText(text, 0);
                    }
                }
            }
        }
        //      XWPFDocument document= new XWPFDocument();
        XWPFTable poleData = document.getTableArray(0);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
        Date now = new Date();
        poleData.getRow(0).getCell(0).setText(sdfDate.format(now));

        Stale.nrOrzeczenia = UpdateNrOrzeczenia(Stale.wyszukanaOsoba.getPesel());
        XWPFTable poleNumer = document.getTableArray(1);
        poleNumer.getRow(0).getCell(0).setText(Stale.nrOrzeczenia.getNrOrzeczenia().toString());

        XWPFTable poleKomisja = document.getTableArray(2);
        poleKomisja.getRow(1).getCell(1).setText(Stale.przewodniczacy.toString());
        poleKomisja.getRow(2).getCell(1).setText(Stale.sekretarz.toString());
        poleKomisja.getRow(3).getCell(1).setText(Stale.Pielegniarka.toString());

        XWPFTable table = document.getTableArray(3);

        setRun(getParagraph(table, 0, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        //table.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        //paragraph = rowOne.getCell(3).getParagraphArray(0);
        //setRun(paragraph.createRun() , "Calibre LIght" , 11, "2b5079" , Stale.wyszukanaOsoba.getImieOjca().toUpperCase() , true, false);
        setRun(getParagraph(table, 0, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getImieOjca().toUpperCase(), true, false);
        //table.getRow(0).getCell(3).setText(Stale.wyszukanaOsoba.getImieOjca().toUpperCase());
        // XWPFTableRow rowOne = table.getRow(0);
        //XWPFParagraph paragraph = table.getRow(null).getCell(1).getParagraphArray(0);
        setRun(getParagraph(table, 1, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getDataUrodznia().toString(), true, false);
        //table.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getDataUrodznia().toString());
        setRun(getParagraph(table, 1, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getPesel().toUpperCase(), true, false);
        //table.getRow(1).getCell(3).setText(Stale.wyszukanaOsoba.getPesel().toUpperCase());
        setRun(getParagraph(table, 2, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //table.getRow(2).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleUzasadnienie = document.getTableArray(4);
        XWPFParagraph para = poleUzasadnienie.getRow(0).getCell(0).getParagraphs().get(0);
        for (String text : Uzasadnienie) {
            XWPFRun run = para.createRun();
            run.setText(text.trim());
            run.addBreak();
        }

        XWPFTable polePrzewodniczacyDol = document.getTableArray(5);
        polePrzewodniczacyDol.getRow(0).getCell(0).setText(Stale.przewodniczacy.toString());

        XWPFTable poleOrzymuja = document.getTableArray(6);
        setRun(getParagraph(poleOrzymuja, 0, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        // poleOrzymuja.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        setRun(getParagraph(poleOrzymuja, 1, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //  poleOrzymuja.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleSekretarzDOL = document.getTableArray(7);
        poleSekretarzDOL.getRow(0).getCell(0).setText(Stale.sekretarz.toString());

        document.write(out);
        //UpdateNrOrzeczenia();
        hql.UpdateCheckPerson(1, Stale.wyszukanaOsoba.getPesel());
        openOrzeczenie(Stale.wyszukanaOsoba.getPesel());

    }

    public void WydajKATAp(ArrayList<String> Uzasadnienie, boolean Dokumenty) throws FileNotFoundException, IOException, InvalidFormatException, InterruptedException {

        System.out.println("PARAGRAFY: " + this.ListaParagrafow(Uzasadnienie));
        FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
        InputStream fs = new FileInputStream(KAT_Ap_SZABLON);
        HQL hql = new HQL();
        //XWPFDocument hdoc=new XWPFDocument(fs);
        XWPFDocument document = new XWPFDocument(OPCPackage.open(fs));

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("$1")) {
                        text = text.replace("$1", this.ListaParagrafow(Uzasadnienie));
                        r.setText(text, 0);
                    }
                    if (text != null && text.contains("$2") && Dokumenty) {
                        text = text.replace("$2", "");
                        r.setText(text, 0);
                    }
                    if (text != null && text.contains("$2") && !Dokumenty) {
                        text = text.replace("$2", "Osoba podlegajaca kwalifikacji wojskowej nie przedstawiła Komisji dodatkowych dokumentów dotyczących stanu zdrowia");
                        r.setText(text, 0);
                    }
                }
            }
        }
        //      XWPFDocument document= new XWPFDocument();
        XWPFTable poleData = document.getTableArray(0);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
        Date now = new Date();
        poleData.getRow(0).getCell(0).setText(sdfDate.format(now));

Stale.nrOrzeczenia = UpdateNrOrzeczenia(Stale.wyszukanaOsoba.getPesel());
        XWPFTable poleNumer = document.getTableArray(1);
        poleNumer.getRow(0).getCell(0).setText(Stale.nrOrzeczenia.getNrOrzeczenia().toString());

        XWPFTable poleKomisja = document.getTableArray(2);
        poleKomisja.getRow(1).getCell(1).setText(Stale.przewodniczacy.toString());
        poleKomisja.getRow(2).getCell(1).setText(Stale.sekretarz.toString());
        poleKomisja.getRow(3).getCell(1).setText(Stale.Pielegniarka.toString());

        XWPFTable table = document.getTableArray(3);

        setRun(getParagraph(table, 0, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        //table.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        //paragraph = rowOne.getCell(3).getParagraphArray(0);
        //setRun(paragraph.createRun() , "Calibre LIght" , 11, "2b5079" , Stale.wyszukanaOsoba.getImieOjca().toUpperCase() , true, false);
        setRun(getParagraph(table, 0, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getImieOjca().toUpperCase(), true, false);
        //table.getRow(0).getCell(3).setText(Stale.wyszukanaOsoba.getImieOjca().toUpperCase());
        // XWPFTableRow rowOne = table.getRow(0);
        //XWPFParagraph paragraph = table.getRow(null).getCell(1).getParagraphArray(0);
        setRun(getParagraph(table, 1, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getDataUrodznia().toString(), true, false);
        //table.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getDataUrodznia().toString());
        setRun(getParagraph(table, 1, 3).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getPesel().toUpperCase(), true, false);
        //table.getRow(1).getCell(3).setText(Stale.wyszukanaOsoba.getPesel().toUpperCase());
        setRun(getParagraph(table, 2, 1).createRun(), "Calibre LIght", 11, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //table.getRow(2).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleUzasadnienie = document.getTableArray(4);
        XWPFParagraph para = poleUzasadnienie.getRow(0).getCell(0).getParagraphs().get(0);
        for (String text : Uzasadnienie) {
            XWPFRun run = para.createRun();
            run.setText(text.trim());
            run.addBreak();
        }

        XWPFTable polePrzewodniczacyDol = document.getTableArray(5);
        polePrzewodniczacyDol.getRow(0).getCell(0).setText(Stale.przewodniczacy.toString());

        XWPFTable poleOrzymuja = document.getTableArray(6);
        setRun(getParagraph(poleOrzymuja, 0, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.toString().toUpperCase(), true, false);
        // poleOrzymuja.getRow(0).getCell(1).setText(Stale.wyszukanaOsoba.toString().toUpperCase());
        setRun(getParagraph(poleOrzymuja, 1, 1).createRun(), "Calibre LIght", 8, "2b5079", Stale.wyszukanaOsoba.getFullAdress().toUpperCase(), true, false);
        //  poleOrzymuja.getRow(1).getCell(1).setText(Stale.wyszukanaOsoba.getFullAdress().toUpperCase());

        XWPFTable poleSekretarzDOL = document.getTableArray(7);
        poleSekretarzDOL.getRow(0).getCell(0).setText(Stale.sekretarz.toString());

        document.write(out);
        hql.UpdateCheckPerson(1, Stale.wyszukanaOsoba.getPesel());
        openOrzeczenie(Stale.wyszukanaOsoba.getPesel());

    }

    public XWPFParagraph getParagraph(XWPFTable tabela, Integer Row, Integer Cell) {
        return tabela.getRow(Row).getCell(Cell).getParagraphArray(0);
    }

    public NrOrzeczenia UpdateNrOrzeczenia(String PESEL) {
        HQL hql = new HQL();
        hql.getLastNumer();
        NrOrzeczenia nrOrzeczenia = new NrOrzeczenia();
        nrOrzeczenia.setNrOrzeczenia(hql.getLastNumer() + 1);
        nrOrzeczenia.setPESEL(PESEL);
        nrOrzeczenia.Save();
        return nrOrzeczenia;
    }

    public void openOrzeczenie(String PESEL) throws InterruptedException, InvalidFormatException {
        
        Thread.sleep(1500);
        File file = new File("Orzeczenia\\" + PESEL + ".docx");
        boolean Save = false;
        try {
            while (!Save) {
                System.out.println("init");
                ProcessBuilder pb;
                Process p;
                pb = new ProcessBuilder("cmd.exe", "/C", "Orzeczenia\\" + PESEL + ".docx");

                p = pb.start();
                InputStream iStream = p.getInputStream();
                p.waitFor();

                // FileOutputStream out = new FileOutputStream(new File("Orzeczenia\\" + Stale.wyszukanaOsoba.getPesel() + ".docx"));
                InputStream fs = new FileInputStream("Orzeczenia\\" + PESEL + ".docx");
                XWPFDocument document = new XWPFDocument(fs);

                XWPFTable poleNumer = document.getTableArray(1);
                String pole = poleNumer.getRow(0).getCell(0).getText();
                pole=pole.substring(11);
                pole=pole.substring(0, pole.indexOf("."));
                Integer nowyNumer = Integer.valueOf(pole);
              
                HQL hql = new HQL();
                
                
                 
                System.out.println("ID " + nowyNumer.toString());
                if(hql.CheckNrDokumentu(nowyNumer)||poleNumer.getRow(0).getCell(0).getText().equals(hql.CheckByPESEL(PESEL))){
                    hql.ZmienNumerOrzeczenia(PESEL, nowyNumer);
                    Save=true;
                }
                

            }
            //Open the file using Desktop class
            //Desktop.getDesktop().open(file);
            // Desktop.getDesktop().

        } catch (IOException exception) {

            exception.printStackTrace();

        }
    }

    public String getNumerOrzeczenia() {
        return Stale.PREFIX + "1" + Stale.SUFFIX;
    }

    private static void setRun(XWPFRun run, String fontFamily, int fontSize, String colorRGB, String text, boolean bold, boolean addBreak) {
        //run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        //run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) {
            run.addBreak();
        }
    }

}
