/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.baza.data;

import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;

/**
 *
 * @author Paweł
 */
@Entity
@Table(name = "USERS")
public class Uzytkownicy {

    
    @Id
    private Integer id;
    @Column(name = "LOGIN")
    private String Login;
    @Column(name = "PASSWORD")
    private String Password;
    @Column(name = "ROLE")
    private Integer Role;

    public Uzytkownicy() {
    }

    public Uzytkownicy(String Login) {
        this.Login = Login;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public Integer getRole() {
        return Role;
    }

}
