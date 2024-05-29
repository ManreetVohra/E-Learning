
public class admin_home extends javax.swing.JFrame 
{

    public admin_home(String name)
    {
        initComponents();
        setSize(500,400);
        
        lb.setText("Welcome "+name);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        manage_categories = new javax.swing.JButton();
        manage_courses = new javax.swing.JButton();
        manage_lectures = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("WELCOME");
        getContentPane().add(lb);
        lb.setBounds(0, 20, 500, 50);

        manage_categories.setText("Manage Categories");
        manage_categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_categoriesActionPerformed(evt);
            }
        });
        getContentPane().add(manage_categories);
        manage_categories.setBounds(165, 123, 170, 40);

        manage_courses.setText("Manage Courses");
        manage_courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_coursesActionPerformed(evt);
            }
        });
        getContentPane().add(manage_courses);
        manage_courses.setBounds(170, 200, 170, 40);

        manage_lectures.setText("Manage Lectures");
        manage_lectures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_lecturesActionPerformed(evt);
            }
        });
        getContentPane().add(manage_lectures);
        manage_lectures.setBounds(170, 270, 170, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manage_coursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_coursesActionPerformed
        Manage_Courses obj = new Manage_Courses();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_manage_coursesActionPerformed

    private void manage_categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_categoriesActionPerformed
        Manage_Categories obj = new Manage_Categories();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_manage_categoriesActionPerformed

    private void manage_lecturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_lecturesActionPerformed
        Manage_Lectures obj = new Manage_Lectures();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_manage_lecturesActionPerformed

    
    public static void main(String args[]) 
    {
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new admin_home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb;
    private javax.swing.JButton manage_categories;
    private javax.swing.JButton manage_courses;
    private javax.swing.JButton manage_lectures;
    // End of variables declaration//GEN-END:variables
}
