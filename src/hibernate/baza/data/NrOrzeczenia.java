/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import javax.persistence.*;
import kwalifikacjawojskowa.Stale;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name="NR_ORZECZENIA")
public class NrOrzeczenia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="NR_ORZECZENIA")
    private Integer nrOrzeczenia;
    
    @Column(name="PESEL")
    private String PESEL;

    public NrOrzeczenia() {
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNrOrzeczenia() {
        return Stale.PREFIX + nrOrzeczenia + Stale.SUFFIX;
    }

    public void setNrOrzeczenia(Integer nrOrzeczenia) {
        this.nrOrzeczenia = nrOrzeczenia;
    
    }

    public boolean Save() {

        Session session = DBConnection.openSession();
        Transaction tx = null;
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
    
}
