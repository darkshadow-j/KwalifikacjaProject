/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa;

import ekrany.LoginPage;
import ekrany.SkladKomisjiPage;
import ekrany.SzukajOsobyPage;
import ekrany.WyborKategoriPage;
import hibernate.baza.data.komisja.OsobyWKomisji;

/**
 *
 * @author Paweł
 */
public class PageManager {

    private static LoginPage loginPage = null;
    private static SzukajOsobyPage szukajOsobyPage = null;
    private static SkladKomisjiPage skladKomisjiPage = null;
    private static WyborKategoriPage wyborKategoriPage = null;
    
    public static void OpenLoginPage() {
        loginPage = new LoginPage();
        loginPage.setBounds(50, 50, Stale.DL, Stale.SZ);
        loginPage.setVisible(true);
    }

    public static void CloseOpenLoginPage() {
        loginPage.setVisible(false);
    }

    public static void OpenSzukajOsobyPage() {
        szukajOsobyPage = new SzukajOsobyPage();
        szukajOsobyPage.setBounds(50, 50, Stale.DL, Stale.SZ);
        szukajOsobyPage.setVisible(true);

    }

    public static void OpenSkladKomisji() {
        skladKomisjiPage = new SkladKomisjiPage();
        skladKomisjiPage.setBounds(200, 200, Stale.skladKomisjiDL, Stale.skladKomisjiSZ);
        skladKomisjiPage.setVisible(true);
       for (OsobyWKomisji osoba : Stale.osobyWKomisji) {
            System.out.println(osoba);
           skladKomisjiPage.sekretarzLista.addItem(osoba);
           skladKomisjiPage.przewodniczacyLista.addItem(osoba);
           skladKomisjiPage.pielegniarkaLista.addItem(osoba);
        }
    }

    
    public static void CloseSkladKomisji() {
        skladKomisjiPage.setVisible(false);
    }
    
    
    public static void WyborKategoriPage(){
        wyborKategoriPage = new WyborKategoriPage();
        wyborKategoriPage.setBounds(50, 50, Stale.DL, Stale.SZ);
        wyborKategoriPage.setVisible(true);
    }
}
