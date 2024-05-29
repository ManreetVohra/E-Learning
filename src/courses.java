
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class courses extends javax.swing.JFrame 
{ 
    String category;

   
    public courses(String name) 
    {
        initComponents();
        setSize(600,500);
        
        category = name;
        
        JOptionPane.showMessageDialog(rootPane,category);
        
        load_courses();
    }
    
    void load_courses()
    {
        String ans = myClient.courses(category);
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        
        //get number of rows
        int n = st.countTokens();
        
        JButton arr[] = new JButton[n];
        
        int x =10,y=10;
        for(int i =0;i<n;i++)
        {
            //to get Row
            String row = st.nextToken();
            //parse particular row
            StringTokenizer st1 = new StringTokenizer(row,"$");
            //get data form particular row
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            String photo = st1.nextToken();
            
            arr[i] = new JButton(name);
            
            
            ImageIcon ic = new ImageIcon(photo);
            //resize your image icon using Image class
            Image img = ic.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
            //convert Image object to ImageIcon
            ImageIcon ic1 = new ImageIcon(img);
            //set icon or button
            arr[i].setIcon(ic1);
            
            arr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    lectures obj = new lectures(id);
                    obj.setVisible(true);
                    dispose();
                }
                        
            });
            //set Bounds
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
            .addGap(0, 548, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 540, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) 
    {
   
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new courses("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
