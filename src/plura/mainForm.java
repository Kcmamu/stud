/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plura;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Kandit
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        myPlrsBox = new DisableItemComboBox();
        chooseActionCB = new javax.swing.JComboBox();
        doSmthPlur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabs.setMinimumSize(new java.awt.Dimension(5, 100));
        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        myPlrsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myPlrsBoxActionPerformed(evt);
            }
        });

        chooseActionCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "New", "Intersect", "Join" }));
        chooseActionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionCBActionPerformed(evt);
            }
        });

        doSmthPlur.setText("New");
        doSmthPlur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doSmthPlurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doSmthPlur, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chooseActionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPlrsBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseActionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myPlrsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doSmthPlur)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseActionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseActionCBActionPerformed
        String st = (String) chooseActionCB.getSelectedItem();
        doSmthPlur.setText(st);

        // TODO add your handling code here:
    }//GEN-LAST:event_chooseActionCBActionPerformed

    private void doSmthPlurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doSmthPlurActionPerformed
        String st = doSmthPlur.getText();
        switch (st) {
            case "New": {
                addNewPlur();
                break;
            }

            case "Intersect": {
                Instersect();
                break;
            }
            case "Join": {
                Join();
                break;
            }
        }
    }//GEN-LAST:event_doSmthPlurActionPerformed

    private void myPlrsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myPlrsBoxActionPerformed

    }//GEN-LAST:event_myPlrsBoxActionPerformed

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        DisableItemComboBox d = (DisableItemComboBox) myPlrsBox;
        HashSet<Integer> dis = new HashSet();
        dis.add(tabs.getSelectedIndex());

        d.setDisableIndex(dis);
    }//GEN-LAST:event_tabsStateChanged
    private void Instersect() {

        PluraPane activeP, targetP, resultP;
        activeP = (PluraPane) tabs.getSelectedComponent();
        targetP = (PluraPane) tabs.getComponentAt(myPlrsBox.getSelectedIndex());

        Plurality fst, snd;
        fst = activeP.getPlur();
        snd = targetP.getPlur();
        Plurality result = fst.intersection(snd);

        String pluraName = "Intersection (" + activeP.getName() + "," + targetP.getName() + ")";
        resultP = new PluraPane(pluraName, result);
        addToView(pluraName, resultP);
    }

    private void Join() {

        PluraPane activeP, targetP, resultP;
        activeP = (PluraPane) tabs.getSelectedComponent();
        targetP = (PluraPane) tabs.getComponentAt(myPlrsBox.getSelectedIndex());

        Plurality fst, snd;
        fst = activeP.getPlur();
        snd = targetP.getPlur();
        Plurality result = fst.join(snd);

        String pluraName = "Union (" + activeP.getName() + "," + targetP.getName() + ")";
        resultP = new PluraPane(pluraName, result);
        addToView(pluraName, resultP);
    }

    private Integer last = 1;

    private void addNewPlur() {

        String pluraName = "Plur " + last;
        last++;
        PluraPane resultP = new PluraPane(pluraName);
        addToView(pluraName, resultP);
    }

    void addToView(String pluraName, PluraPane resultP) {
        EventQueue.invokeLater(() -> {
            DefaultComboBoxModel model = (DefaultComboBoxModel) myPlrsBox.getModel();
            model.addElement(pluraName);
            tabs.add(resultP);
            tabs.setTitleAt(tabs.getComponentCount() - 1, pluraName);
            tabs.getParent().revalidate();
        });

    }

    public void print(String npl) {
        System.out.println(npl);
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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox chooseActionCB;
    private javax.swing.JButton doSmthPlur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox myPlrsBox;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables

    void myInit() {

        PluraPane pp = new PluraPane("Plur " + last);
        tabs.add(pp);
        DefaultComboBoxModel model = new DefaultComboBoxModel((new Vector()));
        model.addElement("Plur " + last);
        tabs.setTitleAt(0, "Plur " + last);
        last++;
        myPlrsBox.setModel(model);

        java.awt.EventQueue.invokeLater(() -> {
            tabs.getParent().revalidate();
        });
    }

}

//class MyComboBoxModel extends DefaultComboBoxModel {
//
//    JTabbedPane tb;
//
//    public MyComboBoxModel(JTabbedPane tabs) {
//        this.tb = tabs;
//
//    }
//
//    @Override
//    public void setSelectedItem(Object anObject) {
//
//        if (anObject != null) {
//            String curTabName = tb.getSelectedComponent().getName();
//            if (!anObject.toString().equals(curTabName)) {
//
//                super.setSelectedItem(anObject);
//
//            }
//
//        } else {
//
//            super.setSelectedItem(anObject);
//
//        }
//
//    }
//
//}
