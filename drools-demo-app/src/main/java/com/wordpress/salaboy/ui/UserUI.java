/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserUI.java
 *
 * Created on Nov 2, 2010, 4:45:08 PM
 */
package com.wordpress.salaboy.ui;

import com.wordpress.salaboy.MyDroolsService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import org.drools.process.workitem.wsht.BlockingGetTaskResponseHandler;
import org.drools.task.AccessType;
import org.drools.task.Content;
import org.drools.task.Task;
import org.drools.task.TaskData;
import org.drools.task.query.TaskSummary;
import org.drools.task.service.ContentData;
import org.drools.task.service.TaskClient;
import org.drools.task.service.responsehandlers.BlockingGetContentResponseHandler;
import org.drools.task.service.responsehandlers.BlockingTaskOperationResponseHandler;
import org.drools.task.service.responsehandlers.BlockingTaskSummaryResponseHandler;
import org.plugtree.training.model.Emergency.EmergencyType;

/**
 *
 * @author salaboy
 */
public class UserUI extends javax.swing.JFrame implements MapEventsListener {

    private TaskClient taskClient;
    private static final long DEFAULT_WAIT_TIME = 5000;
    private Task currentTask;
    private SlickBasicGame game;
    //Panels
    private PhoneCallsPanel phoneCallsPanel;
    private EmergencyInfoPanel emergencyInfoPanel;
    private AmbulancePanel ambulancePanel;
    private CurrentEmergenciesPanel currentEmergenciesPanel;

