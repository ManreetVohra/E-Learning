
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class lectures extends javax.swing.JFrame 
{

    int course_id;
    public lectures(int id) 
    {
        initComponents();
        setSize(500,500);
        course_id = id;
        load_lectures();
    }
    
    void load_lectures()
    {
        String ans = myClient.fetchlectures(course_id);
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
        JButton arr[]=new JButton[n];
        int x = 10,y = 10;
        
         for(int i =0;i<n;i++)
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            String photo = st1.nextToken();
            
            arr[i] = new JButton(name);
            
            ImageIcon ic = new ImageIcon(photo);
            Image img = ic.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            arr[i].setIcon(ic1);
            
            arr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    lecture_detail obj = new lecture_detail(id);
                    obj.setVisible(true);
                    dispose();
                }
                        
            });
            
            arr[i].setBounds(x,y,200,100);
            mainpanel.add(arr[i]);
            mainpanel.repaint();
            
            if(x<220)
            {
                x = x+210;
                System.out.println("--->"+x);
            }
            else
            {
                x = 10;
                y = y+110;
            }
            mainpanel.setPreferredSize(new Dimension(440,y+100));
            
        }
    }     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(24, 79, 452, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) 
    {
      
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new lectures(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
