/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekrany;

import hibernate.baza.data.HQL;
import hibernate.baza.data.Osoby;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kwalifikacjawojskowa.PageManager;
import kwalifikacjawojskowa.Stale;
import kwalifikacjawojskowa.raporty.DOCX;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import validator.*;
/*
 * @author Paweł
 */

public class SzukajOsobyPage extends javax.swing.JFrame {

    /**
     * Creates new form SzukajOsobyPage
     */
    private Osoby wyszukanaOsoba = null;

    public SzukajOsobyPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        szukajPESELTF = new javax.swing.JTextField();
        szukajBT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        wynikImieTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        wynikImie2TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        wynikNazwisko2TF = new javax.swing.JTextField();
        wynikNazwiskoTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        wynikDataUrTF = new javax.swing.JTextField();
        wynikImieOjcaTF = new javax.swing.JTextField();
        wynikMiejscowoscTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        wynikUlicaTF = new javax.swing.JTextField();
        wynikNrLokTF = new javax.swing.JTextField();
        wynikNrBudTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        wydajOrzeczenieBT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        skladKomisjiM = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("PESEL");

        szukajPESELTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                szukajPESELTFKeyPressed(evt);
            }
        });

        szukajBT.setText("Szukaj");
        szukajBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szukajBTActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wyszukana Osoba"));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 550));

        wynikImieTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikImieTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikImieTF.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("IMIONA:");

        wynikImie2TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikImie2TF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikImie2TF.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("NAZWISKA:");

        wynikNazwisko2TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikNazwisko2TF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikNazwisko2TF.setEnabled(false);

        wynikNazwiskoTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikNazwiskoTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikNazwiskoTF.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("IMIE OJCA:");

        wynikDataUrTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikDataUrTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikDataUrTF.setEnabled(false);

        wynikImieOjcaTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikImieOjcaTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikImieOjcaTF.setEnabled(false);

        wynikMiejscowoscTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikMiejscowoscTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wynikMiejscowoscTF.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("DATA UR:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("MIEJSCOWOŚĆ");

        wynikUlicaTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wynikUlicaTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        wynikNrLokTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikNrLokTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        wynikNrBudTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wynikNrBudTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("M.ZAMIESZKANIA");

        wydajOrzeczenieBT.setText("Wydaj Orzeczenie");
        wydajOrzeczenieBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wydajOrzeczenieBTActionPerformed(evt);
            }
        });

        jButton1.setText("Popraw Dane");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wynikDataUrTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wynikImieOjcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wynikMiejscowoscTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wynikUlicaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(wynikImieTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(wynikNazwiskoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wynikImie2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wynikNazwisko2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(wynikNrBudTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(wynikNrLokTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(wydajOrzeczenieBT, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wynikImieTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(wynikImie2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wynikNazwiskoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wynikNazwisko2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wynikImieOjcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wynikDataUrTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wynikMiejscowoscTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wynikUlicaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wynikNrBudTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wynikNrLokTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wydajOrzeczenieBT, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jMenu1.setText("Edycja");

        skladKomisjiM.setText("Sklad Komisji");
        skladKomisjiM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skladKomisjiMActionPerformed(evt);
            }
        });
        jMenu1.add(skladKomisjiM);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administrator");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(szukajPESELTF, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(szukajBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(szukajPESELTF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(szukajBT))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void szukajBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szukajBTActionPerformed

        String PESEL = szukajPESELTF.getText();

        PeselValidator peselValidator = new PeselValidator(PESEL);
        if (peselValidator.isValid()) {

            HQL hql = new HQL();
            wyszukanaOsoba = hql.SearchByPESEL(PESEL);
            if (wyszukanaOsoba != null) {
                UzupelnijDane(wyszukanaOsoba);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Nie ma takiej osoby !!",
                        "BAD USER",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "BLEDNY PESEL",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_szukajBTActionPerformed

    private void wydajOrzeczenieBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wydajOrzeczenieBTActionPerformed

        if (wyszukanaOsoba != null) {
            if (Stale.przewodniczacy != null) {
                if (wyszukanaOsoba.getCheck() == 0) {
                    this.setVisible(false);
                    Stale.wyszukanaOsoba = wyszukanaOsoba;
                    PageManager.WyborKategoriPage();
                } else {

                    JOptionPane.showMessageDialog(this,
                            "Ta osoba byla juz na komisji !!",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    DOCX docx = new DOCX();
                    try {
                        docx.openOrzeczenie(wyszukanaOsoba.getPesel());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SzukajOsobyPage.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidFormatException ex) {
                        Logger.getLogger(SzukajOsobyPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.setVisible(false);
                    PageManager.OpenSzukajOsobyPage();
                }

            } else {
                JOptionPane.showMessageDialog(this,
                        "Nie ustanwiono czlownkow komisji !!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Najpiew musisz wyszukać osobę !!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_wydajOrzeczenieBTActionPerformed

    private boolean SprawadzZmiany() {

        if (wyszukanaOsoba.getUlica().equals(this.wynikUlicaTF.getText()) && wyszukanaOsoba.getNrBud().equals(this.wynikNrBudTF.getText()) && wyszukanaOsoba.getNrLok().equals(this.wynikNrLokTF.getText())) {
            return false;
        } else {
            return true;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // POPRAW DANE

        if (wyszukanaOsoba != null) {
            if (SprawadzZmiany()) {
                wyszukanaOsoba.setUlica(this.wynikUlicaTF.getText());
                wyszukanaOsoba.setNrBud(this.wynikNrBudTF.getText());
                wyszukanaOsoba.setNrLok(this.wynikNrLokTF.getText());
                wyszukanaOsoba.UpdatePerson();
                JOptionPane.showMessageDialog(this,
                        "Wykryto zmiany w adresie. Czy na pewno zapisać ?",
                        "Informacja",
                        JOptionPane.OK_CANCEL_OPTION);
            } else {
                System.out.println("OK OK OK");
            }

        } else {
            JOptionPane.showMessageDialog(this,
                    "Musisz najpierw kogos wyszukac",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void skladKomisjiMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skladKomisjiMActionPerformed
        PageManager.OpenSkladKomisji();
    }//GEN-LAST:event_skladKomisjiMActionPerformed

    private void szukajPESELTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_szukajPESELTFKeyPressed
        if (evt.getKeyCode() == 10) {
            szukajBT.doClick();
        }

    }//GEN-LAST:event_szukajPESELTFKeyPressed

    private void UzupelnijDane(Osoby osoby) {
        this.wynikImie2TF.setText(osoby.getImie2());
        this.wynikImieOjcaTF.setText(osoby.getImieOjca());
        this.wynikImieTF.setText(osoby.getImie1());
        this.wynikNazwiskoTF.setText(osoby.getNazwisko1());
        this.wynikNazwisko2TF.setText(osoby.getNazwisko2());
        this.wynikMiejscowoscTF.setText(osoby.getMiejscowosc());
        this.wynikNrBudTF.setText(osoby.getNrBud());
        this.wynikNrLokTF.setText(osoby.getNrLok());
        this.wynikUlicaTF.setText(osoby.getUlica());
        this.wynikDataUrTF.setText(String.valueOf(osoby.getDataUrodznia()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SzukajOsobyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzukajOsobyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzukajOsobyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzukajOsobyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzukajOsobyPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem skladKomisjiM;
    private javax.swing.JButton szukajBT;
    private javax.swing.JTextField szukajPESELTF;
    private javax.swing.JButton wydajOrzeczenieBT;
    private javax.swing.JTextField wynikDataUrTF;
    private javax.swing.JTextField wynikImie2TF;
    private javax.swing.JTextField wynikImieOjcaTF;
    private javax.swing.JTextField wynikImieTF;
    private javax.swing.JTextField wynikMiejscowoscTF;
    private javax.swing.JTextField wynikNazwisko2TF;
    private javax.swing.JTextField wynikNazwiskoTF;
    private javax.swing.JTextField wynikNrBudTF;
    private javax.swing.JTextField wynikNrLokTF;
    private javax.swing.JTextField wynikUlicaTF;
    // End of variables declaration//GEN-END:variables
}