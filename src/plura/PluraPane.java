/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plura;

/**
 *
 * @author Kandit
 */
public class PluraPane extends javax.swing.JPanel {

    Plurality pl;

    /**
     * Creates new form plaraPane
     */
    public PluraPane() {
        initComponents();
        pl = new arrayBasedPlur();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addElemBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        elemList = new javax.swing.JList();
        elemAddField = new javax.swing.JTextField();
        remElemBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        typeCbox = new javax.swing.JComboBox();

        addElemBtn.setText("Add Element");
        addElemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addElemBtnActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(elemList);

        remElemBtn.setText("Remove");
        remElemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remElemBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("   ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        typeCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "String", "Int", "Float" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(remElemBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addElemBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elemAddField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remElemBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addElemBtn)
                    .addComponent(elemAddField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addElemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addElemBtnActionPerformed
        String st = elemAddField.getText().trim();
        Elem el = null;
        if (st.isEmpty() == false) {
            String type = (String) typeCbox.getSelectedItem();
            switch (type) {
                case "String": {
                    el = new Elem(st);
                    break;
                }
                case "Int": {
                    el = new Elem(new Integer(Integer.getInteger(st)));
                    break;
                }
                case "Float": {
                    el = new Elem(new Float(Float.valueOf(st)));
                    break;
                }
                default:
            }
            if (el != null) {
                elemList.add(new elementPane(el));
                elemList.revalidate();
            }

        }
    }//GEN-LAST:event_addElemBtnActionPerformed

    private void remElemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remElemBtnActionPerformed
        int[] sel = elemList.getSelectedIndices();
        for (int i = 0; i < sel.length; i++) {
            elemList.remove(sel[i]);
        }
        elemList.revalidate();
    }//GEN-LAST:event_remElemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addElemBtn;
    private javax.swing.JTextField elemAddField;
    private javax.swing.JList elemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remElemBtn;
    private javax.swing.JComboBox typeCbox;
    // End of variables declaration//GEN-END:variables
}