    /** Creates new form UserUI */
    public UserUI() {
        initComponents();
        initTaskServer();
        initTaskClient();

        phoneCallsPanel = new PhoneCallsPanel(this);
        emergencyInfoPanel = new EmergencyInfoPanel(this);
        ambulancePanel = new AmbulancePanel(this);
        currentEmergenciesPanel = new CurrentEmergenciesPanel(this);

        this.mainJTabbedPane.add(this.phoneCallsPanel, 0);
        this.mainJTabbedPane.add(this.emergencyInfoPanel, 1);
        this.mainJTabbedPane.add(this.ambulancePanel, 2);
        this.mainJTabbedPane.add(this.currentEmergenciesPanel, 3);

        this.mainJTabbedPane.setSelectedComponent(this.phoneCallsPanel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJTabbedPane = new javax.swing.JTabbedPane();
        hospitalJPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        managerjPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Age", "Gender", "Emergency Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectPatientToAccept(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jButton2.setText("Accept Selected Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout hospitalJPanelLayout = new org.jdesktop.layout.GroupLayout(hospitalJPanel);
        hospitalJPanel.setLayout(hospitalJPanelLayout);
        hospitalJPanelLayout.setHorizontalGroup(
            hospitalJPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, hospitalJPanelLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .add(jButton2)
                .add(214, 214, 214))
            .add(hospitalJPanelLayout.createSequentialGroup()
                .add(200, 200, 200)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
        hospitalJPanelLayout.setVerticalGroup(
            hospitalJPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(hospitalJPanelLayout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 257, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton2)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        mainJTabbedPane.addTab("Hospital", hospitalJPanel);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 496, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reports", jPanel1);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 496, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 507, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Activity Console", jPanel4);

        org.jdesktop.layout.GroupLayout managerjPanelLayout = new org.jdesktop.layout.GroupLayout(managerjPanel);
        managerjPanel.setLayout(managerjPanelLayout);
        managerjPanelLayout.setHorizontalGroup(
            managerjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(managerjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
        managerjPanelLayout.setVerticalGroup(
            managerjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(managerjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Reports");

        mainJTabbedPane.addTab("Manager", managerjPanel);

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save As ...");
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText("Help");

        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainJTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .add(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(mainJTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Accept selected patient. Move to report/END
        mainJTabbedPane.setSelectedIndex(5);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectPatientToAccept(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPatientToAccept
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPatientToAccept

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            taskClient.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable()   {

            public void run() {
                new UserUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel hospitalJPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane mainJTabbedPane;
    private javax.swing.JPanel managerjPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private void initTaskServer() {
        MyDroolsService.initTaskServer();
    }

    private void initTaskClient() {
        taskClient = MyDroolsService.initTaskClient();
    }

    void setUIMap(SlickBasicGame game) {
        this.game = game;
        game.addMapEventsListener(this);

    }

    public void callSelected(Long id) {

        currentTask = MyDroolsService.getTask(taskClient, id);
        BlockingTaskOperationResponseHandler responseHandler = new BlockingTaskOperationResponseHandler();
        taskClient.start(currentTask.getId(), "operator", responseHandler);

        this.emergencyInfoPanel.handleCall();
        mainJTabbedPane.setSelectedComponent(this.emergencyInfoPanel);
    }

    public void callHandled(ContentData data) {

        //Complete human Task
        BlockingTaskOperationResponseHandler blockingTaskOperationResponseHandler = new BlockingTaskOperationResponseHandler();
        taskClient.complete(currentTask.getId(), "operator", data, blockingTaskOperationResponseHandler);
        
        while (!blockingTaskOperationResponseHandler.isDone()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.prepareAmbulance();
    }

    private void prepareAmbulance() {
        try {
            ObjectInputStream ois = null;
            //Show ambulance tab.. with all the selected items
            BlockingTaskSummaryResponseHandler handler = new BlockingTaskSummaryResponseHandler();
            taskClient.getTasksAssignedAsPotentialOwner("control_operator", "en-UK", handler);
            List<TaskSummary> taskSums = handler.getResults();
            TaskSummary taskSum = taskSums.get(0);
            taskClient.start(taskSum.getId(), "control_operator", null);
            BlockingGetTaskResponseHandler handlerT = new BlockingGetTaskResponseHandler();
            taskClient.getTask(taskSum.getId(), handlerT);
            Task task2 = handlerT.getTask();
            TaskData taskData = task2.getTaskData();
            System.out.println("TaskData = " + taskData);
            BlockingGetContentResponseHandler handlerC = new BlockingGetContentResponseHandler();
            taskClient.getContent(taskData.getDocumentContentId(), handlerC);
            Content content = handlerC.getContent();
            System.out.println("Content= " + content);
            ByteArrayInputStream bais = new ByteArrayInputStream(content.getContent());
            ois = new ObjectInputStream(bais);
            String taskinfo = (String) ois.readObject();
            this.ambulancePanel.configurePanel(taskinfo);
            mainJTabbedPane.setSelectedComponent(ambulancePanel);
        } catch (Exception ex) {
            Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendAmbulance() throws IOException, ClassNotFoundException {
        BlockingTaskSummaryResponseHandler handler = new BlockingTaskSummaryResponseHandler();
        taskClient.getTasksAssignedAsPotentialOwner("control_operator", "en-UK", handler);
        List<TaskSummary> taskSums = handler.getResults();
        TaskSummary taskSum = taskSums.get(0);

        taskClient.start(taskSum.getId(), "control_operator", null);
        BlockingGetTaskResponseHandler handlerT = new BlockingGetTaskResponseHandler();
        taskClient.getTask(taskSum.getId(), handlerT);
        Task task2 = handlerT.getTask();
        TaskData taskData = task2.getTaskData();

        System.out.println("TaskData = " + taskData);
        BlockingGetContentResponseHandler handlerC = new BlockingGetContentResponseHandler();
        taskClient.getContent(taskData.getDocumentContentId(), handlerC);
        Content content = handlerC.getContent();

        System.out.println("Content= " + content);
        ByteArrayInputStream bais = new ByteArrayInputStream(content.getContent());

        ObjectInputStream ois = new ObjectInputStream(bais);
        //#{doctor.id}, #{ambulance.id},  #{patient.id}, #{patient.name}, #{patient.age}, #{patient.gender}, #{emergency.location}, #{emergency.type}
        String[] taskinfo = ((String) ois.readObject()).split(",");

        Long ambulanceId = Long.valueOf(taskinfo[1].trim());
        
        this.currentEmergenciesPanel.addNewEmergency(ambulanceId);
        mainJTabbedPane.setSelectedComponent(this.currentEmergenciesPanel);
        this.game.emergencyTypeSelected = EmergencyType.valueOf(taskinfo[7].trim());
        this.game.ambulanceSelectedId = ambulanceId;
        this.game.ambulanceDispatched = true;
        taskClient.complete(taskSum.getId(), "control_operator", null, null);
    }

    public void medicalEvaluationCompleted(int severity, String comment) {
        try {
            BlockingTaskSummaryResponseHandler handler = new BlockingTaskSummaryResponseHandler();
            taskClient.getTasksAssignedAsPotentialOwner("doctor", "en-UK", handler);
            List<TaskSummary> taskSums = handler.getResults();
            TaskSummary taskSum = taskSums.get(0);

            taskClient.start(taskSum.getId(), "doctor", null);
            BlockingGetTaskResponseHandler handlerT = new BlockingGetTaskResponseHandler();
            taskClient.getTask(taskSum.getId(), handlerT);
            Task task3 = handlerT.getTask();
            TaskData taskData = task3.getTaskData();

            System.out.println("TaskData = " + taskData);
            BlockingGetContentResponseHandler handlerC = new BlockingGetContentResponseHandler();
            taskClient.getContent(taskData.getDocumentContentId(), handlerC);
            Content content = handlerC.getContent();

            System.out.println("Content= " + content);
            ByteArrayInputStream bais = new ByteArrayInputStream(content.getContent());
            ObjectInputStream ois = new ObjectInputStream(bais);
            String taskinfo2 = (String) ois.readObject();

            System.out.println("TaskInfo 2= " + taskinfo2);
            HashMap<String, Object> info = new HashMap<String, Object>();


            info.put("emergency.priority", severity);
            ContentData result = new ContentData();
            result.setAccessType(AccessType.Inline);
            result.setType("java.util.Map");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(info);
            out.close();
            result.setContent(bos.toByteArray());

            taskClient.complete(taskSum.getId(), "doctor", result, null);

        } catch (Exception e) {
            Logger.getLogger(UserUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public JTabbedPane getMainJTabbedPane() {
        return mainJTabbedPane;
    }

    @Override
    public void hospitalReached(Block hospital) {
        System.out.println("HOSPITAL REACHED!");
    }

    @Override
    public void emergencyReached(Block emergency) {
        this.currentEmergenciesPanel.emergencyReached(emergency);
    }

    public TaskClient getTaskClient() {
        return taskClient;
    }

    @Override
    public void positionReceived(Block corner) {
        this.currentEmergenciesPanel.positionReceived(corner);
    }

    @Override
    public void heartBeatReceived(double value) {
        this.currentEmergenciesPanel.heartBeatReceived(value);
    }

    @Override
    public void hospitalSelected(Long id) {
        this.currentEmergenciesPanel.hospitalSelected(id);
    }
}
