
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class Manage_Categories extends javax.swing.JFrame 
{

    File ph;
    JFileChooser jfc;
    ArrayList<Category> al =new ArrayList<>();
    myTableModel tm;
    public Manage_Categories() 
    {
        initComponents();
        setSize(800,400);
        load_category();
        tm = new myTableModel();
        mytable.setModel(tm);
        
    }
    
    void load_category()
    {
        al.clear();
        String ans = myClient.manageCat();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {
            String row = st.nextToken();
            StringTokenizer st1= new StringTokenizer(row,"$");
            String name = st1.nextToken();
            String photo = st1.nextToken();
            al.add(new Category(name,photo));
        }
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
            return 2;
        }

        @Override
        public Object getValueAt(int i, int j)
        {
            if(j ==0)
            {
                return al.get(i).name;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        catname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mytable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 20, 800, 50);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 80, 400, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("View Category");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 76, 390, 40);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(570, 150, 2, 2);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(535, 350, 190, 23);

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Category Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 150, 230, 30);

        catname.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        getContentPane().add(catname);
        catname.setBounds(90, 192, 230, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel5.setText("Photo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 240, 140, 30);

        photolb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photolb.setText("photo");
        getContentPane().add(photolb);
        photolb.setBounds(87, 276, 130, 100);

        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse);
        browse.setBounds(270, 270, 72, 23);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(270, 330, 72, 23);

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
        jScrollPane2.setViewportView(mytable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(432, 112, 360, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            ImageIcon ic = new ImageIcon(ph.getPath());
            Image img = ic.getImage().getScaledInstance(photolb.getWidth(),photolb.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            photolb.setIcon(ic1);
            
        }
    }//GEN-LAST:event_browseActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String category = catname.getText();
        String ans = myClient.addCategory(category,ph);
        
        if(ans.trim().equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane,"Added Successfully");
            catname.setText("");
            photolb.setIcon(null);
            load_category();
            tm.fireTableDataChanged();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,ans);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int i = mytable.getSelectedRow();
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Please select row!");
            
        }
        else
        {
            String ans = myClient.deletecat(al.get(i).name);
            if (ans.trim().equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane,"deleted succesfully");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane,"Failed");
            }
        }    
    }//GEN-LAST:event_deleteActionPerformed

    
    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new Manage_Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JTextField catname;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mytable;
    private javax.swing.JLabel photolb;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
