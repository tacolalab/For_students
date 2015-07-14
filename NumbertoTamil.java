/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sameer
 */
public class NumbertoTamil extends javax.swing.JFrame {

    /**
     * Creates new form NumbertoTamil
     */
    public static final String[] tensNames = {"", "பத்து", "இருபது", "முப்பது", "நாற்பது", "ஐம்பது", "அறுபது", "எழுபது", "என்பது", "தொண்ணூறு"};
    public static final String[] numNames = {"", "ஒன்று", "இரண்டு", "மூன்று", "நான்கு", "ஐந்து", "ஆறு", "ஏழு", "எட்டு", "ஒன்பது", "பத்து", "பதினொன்று", "பன்னிரெண்டு", "பதிமூன்று", "பதினான்கு", "பதினைந்து", "பதினாறு", "பதினேழு", "பதினெட்டு", "பத்தொன்பது"};
    public static final String[] hundredNames = {"", "நூறு", "இருநூறு", "முந்நூறு", "நானூறு", "ஐநூறு", "அறநூறு", "எழுநூறு", "எண்ணூறு", "தொள்ளாயிரம்"};
    public static final String[] thousandNames = {"", "ஆயிரம்", "இரண்டாயிரம்", "மூவாயிரம்", "நாலாயிரம்", "ஐந்தாயிரம்", "ஆறாயிரம்", "ஏழாயிரம்", "எட்டாயிரம்", "ஒன்பதாயிரம்"};

    public String convertLessThanOneThousand(int number) {
        String output;
        if (number % 100 < 20) {
            output = numNames[number % 100];
            number /= 100;
        } else {
            output = numNames[number % 10];
            number /= 10;
            output = convertTens(tensNames[number % 10], output) + " " + output;
            number /= 10;
        }
        if (number == 0) {
            return output;
        }
        return convertHunder(hundredNames[number], output) + " " + output;
    }

    public String convertTens(String input, String isZero) {
        if (!input.equals("பத்து") && isZero.length() != 0) {
            input = input.replace("து", "த்து");
            if (input.endsWith("று")) {
                input = input.replace("று", "ற்று");
            }
        }
        return input;
    }

    public String convertHunder(String input, String isZero) {
        if (isZero.length() != 0) {
            input = input.replace("று", "ற்று");
            input = input.replace("ம்", "த்து");
        }
        return input;
    }

