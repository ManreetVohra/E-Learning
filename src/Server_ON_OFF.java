
public class Server_ON_OFF extends javax.swing.JFrame 
{

    myServer obj;
    
    public Server_ON_OFF()
    {
        initComponents();
        setSize(500,500);
        
        Server_OFF.setEnabled(false);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Server_ON = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Server_OFF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Server_ON.setBackground(new java.awt.Color(204, 255, 255));
        Server_ON.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        Server_ON.setForeground(new java.awt.Color(51, 0, 153));
        Server_ON.setText("SERVER ON");
        Server_ON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_ONActionPerformed(evt);
            }
        });
        getContentPane().add(Server_ON);
        Server_ON.setBounds(160, 140, 190, 120);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVER ON OFF");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 40, 500, 70);

        Server_OFF.setBackground(new java.awt.Color(204, 255, 255));
        Server_OFF.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        Server_OFF.setForeground(new java.awt.Color(0, 51, 153));
        Server_OFF.setText("SERVER OFF");
        Server_OFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_OFFActionPerformed(evt);
            }
        });
        getContentPane().add(Server_OFF);
        Server_OFF.setBounds(160, 290, 190, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Server_ONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_ONActionPerformed

        try
        {
        obj = new myServer(9000);
        Server_ON.setEnabled(false);
        Server_OFF.setEnabled(true);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Server_ONActionPerformed

    private void Server_OFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_OFFActionPerformed
        
        obj.shutdown();
        Server_OFF.setEnabled(false);
        Server_ON.setEnabled(true);
    }//GEN-LAST:event_Server_OFFActionPerformed

    public static void main(String args[])
    {
    
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Server_ON_OFF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Server_OFF;
    private javax.swing.JButton Server_ON;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
