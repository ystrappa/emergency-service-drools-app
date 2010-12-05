/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PhoneCallsPanel.java
 *
 * Created on Nov 24, 2010, 3:15:17 PM
 */

package com.wordpress.salaboy.ui;

import com.wordpress.salaboy.call.CallManager;
import com.wordpress.salaboy.call.IncomingCallListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.plugtree.training.model.Call;

/**
 *
 * @author esteban
 */
public class PhoneCallsPanel extends javax.swing.JPanel implements IncomingCallListener {

    private UserUI parent;
    
    /** Creates new form PhoneCallsPanel */
    public PhoneCallsPanel(UserUI parent) {
        this.parent = parent;
        initComponents();
        CallManager.getInstance().addIncomingCallListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phoneCallsJScrollPane = new javax.swing.JScrollPane();
        phoneCallsJTable = new javax.swing.JTable();
        newEmergencyPhoneCallJButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 400, 480));
        setName("Phone Calls"); // NOI18N

        phoneCallsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alert", "Date/Time", "Call"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Number.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        phoneCallsJTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        phoneCallsJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneCallsJTablerowClick(evt);
            }
        });
        phoneCallsJScrollPane.setViewportView(phoneCallsJTable);

        newEmergencyPhoneCallJButton.setText("New Emergency Phone Call");
        newEmergencyPhoneCallJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEmergencyPhoneCallJButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Incoming Calls:");

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 0));
        jLabel1.setText("User: Operator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(phoneCallsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newEmergencyPhoneCallJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneCallsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmergencyPhoneCallJButton)
                    .addComponent(refreshJButton))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void phoneCallsJTablerowClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneCallsJTablerowClick
        //System.out.println("ID from EVT"+evt.getID());
        int selected = phoneCallsJTable.rowAtPoint(evt.getPoint());
        Long id = Long.parseLong(phoneCallsJTable.getModel().getValueAt(selected, 0).toString());
        parent.callSelected(id);
        
    }//GEN-LAST:event_phoneCallsJTablerowClick

    private void newEmergencyPhoneCallJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmergencyPhoneCallJButtonActionPerformed
        //Start Emergency Business Process
        
    }//GEN-LAST:event_newEmergencyPhoneCallJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        this.refreshCallsTable();
}//GEN-LAST:event_refreshJButtonActionPerformed

    @Override
    public void processIncomingCall(Long id, Call call) {
        refreshCallsTable();
    }
    
    private void refreshCallsTable(){
        DefaultTableModel tableModel = ((DefaultTableModel)phoneCallsJTable.getModel());
        
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
        Calendar calendar = Calendar.getInstance();
        
       
        for (Map.Entry<Long, Call> entry : CallManager.getInstance().getCalls().entrySet()) {
            calendar.setTime(entry.getValue().getDate());
            tableModel.addRow(new Object[]{entry.getKey().toString(),
                calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND),
                entry.getValue().getId()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JButton newEmergencyPhoneCallJButton;
    private javax.swing.JScrollPane phoneCallsJScrollPane;
    private javax.swing.JTable phoneCallsJTable;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables

}