    public String convert(String number) {
        // 0 to999 999 999 999 999 999
        if (number .equals("0")) {
            return "zero";
        }


        // pad with "0"
        String snumber="000000000000000000";
        int end=number.length();
        snumber=snumber.substring(end,snumber.length());
        snumber=snumber+number;

        // nXnnnnnnnnnnnnnnnn
        int anniyam = Integer.parseInt(snumber.substring(0 , 1));
        // nXnnnnnnnnnnnnnnnn
        int vellam = Integer.parseInt(snumber.substring(1 , 2));
        // nnXnnnnnnnnnnnnnnn
        int sangam = Integer.parseInt(snumber.substring(2, 3));
        // nnnXnnnnnnnnnnnnnn
        int padumam = Integer.parseInt(snumber.substring(3 , 4));
        // nnnnXnnnnnnnnnnnnn
        int nikarpam = Integer.parseInt(snumber.substring(4 , 5));
        // nnnnnXnnnnnnnnnnnn
        int karpam = Integer.parseInt(snumber.substring(5 , 6));
        // nnnnnnXnnnnnnnnnnn
        int kanam = Integer.parseInt(snumber.substring(6 , 7));
        // nnnnnnnXnnnnnnnnnn
        int kumbam = Integer.parseInt(snumber.substring(7 , 8));
        // nnnnnnnnXnnnnnnnnn
        int nigarpudham = Integer.parseInt(snumber.substring(8, 9));
        // nnnnnnnnnXnnnnnnnnn
        int arpudham = Integer.parseInt(snumber.substring(9, 10));
        // nnnnnnnnnXnnnnnnnn
        int kodi = Integer.parseInt(snumber.substring(10, 11));
        // nnnnnnnnnnXXnnnnnn
        int latcham = Integer.parseInt(snumber.substring(11, 13));
        // nnnnnnnnnnnnXXnnn
        int norraiyram = Integer.parseInt(snumber.substring(13, 15));
        // nnnnnnnnnnnnnnnXXX
        int aiyram = Integer.parseInt(snumber.substring(15, 18));

        String tradAnniyam;
        switch (anniyam) {
            case 0:
                tradAnniyam = "";
                break;
            case 1:
                tradAnniyam = "ஒரு அந்நியம்" + " ";
                break;
            default:
                tradAnniyam = convertLessThanOneThousand(anniyam)
                        + " " + "அந்நியம்";
        }
        String result=tradAnniyam;

        String tradVellam;
        switch (vellam) {
            case 0:
                tradVellam = "";
                break;
            case 1:
                tradVellam = "ஒரு வெள்ளம்" + " ";
                break;
            default:
                tradVellam = convertLessThanOneThousand(vellam)
                        + " " + "வெள்ளம்";
        }
        result=convertAnniyam(result,tradVellam);
        result =result+" "+ tradVellam;

        String tradSangam;
        switch (sangam) {
            case 0:
                tradSangam = "";
                break;
            case 1:
                tradSangam = "ஒரு சங்கம்" + " ";
                break;
            default:
                tradSangam = convertLessThanOneThousand(sangam)
                        + " " + "சங்கம்";
        }
        result=convertVellam(result, tradSangam);
        result =result+" "+ tradSangam;

        String tradPadumam;
        switch (padumam) {
            case 0:
                tradPadumam = "";
                break;
            case 1:
                tradPadumam = "ஒரு பதுமம்" + " ";
                break;
            default:
                tradPadumam = convertLessThanOneThousand(padumam)
                        + " " + "பதுமம்";
        }
        result=convertSangam(result,tradPadumam);
        result =result+" "+ tradPadumam;

        String tradNikarpam;
        switch (nikarpam) {
            case 0:
                tradNikarpam = "";
                break;
            case 1:
                tradNikarpam = "ஒரு நிகற்பம்" + " ";
                break;
            default:
                tradNikarpam = convertLessThanOneThousand(nikarpam)
                        + " " + "நிகற்பம்";
        }
        result=convertPadumam(result,tradNikarpam);
        result =result+" "+ tradNikarpam;

        String tradKarpam;
        switch (karpam) {
            case 0:
                tradKarpam = "";
                break;
            case 1:
                tradKarpam = "ஒரு கற்பம்" + " ";
                break;
            default:
                tradKarpam = convertLessThanOneThousand(karpam)
                        + " " + "கற்பம்";
        }
        result=convertNikarpam(result,tradNikarpam);
        result =result+" "+ tradKarpam;

        String tradKanam;
        switch (kanam) {
            case 0:
                tradKanam = "";
                break;
            case 1:
                tradKanam = "ஒரு கணம்" + " ";
                break;
            default:
                tradKanam = convertLessThanOneThousand(kanam)
                        + " " + "கணம்";
        }
        result=convertKarpam(result, tradKanam);
        result =result+" "+ tradKanam;


        String tradKumbam;
        switch (kumbam) {
            case 0:
                tradKumbam = "";
                break;
            case 1:
                tradKumbam = "ஒரு கும்பம்" + " ";
                break;
            default:
                tradKumbam = convertLessThanOneThousand(kumbam)
                        + " " + "கும்பம்";
        }
        result=convertKanam(result,tradKumbam);
        result =result+" "+ tradKumbam;

        String tradNigarpudham;
        switch (nigarpudham) {
            case 0:
                tradNigarpudham = "";
                break;
            case 1:
                tradNigarpudham = "ஒரு நிகற்புதம்" + " ";
                break;
            default:
                tradNigarpudham = convertLessThanOneThousand(nigarpudham)
                        + " " + "நிகற்புதம்";
        }
        result=convertKumbam(result,tradNigarpudham);
        result =result+" "+ tradNigarpudham;


        String tradArpudham;
        switch (arpudham) {
            case 0:
                tradArpudham = "";
                break;
            case 1:
                tradArpudham = "ஒரு அற்புதம்" + " ";
                break;
            default:
                tradArpudham = convertLessThanOneThousand(arpudham)
                        + " " + "அற்புதம்";
        }
        result=convertNigarpudham(result, tradArpudham);
        result =result+" "+ tradArpudham;


        String tradKodis;
        switch (kodi) {
            case 0:
                tradKodis = "";
                break;
            case 1:
                tradKodis = "ஒரு கோடி" + " ";
                break;
            default:
                tradKodis = convertLessThanOneThousand(kodi)
                        + " " + "கோடி";
        }
        result=convertArpudham(result, tradKodis);
        result =result+" "+ tradKodis;

        String tradLatcham;
        switch (latcham) {
            case 0:
                tradLatcham = "";
                break;
            case 1:
                tradLatcham = "ஒரு லட்சம்" + " ";
                break;
            default:
                tradLatcham = convertLessThanOneThousand(latcham)
                        + " " + "லட்சம்";
        }
        result=convertCrore(result,tradLatcham);
        result = result + " " + tradLatcham;

        String tradNorraiyram;
        switch (norraiyram) {
            case 0:
                tradNorraiyram = "";
                break;
            case 1:
                tradNorraiyram = "ஆயிரம்" + " ";
                break;
            default:
                tradNorraiyram = convertLessThanOneThousand(norraiyram)
                        + " " + "ஆயிரம்";
        }
        result=convertLaks(result, tradNorraiyram);
        result = result + " " + tradNorraiyram;

        String tradAiyram;
        tradAiyram = convertLessThanOneThousand(aiyram);
        result = convertThousnad(result, tradAiyram);
        result = result + " " + tradAiyram;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

    }

