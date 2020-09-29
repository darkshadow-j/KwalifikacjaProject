/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Type;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name = "osoby")
public class Osoby implements OsobyInt {

    @Id
    @Column(name = "PESEL")
    private String Pesel;
    @Column(name = "IMIE_OJCA")
    private String ImieOjca;
    @Column(name = "IMIE_1")
    private String Imie1;
    @Column(name = "DATA_URODZENIA")
    @Type(type = "date")
    private Date DataUrodznia;
    
    @Column(name = "IMIE_2")
    private String Imie2;
    @Column(name = "NAZWISKO_1")
    private String Nazwisko1;
    @Column(name = "NAZWISKO_2")
    private String Nazwisko2;
    @Column(name = "MIEJSCOWOSC")
    private String Miejscowosc;
    @Column(name = "ULICA")
    private String Ulica;
    @Column(name = "NR_BUD")
    private String NrBud;
    @Column(name = "NR_LOK")
    private String NrLok;
    @Column(name = "KOD_POCZTOWY")
    private String KodPocztowy;
    @Column(name = "SPRAWDZ")
    private Integer Check;

    public Osoby() {
    }
    
    public Osoby(String Pesel, String ImieOjca, String Imie1, Date DataUrodznia, String Imie2, String Nazwisko1, String Nazwisko2, String Miejscowosc, String Ulica, String NrBud, String NrLok, String KodPocztowy) {
        this.Pesel = Pesel;
        this.ImieOjca = ImieOjca;
        this.Imie1 = Imie1;
        this.DataUrodznia = DataUrodznia;
        this.Imie2 = Imie2;
        this.Nazwisko1 = Nazwisko1;
        this.Nazwisko2 = Nazwisko2;
        this.Miejscowosc = Miejscowosc;
        this.Ulica = Ulica;
        this.NrBud = NrBud;
        this.NrLok = NrLok;
        this.KodPocztowy = KodPocztowy;
    }

    public Date getDataUrodznia() {
        return DataUrodznia;
    }

    public String getImie2() {
        return Imie2;
    }

    public String getNazwisko1() {
        return Nazwisko1;
    }

    public String getNazwisko2() {
        return Nazwisko2;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public Integer getCheck() {
        return Check;
    }

    public void setCheck(Integer Check) {
        this.Check = Check;
    }

    public String getUlica() {
        return Ulica;
    }

    public String getNrBud() {
        return NrBud;
    }

    public String getNrLok() {
        return NrLok;
    }

    public String getKodPocztowy() {
        return KodPocztowy;
    }

    @Override
    public String toString() {
        return Nazwisko1 + " " + Imie1 +" " + Imie2;
    }

    public String getImieOjca() {
        return ImieOjca;
    }

    public String getPesel() {
        return Pesel;
    }

    public String getImie1() {
        return Imie1;
    }

    public void setImieOjca(String ImieOjca) {
        this.ImieOjca = ImieOjca;
    }

    public void setPesel(String Pesel) {
        this.Pesel = Pesel;
    }

    public void setImie1(String Imie1) {
        this.Imie1 = Imie1;
    }

    public void setDataUrodznia(Date DataUrodznia) {
        this.DataUrodznia = DataUrodznia;
    }

    public void setImie2(String Imie2) {
        this.Imie2 = Imie2;
    }

    public void setNazwisko1(String Nazwisko1) {
        this.Nazwisko1 = Nazwisko1;
    }

    public void setNazwisko2(String Nazwisko2) {
        this.Nazwisko2 = Nazwisko2;
    }

    public void setMiejscowosc(String Miejscowosc) {
        this.Miejscowosc = Miejscowosc;
    }

    public void setUlica(String Ulica) {
        this.Ulica = Ulica;
    }

    public void setNrBud(String NrBud) {
        this.NrBud = NrBud;
    }

    public void setNrLok(String NrLok) {
        this.NrLok = NrLok;
    }

    public void setKodPocztowy(String KodPocztowy) {
        this.KodPocztowy = KodPocztowy;
    }
    
    public String getFullAdress(){
        if(!this.getNrLok().isEmpty()){
        return this.getUlica()+" " + this.getNrBud() + "/" +this.getNrLok();
        }else{
            return this.getUlica()+" " + this.getNrBud();
        }
    }

    @Override
    public boolean SavePerson() {

        Session session = DBConnection.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
           
            session.save(this);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }
    
       public boolean UpdatePerson() {

        Session session = DBConnection.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
           
            session.update(this);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

}
