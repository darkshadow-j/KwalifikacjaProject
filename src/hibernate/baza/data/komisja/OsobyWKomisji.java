/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data.komisja;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name="osoby_komisji")
public class OsobyWKomisji {
    
    @Id
    private Integer id;
    
    @Column(name="IMIE")
    private String Imie;
    
    @Column(name="NAZWISKO")
    private String Nazwisko;

    public OsobyWKomisji() {
    }
    
    // GETTERY i SETTERY

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    @Override
    public String toString() {
        return Imie + " " + Nazwisko;
    }

    
    

}
