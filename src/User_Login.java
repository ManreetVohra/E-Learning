
import javax.swing.*;


public class User_Login extends javax.swing.JFrame 
{

    
    public User_Login() 
    {
        initComponents();
        setSize(500,500);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        pf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(123, 38, 260, 59);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setText("User Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(72, 169, 79, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(72, 259, 94, 23);

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(214, 167, 215, 22);

        pf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfActionPerformed(evt);
            }
        });
        getContentPane().add(pf);
        pf.setBounds(214, 257, 215, 22);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(169, 333, 130, 37);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void pfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String email =tf.getText();
       String password = pf.getText();
       if(email.isEmpty()||password.equals(""))
       {
           JOptionPane.showMessageDialog(rootPane,"All fiels are mandatory");
       }
       else
       {
           String ans = myClient.Login(email,password);
           if(ans.trim().equals("success"))
           {
               JOptionPane.showMessageDialog(rootPane,"Login Successful");
               
               user_home obj =new user_home(email);
               obj.setVisible(true);
               dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane,ans);
           }
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[])
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new User_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
