/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plura;

import java.awt.Component;
import java.util.ArrayList;

/**
 *
 * @author Kandit
 */
public class PluraPane extends javax.swing.JPanel {

    Plurality pl;

    /**
     * Creates new form plaraPane
     */
    PluraPane(String name) {
        initComponents();
        this.setName(name);
        nameLabel.setText(name);
        pl = new ListBasedPlur();

    }

    PluraPane(String name, Plurality pl) {
        initComponents();
        this.setName(name);
        nameLabel.setText(name);
        this.pl = pl;
        addToView();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        elemListPane = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addElemBtn = new javax.swing.JButton();
        elemAddField = new javax.swing.JTextField();
        typeCbox = new javax.swing.JComboBox();
        remElemBtn = new javax.swing.JButton();
        statusLbl = new javax.swing.JLabel();

        elemListPane.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(elemListPane);

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("   ");
        nameLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addElemBtn.setText("Add Element");
        addElemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElemBtnActionPerformed(evt);
            }
        });

        typeCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "String", "Int", "Float" }));

        remElemBtn.setText("Remove");
        remElemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remElemBtnActionPerformed(evt);
            }
        });

        statusLbl.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        statusLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(remElemBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addElemBtn, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeCbox, 0, 67, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elemAddField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(remElemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elemAddField)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addElemBtn)
                        .addComponent(typeCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addToView() {
        for (Elem el : pl) {
            ElementPane ep = new ElementPane(el);
            elemListPane.add(ep);
        }
    }

    private void addElemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElemBtnActionPerformed
        String st = elemAddField.getText().trim();
        Elem el = null;
        if (st.isEmpty() == false) {
            String type = (String) typeCbox.getSelectedItem();
            try {
                switch (type) {
                    case "String": {
                        el = new Elem(st);
                        break;
                    }
                    case "Int": {
                        el = new Elem(new Integer(Integer.valueOf(st)));
                        break;
                    }
                    case "Float": {
                        el = new Elem(new Float(Float.valueOf(st)));
                        break;
                    }
                    default:
                }
                if (el != null) {
                    if (pl.add(el)) {
                        this.statusLbl.setText("Элемент '" + el.toString() + "' добавлен");
                        elemListPane.add(new ElementPane(el));
                        elemAddField.requestFocus();
                        elemAddField.setText("");
                        elemListPane.revalidate();
                    } else {
                        statusLbl.setText("Элемент '" + el.toString() + "' не добавлен, повтор");
                       
                    }
                }
            } catch (NumberFormatException j) {
                this.statusLbl.setText("Элемент '" + st + "' не добавлен, неверный тип.");
            }

        }
    }//GEN-LAST:event_addElemBtnActionPerformed


    private void remElemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remElemBtnActionPerformed
        ArrayList<Elem> a = new ArrayList();
        for (Component comp : elemListPane.getComponents()) {
            ElementPane ep = (ElementPane) comp;
            if (ep.isChecked) {
                pl.remove(ep.el);
                elemListPane.remove(ep);
            }
        }
    }//GEN-LAST:event_remElemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElemBtn;
    private javax.swing.JTextField elemAddField;
    private javax.swing.JPanel elemListPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton remElemBtn;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JComboBox typeCbox;
    // End of variables declaration//GEN-END:variables

    Plurality getPlur() {
        return this.pl;
    }
}
