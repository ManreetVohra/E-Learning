
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class user_home extends javax.swing.JFrame 
{
    public user_home(String email) 
    {
        initComponents();
        setSize(500,500);
        lb.setText("Welcome "+email);
        loadcategory();
    }

    void loadcategory()
    {
        String ans = myClient.fetchcat();
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
        
        JButton arr[] = new JButton[n];
        
        int x=10,y=10;
        
        for (int i =0;i<n;i++)
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row, "$");
            String name = st1.nextToken();
            String photo = st1.nextToken();
            
            arr[i] = new JButton(name);
            
            arr[i].setBounds(x, y ,200,100);
            
            ImageIcon ic = new ImageIcon(photo);
            Image img = ic.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
            ImageIcon  ic1 = new ImageIcon(img);
            
            arr[i].setIcon(ic1);
            
            arr[i].setBounds(x,y,200,100);
            
            arr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                   //open next frame
                    courses obj = new courses(name);
                    obj.setVisible(true);
                    dispose();
                }        
                        
            });
            
            if(x<210)
            {
                x = x+200;
                System.out.println("--->"+x);
                System.out.println("--->"+name);
            }
            else
            {
                System.out.println("--->"+x);
                System.out.println("--->"+name);
                x=10;
                y=y+100;
            }

            mainpanel.add(arr[i]);
            mainpanel.repaint();
            
          
        }
        mainpanel.setPreferredSize(new Dimension(420,y + 100));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        lb.setForeground(new java.awt.Color(153, 153, 255));
        getContentPane().add(lb);
        lb.setBounds(60, 0, 380, 90);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 140, 2, 2);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(mainpanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 120, 380, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new user_home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