    public String convertThousnad(String input, String isZero) {
        if (isZero.length() != 0) {
            input = input.replace("ஆயிரம்", "ஆயிரத்து");
        }
        return input;
    }

    public String convertLaks(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("லட்சம்", "லட்சத்து");
        }
        return input;
    }

    public String convertCrore(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("கோடி", "கோடியே");
        }
        return input;
    }

    public String convertArpudham(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("அற்புதம்", "அற்புதத்து");
        }
        return input;
    }

    public String convertNigarpudham(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("நிகற்புதம்", "நிகற்புதத்து");
        }
        return input;
    }

    public String convertKumbam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("கும்பம்", "கும்பத்து");
        }
        return input;
    }

    public String convertKanam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("கணம்", "கணத்து");
        }
        return input;
    }

    public String convertKarpam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("கற்பம்", "கற்பத்து");
        }
        return input;
    }

    public String convertNikarpam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("நிகற்பம்", "நிகற்பத்து");
        }
        return input;
    }

    public String convertPadumam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("பதுமம்", "பதுமத்து");
        }
        return input;
    }

    public String convertSangam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("சங்கம்", "சங்கத்து");
        }
        return input;
    }

    public String convertVellam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("வெள்ளம்", "வெள்ளத்து");
        }
        return input;
    }

    public String convertAnniyam(String input,String isZero){
        if (isZero.length() != 0) {
            input = input.replace("அந்நியம்", "அந்நியத்து");
        }
        return input;
    }
    
    public NumbertoTamil() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Enter Number");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Number to Tamil Converter Tool");

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(Submit)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Submit))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed

        NumbertoTamil numbersToTamilWords = new NumbertoTamil();
        String output= numbersToTamilWords.convert(jTextField1.getText());
        jTextArea1.setText(output);

        //System.out.println("*** " + englishNumberToWords.convert("786"));            // TODO add your handling code here:
    }//GEN-LAST:event_SubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NumbertoTamil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumbertoTamil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumbertoTamil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumbertoTamil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumbertoTamil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Submit;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
