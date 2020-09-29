/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import hibernate.baza.data.komisja.OsobyWKomisji;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paweł
 */
public class HQL {

    private Transaction tx = null;

    public boolean CheckNrDokumentu(Integer nrDokumentu){
        Session session = DBConnection.openSession();
        String hql = "from NrOrzeczenia s where s.nrOrzeczenia = :nrOrzeczenia";
        NrOrzeczenia result = (NrOrzeczenia) session.createQuery(hql)
                .setParameter("nrOrzeczenia", nrDokumentu)
                .uniqueResult();
        if(result == null){
            return true;
        }else{
            return false;
        }
    }
    
        public String CheckByPESEL(String PESEL){
        Session session = DBConnection.openSession();
        String hql = "from NrOrzeczenia s where s.PESEL = :PESEL";
        NrOrzeczenia result = (NrOrzeczenia) session.createQuery(hql)
                .setParameter("PESEL", PESEL)
                .uniqueResult();
        if(result == null){
            return null;
        }else{
            return result.getNrOrzeczenia();
        }
    }
    
    public void ZmienNumerOrzeczenia(String PESEL, Integer Numer){
                Integer res = null;
        Session session = DBConnection.openSession();

        try {
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
            String hql = "UPDATE NrOrzeczenia set nrOrzeczenia = :nrOrzeczenia "
                    + "WHERE PESEL = :PESEL";
 
            Query query = session.createQuery(hql);
            query.setParameter("nrOrzeczenia", Numer);
            query.setParameter("PESEL", PESEL);
            res = query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public Integer getLastNumer(){
        Session session = DBConnection.openSession();
        String hql = "select max(s.nrOrzeczenia) from NrOrzeczenia s";
        Integer result = (Integer) session.createQuery(hql)
                .uniqueResult();
        return result;
    }
   
    
    public Uzytkownicy CheckUser(String Login, String Password) {
        Session session = DBConnection.openSession();
        String hql = "from Uzytkownicy s where s.Login = :Login and s.Password = :Password";
        Uzytkownicy result = (Uzytkownicy) session.createQuery(hql)
                .setParameter("Login", Login)
                .setParameter("Password", Password)
                .uniqueResult();
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }

    public Osoby SearchByPESEL(String PESEL) {

        Session session = DBConnection.openSession();
        String hql = "from Osoby s where s.Pesel = :Pesel";
        Osoby result = (Osoby) session.createQuery(hql)
                .setParameter("Pesel", PESEL)
                .uniqueResult();
        if (result != null) {
            return result;
        } else {
            return null;
        }
    }

    public String getOpis(Integer Paragraf, Integer Punkt) {
        Session session = DBConnection.openSession();
        String hql = "from Paragraf p where p.PARAGRAF = :PARAGRAF and p.PUNKT = :PUNKT";
        Paragraf opis = (Paragraf) session.createQuery(hql).setParameter("PARAGRAF", Paragraf).setParameter("PUNKT", Punkt).uniqueResult();
        if (opis != null) {
            return opis.toString();
        } else {
            return null;
        }
    }

    public List<OsobyWKomisji> getAllOsobyWKomisji() {

        Session session = DBConnection.openSession();
        String hql = "from OsobyWKomisji";
        List<OsobyWKomisji> result = session.createQuery(hql).list();
        return result;
    }

    public int GetNrOrzeczenia() {
        return 1;
    }

    public int UpdateOsoby(String Ulica, String Pesel, String NrBud, String NrLok) {

        Integer res = null;
        Session session = DBConnection.openSession();

        try {
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
            String hql = "UPDATE Osoby set Ulica = :Ulica and NrBud = :NrBud and NrLok = :NrLok "
                    + "WHERE Pesel = :Pesel";
            System.out.println("NOWA ULICA: " + Ulica);
            Query query = session.createQuery(hql);
            query.setParameter("Ulica", Ulica);
            query.setParameter("NrBud", NrBud);
            query.setParameter("NrLok", NrLok);
            
            query.setParameter("Pesel", Pesel);
            res = query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return res;
    }

    
    public void UpdateNROrzeczenia() {
        Session session = DBConnection.openSession();
        try {
            System.out.println("UPDATE CHECK");
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
            String hql = "UPDATE NrOrzeczenia set nrOrzeczenia = 2 "
                    + "WHERE id = 1";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void UpdateCheckPerson(Integer Check, String Pesel) {
        Session session = DBConnection.openSession();
        try {
            System.out.println("UPDATE CHECK");
            tx = session.beginTransaction();
            //Employee employee = new Employee(fname, lname, salary);
            //employeeID = (Integer) session.save(employee);
            String hql = "UPDATE Osoby set Check = 1 "
                    + "WHERE Pesel = :Pesel";
            Query query = session.createQuery(hql);
            //query.setInteger("Check", Check);
            query.setParameter("Pesel", Pesel);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
