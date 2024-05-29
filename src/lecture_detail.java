
import java.awt.*;
import java.awt.event.*; 
import java.io.File;
import java.net.URI;
import java.util.*;
import javax.swing.*;


public class lecture_detail extends javax.swing.JFrame 
{
    int lecture_id;

    public lecture_detail(int id) 
    {
        
        initComponents();
        setSize(500,400);
        lecture_id = id;
        details();
    }
    
    void details()
    {
        String ans = myClient.fetchdetails(lecture_id);
        
        StringTokenizer st = new StringTokenizer(ans,"$");
        
        int id = Integer.parseInt(st.nextToken());
        String name1  = st.nextToken();
        String description1 = st.nextToken();
        String duration = st.nextToken();
        String photo = st.nextToken();
        int course_id = Integer.parseInt(st.nextToken());
        String trailer1 = st.nextToken();
        String video1 = st.nextToken();
        
        ImageIcon ic = new ImageIcon(photo);
        Image img =ic.getImage().getScaledInstance(poster.getWidth(),poster.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        poster.setIcon(ic1);
        name.setText(name1);
        description.setText(description1);
        
        play_trailer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                URI uri = new URI("https://www.youtube.com/watch?v="+trailer1);
                
                Desktop d = Desktop.getDesktop();
                d.browse(uri);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
                    
        });
        
        play_lecture.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                File f = new File(video1);
                Desktop d = Desktop.getDesktop();
                d.open(f);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poster = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        play_trailer = new javax.swing.JButton();
        play_lecture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        poster.setText("poster");
        getContentPane().add(poster);
        poster.setBounds(0, 0, 250, 400);

        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 40, 150, 16);
        getContentPane().add(name);
        name.setBounds(310, 70, 150, 22);

        jLabel2.setText("Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 110, 150, 16);

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 140, 150, 100);

        play_trailer.setText("PLAY TRAILER");
        getContentPane().add(play_trailer);
        play_trailer.setBounds(310, 290, 160, 23);

        play_lecture.setText("PLAY LECTURE");
        getContentPane().add(play_lecture);
        play_lecture.setBounds(310, 330, 160, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[])
    {
   
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new lecture_detail(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton play_lecture;
    private javax.swing.JButton play_trailer;
    private javax.swing.JLabel poster;
    // End of variables declaration//GEN-END:variables
}
