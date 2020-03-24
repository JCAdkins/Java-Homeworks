
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
AUTHOR: Jordan Adkins
Date: 4/22/18
Abstract: Creates a Pizza order menu that allows the user to input name, address and additional instructions
          as well as selecting the size, toppings and crust of their choosing.
 */

public class OrderMenu extends javax.swing.JFrame {

    /**
     * Creates new form OrderMenu
     */
    public OrderMenu() {
        initComponents(); //INITIALIZE COMPONENTS
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttongroupSize = new javax.swing.ButtonGroup();
        buttongroupCrust = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblCustInfo = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtState = new javax.swing.JList<>();
        lblZipCode = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblOrder = new javax.swing.JLabel();
        sizePanel = new javax.swing.JPanel();
        sizeIndividual = new javax.swing.JRadioButton();
        sizeSmall = new javax.swing.JRadioButton();
        sizeMedium = new javax.swing.JRadioButton();
        sizeLarge = new javax.swing.JRadioButton();
        sizeXtraLarge = new javax.swing.JRadioButton();
        crustPanel = new javax.swing.JPanel();
        crustThin = new javax.swing.JRadioButton();
        crustThick = new javax.swing.JRadioButton();
        crustCheeseStuffed = new javax.swing.JRadioButton();
        ToppingPanel = new javax.swing.JPanel();
        toppingPepperoni = new javax.swing.JCheckBox();
        toppingHam = new javax.swing.JCheckBox();
        toppingBacon = new javax.swing.JCheckBox();
        toppingSausage = new javax.swing.JCheckBox();
        toppingChicken = new javax.swing.JCheckBox();
        toppingPineapple = new javax.swing.JCheckBox();
        toppingPeppers = new javax.swing.JCheckBox();
        toppingMushrooms = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAdditionalInstructs = new javax.swing.JTextArea();
        lblAddnlInstructs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setText("Name:");

        txtFirstName.setColumns(16);
        txtFirstName.setName(""); // NOI18N

        txtLastName.setColumns(24);
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        lblCustInfo.setText("Customer Information");

        lblAddress.setText("Address:");

        lblState.setText("State: ");

        txtState.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(txtState);

        lblZipCode.setText("Zip Code:");

        txtZipCode.setColumns(5);

        lblPhone.setText("Phone:");

        txtPhone.setColumns(10);

        lblOrder.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblOrder.setText("Order:");

        sizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Size:"));

        buttongroupSize.add(sizeIndividual);
        sizeIndividual.setText("Individual");

        buttongroupSize.add(sizeSmall);
        sizeSmall.setText("Small");

        buttongroupSize.add(sizeMedium);
        sizeMedium.setText("Medium");
        sizeMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeMediumActionPerformed(evt);
            }
        });

        buttongroupSize.add(sizeLarge);
        sizeLarge.setText("Large");

        buttongroupSize.add(sizeXtraLarge);
        sizeXtraLarge.setText("Xtra-Large");
        sizeXtraLarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeXtraLargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sizePanelLayout = new javax.swing.GroupLayout(sizePanel);
        sizePanel.setLayout(sizePanelLayout);
        sizePanelLayout.setHorizontalGroup(
            sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizePanelLayout.createSequentialGroup()
                .addGroup(sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeIndividual)
                    .addComponent(sizeSmall)
                    .addComponent(sizeMedium)
                    .addComponent(sizeLarge)
                    .addComponent(sizeXtraLarge))
                .addGap(13, 13, 13))
        );
        sizePanelLayout.setVerticalGroup(
            sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sizeIndividual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeLarge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sizeXtraLarge)
                .addContainerGap())
        );

        crustPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Crust:"));

        buttongroupCrust.add(crustThin);
        crustThin.setText("Thin");

        buttongroupCrust.add(crustThick);
        crustThick.setText("Thick");

        buttongroupCrust.add(crustCheeseStuffed);
        crustCheeseStuffed.setText("Cheese Stuffed");

        javax.swing.GroupLayout crustPanelLayout = new javax.swing.GroupLayout(crustPanel);
        crustPanel.setLayout(crustPanelLayout);
        crustPanelLayout.setHorizontalGroup(
            crustPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crustPanelLayout.createSequentialGroup()
                .addGroup(crustPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crustThin)
                    .addComponent(crustThick)
                    .addComponent(crustCheeseStuffed))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        crustPanelLayout.setVerticalGroup(
            crustPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crustPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crustThin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crustThick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crustCheeseStuffed)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ToppingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Toppings:"));

        toppingPepperoni.setText("Pepperoni");
        toppingPepperoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toppingPepperoniActionPerformed(evt);
            }
        });

        toppingHam.setText("Ham");

        toppingBacon.setText("Bacon");

        toppingSausage.setText("Sausage");

        toppingChicken.setText("Chicken");
        toppingChicken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toppingChickenActionPerformed(evt);
            }
        });

        toppingPineapple.setText("Pineapple");
        toppingPineapple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toppingPineappleActionPerformed(evt);
            }
        });

        toppingPeppers.setText("Peppers");

        toppingMushrooms.setText("Mushrooms");

        javax.swing.GroupLayout ToppingPanelLayout = new javax.swing.GroupLayout(ToppingPanel);
        ToppingPanel.setLayout(ToppingPanelLayout);
        ToppingPanelLayout.setHorizontalGroup(
            ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToppingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toppingPepperoni, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toppingPeppers)
                    .addComponent(toppingHam)
                    .addComponent(toppingBacon))
                .addGap(24, 24, 24)
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toppingSausage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toppingPineapple)
                    .addComponent(toppingChicken)
                    .addComponent(toppingMushrooms))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        ToppingPanelLayout.setVerticalGroup(
            ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToppingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toppingPepperoni)
                    .addComponent(toppingMushrooms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toppingPineapple)
                    .addComponent(toppingPeppers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toppingChicken)
                    .addComponent(toppingHam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToppingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toppingSausage)
                    .addComponent(toppingBacon))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtAdditionalInstructs.setColumns(20);
        txtAdditionalInstructs.setRows(5);
        jScrollPane2.setViewportView(txtAdditionalInstructs);

        lblAddnlInstructs.setText("Additional Instructions:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblCustInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblAddress)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblName)
                                    .addGap(21, 21, 21)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblState)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(lblZipCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPhone)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(lblOrder)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddnlInstructs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ToppingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(crustPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFirstName)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblState)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhone)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblZipCode)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToppingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crustPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddnlInstructs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // NOTHING TO DO HERE
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void sizeMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeMediumActionPerformed
        // NOTHING TO DO HERE
    }//GEN-LAST:event_sizeMediumActionPerformed

    private void sizeXtraLargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeXtraLargeActionPerformed

    }//GEN-LAST:event_sizeXtraLargeActionPerformed

    private void toppingChickenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toppingChickenActionPerformed
        // NOTHING TO DO HERE MOVE ALONG
    }//GEN-LAST:event_toppingChickenActionPerformed

    private void toppingPepperoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toppingPepperoniActionPerformed
        // NOTHING TO DO HERE
    }//GEN-LAST:event_toppingPepperoniActionPerformed

    private void toppingPineappleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toppingPineappleActionPerformed
        // NOTHING TO DO HERE
    }//GEN-LAST:event_toppingPineappleActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (buttongroupSize.getSelection()==null || buttongroupCrust.getSelection()==null || txtFirstName.getText()==null || txtLastName.getText()==null || txtAddress.getText()==null || txtPhone.getText()==null || txtState.getSelectedValue()==null || txtZipCode.getText()==null ){
            JOptionPane.showMessageDialog(null, "Value Missing!");
        }else{
        
        
        ArrayList<String> toppings = new ArrayList<>();         //logic when the submit button is pressed
        if (toppingPepperoni.isSelected()==true){               //checks to see which topping are selected
            toppings.add("Pepperoni");                          // if selected adds it to ArrayList topping
        }
        if (toppingMushrooms.isSelected()==true){
            toppings.add("Mushrooms");
        }
        if (toppingPeppers.isSelected()==true){
            toppings.add("Peppers");
        }
        if (toppingPineapple.isSelected()==true){
            toppings.add("Pineapple");
        }
        if (toppingHam.isSelected()==true){
            toppings.add("Ham");
        }
        if (toppingChicken.isSelected()==true){
            toppings.add("Chicken");
        }
        if (toppingBacon.isSelected()==true){
            toppings.add("Bacon");
        }
        if (toppingSausage.isSelected()==true){
            toppings.add("Sausage");
        }
        
        String size = new String();                         //checks to see the size of the pizza
        if (sizeIndividual.isSelected()==true){
            size = "individual";
        }
        if (sizeSmall.isSelected()==true){
            size = "small";
        }
        if (sizeMedium.isSelected()==true){
            size = "medium";
        }
        if (sizeLarge.isSelected()==true){
            size = "large";
        }
        if (sizeXtraLarge.isSelected()==true){
            size = "exra large";
        }
        String crust = new String();                //checks the crust of the pizza
        if (crustThin.isSelected()==true){
            crust = "Thin";
        }
        if (crustThick.isSelected()==true){
            crust = "Thick";
        }
        if (crustCheeseStuffed.isSelected()==true){
            crust = "Cheese Stuffed";
        }
        Pizza newPizza = new Pizza(size, toppings, crust);          //create new pizza object called new pizza
        OrderSummary dialog = new OrderSummary(new javax.swing.JFrame(), true, newPizza);       //creates new Ordersummary w/ a new jfram and newpizza as a insert params
        dialog.setVisible(true);
        clearData();        //clears all set data from menu
        
        
        }    
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
       System.exit(0);          //exits the application
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
            //creates a joptionpane which asks the user if they want to cancel
        int userChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel?", "Cancel Order", JOptionPane.YES_NO_OPTION);
       if (userChoice==0){      //if yes clear all data
           clearData();
       }else{       //if no do nothing
           
       }
       
    }//GEN-LAST:event_btnCancelActionPerformed

    private void clearData(){            //method that clears data from the menu
buttongroupCrust.clearSelection();
        buttongroupSize.clearSelection();
        toppingBacon.setSelected(false);
        toppingChicken.setSelected(false);
        toppingHam.setSelected(false);
        toppingMushrooms.setSelected(false);
        toppingPepperoni.setSelected(false);
        toppingPeppers.setSelected(false);
        toppingPineapple.setSelected(false);
        toppingSausage.setSelected(false);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAdditionalInstructs.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtZipCode.setText("");
        txtState.clearSelection();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {            //main method
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
            java.util.logging.Logger.getLogger(OrderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrderMenu().setVisible(true);           //creates a new OrderMenu and makes it visible
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ToppingPanel;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttongroupCrust;
    private javax.swing.ButtonGroup buttongroupSize;
    private javax.swing.JRadioButton crustCheeseStuffed;
    private javax.swing.JPanel crustPanel;
    private javax.swing.JRadioButton crustThick;
    private javax.swing.JRadioButton crustThin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddnlInstructs;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCustInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JRadioButton sizeIndividual;
    private javax.swing.JRadioButton sizeLarge;
    private javax.swing.JRadioButton sizeMedium;
    private javax.swing.JPanel sizePanel;
    private javax.swing.JRadioButton sizeSmall;
    private javax.swing.JRadioButton sizeXtraLarge;
    private javax.swing.JCheckBox toppingBacon;
    private javax.swing.JCheckBox toppingChicken;
    private javax.swing.JCheckBox toppingHam;
    private javax.swing.JCheckBox toppingMushrooms;
    private javax.swing.JCheckBox toppingPepperoni;
    private javax.swing.JCheckBox toppingPeppers;
    private javax.swing.JCheckBox toppingPineapple;
    private javax.swing.JCheckBox toppingSausage;
    private javax.swing.JTextArea txtAdditionalInstructs;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JList<String> txtState;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}

