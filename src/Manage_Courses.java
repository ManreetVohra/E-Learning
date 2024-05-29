
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class Manage_Courses extends javax.swing.JFrame 
{
    JFileChooser jfc;
    File ph;
    ArrayList<Course> al = new ArrayList<>();
    myTableModel tm;
    
    public Manage_Courses() 
    {
        initComponents();
        setSize(800,400);
        load_category();
        tm = new myTableModel();
        mytable.setModel(tm);
    }
    
    void load_category()
    {
        String ans = myClient.fetchCategories();
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
        cb1.addItem("Select");
        for(int i=1;i<=n;i++)
        {
            String name = st.nextToken();
            cb.addItem(name);
            cb1.addItem(name);
        }
            
    }
    
    void fetchData()
    {
        String category = (String)cb1.getSelectedItem();
        String ans = myClient.fetchCourses(category);
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        
        al.clear();
        while(st.hasMoreTokens())
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            String desc = st1.nextToken();
            String photo = st1.nextToken();
            
            al.add(new Course(id,name,desc,photo));
        }    
        tm.fireTableDataChanged();
    }
    
    class myTableModel extends AbstractTableModel
    {

        @Override
        public int getRowCount() 
        {
            return al.size();
        }

        @Override
        public int getColumnCount()
        {
            return 3;
        }

        @Override
        public Object getValueAt(int i, int j)
        {
            if(j == 0)
            {
                return al.get(i).name;
            }
            else if(j == 1)
            {
                return al.get(i).desc;
            }
            else
            {
                return al.get(i).photo;
            }
        }
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        course_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_description = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Courses");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 800, 70);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Courses");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 90, 400, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Courses");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 90, 390, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel4.setText("Category");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 140, 170, 20);

        getContentPane().add(cb1);
        cb1.setBounds(480, 170, 170, 22);

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel6.setText("Category");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 140, 110, 18);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb);
        cb.setBounds(60, 170, 170, 22);

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel7.setText("Name");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 210, 170, 18);

        course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_nameActionPerformed(evt);
            }
        });
        getContentPane().add(course_name);
        course_name.setBounds(60, 230, 170, 22);

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 270, 170, 18);

        course_description.setColumns(20);
        course_description.setRows(5);
        jScrollPane1.setViewportView(course_description);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 290, 170, 80);

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel8.setText("Photo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 390, 170, 18);

        photolb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photolb.setText("photo");
        getContentPane().add(photolb);
        photolb.setBounds(60, 420, 100, 110);

        browse.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse);
        browse.setBounds(210, 420, 100, 30);

        submit.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(210, 470, 100, 30);

        delete.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(560, 470, 100, 30);

        mytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(mytable);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(420, 220, 370, 220);

        view.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view);
        view.setBounds(690, 170, 72, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_nameActionPerformed

    }//GEN-LAST:event_course_nameActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            ImageIcon ic = new ImageIcon(ph.getPath());
            Image img = ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            photolb.setIcon(ic1);
        }
        
    }//GEN-LAST:event_browseActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String coursename = course_name.getText();
        String coursedescription = course_description.getText();
        String category = (String)cb.getSelectedItem();
        
        String ans = myClient.addCourse(category, coursename, coursedescription, ph);
        
        if(ans.trim().equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "success");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int i = mytable.getSelectedRow();
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane,"Please select row!");
        }
        else
        {
            int id = al.get(i).id;
            String ans = myClient.delCourse(id);
            
            if(ans.trim().equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
                fetchData();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "failed");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        fetchData(); 
    }//GEN-LAST:event_viewActionPerformed

    public static void main(String args[]) 
    {
      
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Manage_Courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JTextArea course_description;
    private javax.swing.JTextField course_name;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable mytable;
    private javax.swing.JLabel photolb;
    private javax.swing.JButton submit;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
