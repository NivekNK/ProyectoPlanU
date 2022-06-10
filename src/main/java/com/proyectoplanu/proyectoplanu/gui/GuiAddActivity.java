package com.proyectoplanu.proyectoplanu.gui;

import com.proyectoplanu.proyectoplanu.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class GuiAddActivity extends javax.swing.JPanel
{
    private Calendary calendary;
    
    private String name;
    private int hour;
    private int min;
    private String managerRut;
    
    private String date;
    private GuiActivity guiActivity;
    
    public GuiAddActivity(Calendary calendary, GuiActivity guiActivity)
    {
        initComponents();
        this.calendary = calendary;
        this.guiActivity = guiActivity;
        
        nameError.setText("");
        hourError.setText("");
        
        updateManagers();
    }
    
    public void showReturnButton(boolean show)
    {
        returnButton.setVisible(show);
    }
    
    public void updateManagers()
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
        for (Manager manager : calendary.getManagers())
        {
            model.addElement(manager.getRut());
        }
        managersBox.setModel(model);
        managersBox.setSelectedIndex(0);
        
        managerRut = (String)managersBox.getSelectedItem();
    }
    
    public void updateCurrentActitivites()
    {
        ArrayList<Activity> activities = calendary
                .getActivityCollection()
                .getActivitiesInDate(date);
        guiActivity.updateCurrentDayActivities(activities);
    }
    
    public void setDate(int day, int month, int year)
    {
        date = Activity.parseDate(day, month, year);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        newActivityLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        hourLabel = new javax.swing.JLabel();
        hourTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        minTextField = new javax.swing.JTextField();
        managersBox = new javax.swing.JComboBox<>();
        managerLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        nameError = new javax.swing.JLabel();
        hourError = new javax.swing.JLabel();
        nameTextField = new javax.swing.JFormattedTextField();

        jScrollPane1.setViewportView(jEditorPane1);

        newActivityLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        newActivityLabel.setText("Nueva Actividad");

        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        returnButton.setText("<");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel.setText("Nombre:");

        hourLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hourLabel.setText("Hora:");

        hourTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hourTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hourTextFieldFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText(":");

        minTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        minTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                minTextFieldFocusLost(evt);
            }
        });

        managersBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        managersBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managersBoxActionPerformed(evt);
            }
        });

        managerLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        managerLabel.setText("Encargado:");

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        nameError.setForeground(new java.awt.Color(255, 0, 0));
        nameError.setText("Error");

        hourError.setForeground(new java.awt.Color(255, 0, 0));
        hourError.setText("Error");

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(returnButton)
                            .addGap(240, 240, 240)
                            .addComponent(newActivityLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addGap(75, 75, 75)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameError)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hourLabel)
                                    .addComponent(managerLabel))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(hourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(minTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(managersBox, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hourError)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newActivityLabel)
                    .addComponent(returnButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hourTextField)
                            .addComponent(hourLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hourError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(managersBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managerLabel))
                .addGap(54, 54, 54)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void managersBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managersBoxActionPerformed
        managerRut = (String)managersBox.getSelectedItem();
    }//GEN-LAST:event_managersBoxActionPerformed

    private void nameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFieldFocusLost
        name = nameTextField.getText();
        if (name.isEmpty())
            nameError.setText("Nombre no puede estar vacio.");
        else
            nameError.setText("");
    }//GEN-LAST:event_nameTextFieldFocusLost

    private void hourTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hourTextFieldFocusLost
        String text = hourTextField.getText();
        try
        {
            hour = Integer.parseInt(text);
            if (hour < 0 || hour > 23)
                hourError.setText("Ingresar valores entre 00 y 23 horas.");
            else
                hourError.setText("");
        }
        catch (NumberFormatException err)
        {
            hourError.setText("Ingresar solo numeros.");
        }
    }//GEN-LAST:event_hourTextFieldFocusLost

    private void minTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_minTextFieldFocusLost
        String text = minTextField.getText();
        try
        {
            min = Integer.parseInt(text);
            if (min < 0 || min > 59)
                hourError.setText("Ingresar valores entre 00 y 59 minutos.");
            else
                hourError.setText("");
        }
        catch (NumberFormatException err)
        {
            hourError.setText("Ingresar solo numeros.");
        }
    }//GEN-LAST:event_minTextFieldFocusLost

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        guiActivity.returnToCurrentDay(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (nameError.getText().isEmpty() && hourError.getText().isEmpty())
        {
            Manager manager = calendary.getManager(managerRut);
            Activity activity = new Activity(name, date, hour, manager);
            calendary.addActivity(activity);
            updateCurrentActitivites();
            guiActivity.returnToCurrentDay(true);
        }
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel hourError;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JTextField hourTextField;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel managerLabel;
    private javax.swing.JComboBox<String> managersBox;
    private javax.swing.JTextField minTextField;
    private javax.swing.JLabel nameError;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JFormattedTextField nameTextField;
    private javax.swing.JLabel newActivityLabel;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
