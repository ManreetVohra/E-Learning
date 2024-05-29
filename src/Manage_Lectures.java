
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class Manage_Lectures extends javax.swing.JFrame 
{
    JFileChooser jfc,jfc1;
    File ph,lecture;
    ArrayList<Lecture> al = new ArrayList<>();
    myTableModel tm;
    
    public Manage_Lectures() 
    {
        initComponents();
        setSize(800,800);
        load_courses();
        tm = new myTableModel();
        mytable.setModel(tm);
    }
    
    void load_courses()
    {
        String  ans = myClient.loadCourses();
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            cb.addItem(name);
            cb1.addItem(name);
        }
    }
    
    void fetch_Lecture()
    {
        al.clear();
        
        int course_id = getCourseId((String)cb1.getSelectedItem());
        
        String ans = myClient.fetchLectures(course_id);
        StringTokenizer ft = new StringTokenizer(ans,";;");
        while(ft.hasMoreTokens())
        {
            String row = ft.nextToken();
            StringTokenizer ft1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(ft1.nextToken());
            String name = ft1.nextToken();
            String description = ft1.nextToken();
            String photo = ft1.nextToken();
            
            al.add(new Lecture(id,name,description,photo));
        }
        tm.fireTableDataChanged();
    }

   static int getCourseId(String lecturename)
   {
       String ans = myClient.loadCourses();
       StringTokenizer st = new StringTokenizer(ans,";;");
       int n = st.countTokens();
       for(int i=1;i<=n;i++)
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            if (name.equals(lecturename))
            {
                return i;
            }
        }
       return -1;
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
            if(j==0)
            {
                return al.get(i).name;
            }
            else if(j==1)
            {
                   return al.get(i).description;
            }
            else
            {
                return al.get(i).photo;
            }
        }
        
        @Override
        public String getColumnName(int j)
        {
            String name[]={"Name","Description","Photo"};
            return name[j];
        }
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptiontf = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        durationtf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        trailertf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        choose_lecture = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        cb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();
        view = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Lectures");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 800, 80);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Lectures");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 90, 400, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Lectures");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 90, 390, 23);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 210, 250, 20);

        nametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametfActionPerformed(evt);
            }
        });
        getContentPane().add(nametf);
        nametf.setBounds(60, 230, 250, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 270, 250, 20);

        descriptiontf.setColumns(20);
        descriptiontf.setRows(5);
        jScrollPane1.setViewportView(descriptiontf);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 290, 250, 70);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 370, 250, 20);

        durationtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationtfActionPerformed(evt);
            }
        });
        getContentPane().add(durationtf);
        durationtf.setBounds(60, 390, 250, 22);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setText("Trailer");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 430, 250, 20);

        trailertf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailertfActionPerformed(evt);
            }
        });
        getContentPane().add(trailertf);
        trailertf.setBounds(60, 450, 250, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setText("Lecture");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 490, 250, 20);

        choose_lecture.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        choose_lecture.setText("Choose Lecture");
        choose_lecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_lectureActionPerformed(evt);
            }
        });
        getContentPane().add(choose_lecture);
        choose_lecture.setBounds(60, 510, 250, 27);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setText("Photo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 560, 250, 16);

        photolb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photolb.setText("photo");
        getContentPane().add(photolb);
        photolb.setBounds(60, 590, 120, 130);

        browse.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse);
        browse.setBounds(220, 600, 90, 27);

        submit.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(220, 650, 90, 30);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb);
        cb.setBounds(60, 160, 250, 22);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setText("Course");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 140, 250, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setText("Course");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(400, 140, 250, 20);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb1);
        cb1.setBounds(400, 160, 250, 22);

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
        jScrollPane3.setViewportView(mytable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(390, 220, 390, 290);

        view.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view);
        view.setBounds(690, 160, 72, 27);

        delete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(550, 550, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametfActionPerformed

    private void trailertfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailertfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trailertfActionPerformed

    private void durationtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationtfActionPerformed

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

    private void choose_lectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_lectureActionPerformed
        jfc1 = new JFileChooser();
        int ans = jfc1.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            lecture = jfc1.getSelectedFile();
            JOptionPane.showMessageDialog(rootPane,"File Choosen");
        }
    }//GEN-LAST:event_choose_lectureActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String name = nametf.getText();
        String description = descriptiontf.getText();
        String duration = durationtf.getText();
        String trailer = trailertf.getText();
        int course_id = getCourseId((String)cb.getSelectedItem());
        
        String ans = myClient.addLectures(course_id,name,description,duration,ph,lecture,trailer);
        
        if(ans.trim().equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "success");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, ans);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        fetch_Lecture();
    }//GEN-LAST:event_viewActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int i = mytable.getSelectedRow();
        if(i==-1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please Select Row!");
        }
        else
        {
            int id = al.get(i).id;
            String ans = myClient.deleteLectures(id);
            if (ans.trim().equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane, "Successfully Deleted");
                fetch_Lecture();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed


    public static void main(String args[]) 
    {
      
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Manage_Lectures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton choose_lecture;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea descriptiontf;
    private javax.swing.JTextField durationtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable mytable;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel photolb;
    private javax.swing.JButton submit;
    private javax.swing.JTextField trailertf;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
