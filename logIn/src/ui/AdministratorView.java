package ui;

import dao.ServiceDAO;
import javax.swing.WindowConstants;

/**
 *
 * @author Roshun Jones
 */
public class AdministratorView extends javax.swing.JPanel {
    private Main owner = null;
    private String[] columnNames = {"Service ID","Title","Start Date","End Date","Description"};
    
    public AdministratorView(Main owner) {
        initComponents();
        setVisible(true);
        this.owner = owner;
        getCurrentServices();
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
        laAvailable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVolunteers = new javax.swing.JTable();
        laAvailable1 = new javax.swing.JLabel();
        buAddService = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvailable = new javax.swing.JTable();

        laTitle.setText("Administrator View");

        laAvailable.setText("Available Services:");

        tblVolunteers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Service ID", "First Name", "Last Name", "Phone"
            }
        ));
        jScrollPane1.setViewportView(tblVolunteers);

        laAvailable1.setText("Interested Volunteers:");

        buAddService.setText("Add Service");
        buAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAddServiceActionPerformed(evt);
            }
        });

        tblAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Service ID", "Title", "Start Date", "End Date", "Description"
            }
        ));
        jScrollPane2.setViewportView(tblAvailable);
        if (tblAvailable.getColumnModel().getColumnCount() > 0) {
            tblAvailable.getColumnModel().getColumn(4).setHeaderValue("Description");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(laAvailable))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(laAvailable1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buAddService))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(laTitle)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(laTitle)
                .addGap(18, 18, 18)
                .addComponent(laAvailable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buAddService)
                .addGap(12, 12, 12)
                .addComponent(laAvailable1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAddServiceActionPerformed
        NewServiceDialog serviceDlg = new NewServiceDialog(owner, true, this);
        serviceDlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        serviceDlg.setVisible(true);
    }//GEN-LAST:event_buAddServiceActionPerformed
    
    public void getCurrentServices() {
        ServiceDAO serviceDao = new ServiceDAO();
        Object[][] data = null;
        try {
            data = serviceDao.getAvailableServices();
        } catch(Exception e) {
            e.printStackTrace();
        }
      
        tblAvailable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        this.revalidate();
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buAddService;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel laAvailable;
    private javax.swing.JLabel laAvailable1;
    private javax.swing.JLabel laTitle;
    private javax.swing.JTable tblAvailable;
    private javax.swing.JTable tblVolunteers;
    // End of variables declaration//GEN-END:variables
}
