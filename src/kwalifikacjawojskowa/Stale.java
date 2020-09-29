/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa;

import hibernate.baza.data.NrOrzeczenia;
import hibernate.baza.data.Osoby;
import hibernate.baza.data.komisja.OsobyWKomisji;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class Stale {
    
    public static String PREFIX="PKLek.5571.";
    public static String SUFFIX=".2017";
    public static Integer DL = 800;
    public static Integer SZ = 600;
    public static Integer skladKomisjiDL = 450;
    public static Integer skladKomisjiSZ = 350;
    public static NrOrzeczenia nrOrzeczenia = null;
    
    
    public static List<OsobyWKomisji> osobyWKomisji = null;

    public static OsobyWKomisji przewodniczacy = null;
    public static OsobyWKomisji sekretarz = null;
    public static OsobyWKomisji Pielegniarka = null;
    
    public static Osoby wyszukanaOsoba = null;
}