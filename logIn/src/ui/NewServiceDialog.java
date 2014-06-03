package ui;

import dao.ServiceDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import model.Location;
import model.Service;
import model.User;

/**
 *
 * @author Roshun Jones
 */
public class NewServiceDialog extends javax.swing.JDialog {
    private Main owner;
    private JPanel caller;
    
    /**
     * Creates new form NewServiceDialog
     */
    public NewServiceDialog(Main parent, boolean modal, JPanel caller) {
        super(parent, modal);
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        owner = parent;
        this.caller = caller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laTitle = new javax.swing.JLabel();
        laStartDate = new javax.swing.JLabel();
        laEndDate = new javax.swing.JLabel();
        laServiceTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        spDescription = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        laDescription = new javax.swing.JLabel();
        buSave = new javax.swing.JButton();
        buCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        laState = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        laZip = new javax.swing.JLabel();
        txtZip = new javax.swing.JTextField();
        laZip1 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        txtStartDate = new javax.swing.JFormattedTextField(new java.util.Date());
        txtEndDate = new javax.swing.JFormattedTextField(new java.util.Date());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        laTitle.setText("Add a Service");

        laStartDate.setText("Start Date:");

        laEndDate.setText("End Date:");

        laServiceTitle.setText("Service Title:");

        taDescription.setColumns(20);
        taDescription.setRows(5);
        spDescription.setViewportView(taDescription);

        laDescription.setText("Description:");

        buSave.setText("Save");
        buSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buSaveActionPerformed(evt);
            }
        });

        buCancel.setText("Cancel");
        buCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("City:");

        laState.setText("State:");

        laZip.setText("Zip:");

        laZip1.setText("Country:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addComponent(txtTitle)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(laStartDate)
                                .addComponent(laServiceTitle)
                                .addComponent(laDescription))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(laEndDate)
                                .addComponent(laTitle)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buSave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buCancel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(133, 133, 133))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(laZip)
                                .addGap(138, 138, 138)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laZip1)
                            .addComponent(laState)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laTitle)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laStartDate)
                    .addComponent(laEndDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laServiceTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(laZip)
                            .addComponent(laZip1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buSave)
                            .addComponent(buCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(laState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buCancelActionPerformed

    private void buSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buSaveActionPerformed
        User user = owner.loggedInUser;
        Service service = new Service(user.getUserId(), 
                (java.util.Date)txtStartDate.getValue(), (java.util.Date)txtEndDate.getValue(),
                txtTitle.getText(), taDescription.getText());
        
        Location location = new Location(txtCity.getText(), txtState.getText(), 
                txtZip.getText(), txtCountry.getText());
        
        service.setLocation(location);
        
        //Save Service
        ServiceDAO serviceDao = new ServiceDAO();
        try {
            serviceDao.createNewService(service);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        ((AdministratorView)caller).getCurrentServices();
        this.dispose();
    }//GEN-LAST:event_buSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buCancel;
    private javax.swing.JButton buSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel laDescription;
    private javax.swing.JLabel laEndDate;
    private javax.swing.JLabel laServiceTitle;
    private javax.swing.JLabel laStartDate;
    private javax.swing.JLabel laState;
    private javax.swing.JLabel laTitle;
    private javax.swing.JLabel laZip;
    private javax.swing.JLabel laZip1;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JFormattedTextField txtEndDate;
    private javax.swing.JFormattedTextField txtStartDate;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
