/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import javax.persistence.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name = "paragrafy")
public class Paragraf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer PARAGRAF;
    private Integer PUNKT;
    private String OPIS;

    public Paragraf(Integer PARAGRAF, Integer PUNKT, String OPIS) {
        this.PARAGRAF = PARAGRAF;
        this.PUNKT = PUNKT;
        this.OPIS = OPIS;
    }

    public boolean SaveParagraf() {

        Session session = DBConnection.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
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
    
    public Paragraf() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPARAGRAF() {
        return PARAGRAF;
    }

    public void setPARAGRAF(Integer PARAGRAF) {
        this.PARAGRAF = PARAGRAF;
    }

    public Integer getPUNKT() {
        return PUNKT;
    }

    public void setPUNKT(Integer PUNKT) {
        this.PUNKT = PUNKT;
    }

    public String getOPIS() {
        return OPIS;
    }

    public void setOPIS(String OPIS) {
        this.OPIS = OPIS;
    }

    @Override
    public String toString() {
        char[] paragraf = {167};
        return "- " + OPIS + " - " + String.copyValueOf(paragraf) + PARAGRAF + " pkt " + PUNKT;
    }
    
    

}
