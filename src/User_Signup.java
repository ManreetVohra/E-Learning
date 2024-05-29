
import java.awt.Image;
import java.io.File;
import javax.swing.*;


public class User_Signup extends javax.swing.JFrame
{

    JFileChooser jfc;
    File ph;
    public User_Signup() 
    {
        initComponents();
        setSize(615,500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        emailtf = new javax.swing.JTextField();
        passwordpf = new javax.swing.JPasswordField();
        mobiletf = new javax.swing.JTextField();
        addresstf = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER SIGNUP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(178, 25, 204, 44);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setText("Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(131, 116, 41, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(99, 175, 73, 23);

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setText("Mobile");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(119, 233, 53, 23);

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(112, 289, 60, 23);

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel6.setText("Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(126, 350, 46, 23);

        browse.setBackground(new java.awt.Color(204, 204, 204));
        browse.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse);
        browse.setBounds(457, 347, 85, 30);
        getContentPane().add(emailtf);
        emailtf.setBounds(252, 114, 239, 22);

        passwordpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordpfActionPerformed(evt);
            }
        });
        getContentPane().add(passwordpf);
        passwordpf.setBounds(252, 173, 239, 22);
        getContentPane().add(mobiletf);
        mobiletf.setBounds(252, 231, 239, 22);
        getContentPane().add(addresstf);
        addresstf.setBounds(252, 290, 335, 22);
        getContentPane().add(lb);
        lb.setBounds(252, 352, 109, 90);

        submit.setBackground(new java.awt.Color(153, 153, 153));
        submit.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(201, 454, 184, 49);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
      jfc = new JFileChooser();
      
      int ans = jfc.showOpenDialog(this);
      
      if(ans == JFileChooser.APPROVE_OPTION) 
      {
          ph = jfc.getSelectedFile();
          
          ImageIcon ic = new ImageIcon(ph.getPath());
          Image img = ic.getImage().getScaledInstance(getWidth(),lb.getHeight(),Image.SCALE_SMOOTH);
          ImageIcon ic1 = new ImageIcon(img);
          
          lb.setIcon(ic1);
      }
    }//GEN-LAST:event_browseActionPerformed

    private void passwordpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordpfActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String email = emailtf.getText();
        String password = passwordpf.getText();
        String mobile = mobiletf.getText();
        String address = addresstf.getText();
        
        if(email.isEmpty()||password.isEmpty()||mobile.isEmpty()||address.isEmpty()||ph==null)
        {
            JOptionPane.showMessageDialog(rootPane,"All fields are mandatory");
        }
        else
        {
            String ans = myClient.Signup(email, password, mobile, address, ph);
            
            if(ans.equals("success"))
            {
               JOptionPane.showMessageDialog(rootPane, "Signup Successful");
            }
            else if(ans.equals("exist"))
            {
                JOptionPane.showMessageDialog(rootPane, "User Already Exists");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
        }    
    }//GEN-LAST:event_submitActionPerformed

   
    public static void main(String args[]) 
    {
    
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new User_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addresstf;
    private javax.swing.JButton browse;
    private javax.swing.JTextField emailtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb;
    private javax.swing.JTextField mobiletf;
    private javax.swing.JPasswordField passwordpf;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
