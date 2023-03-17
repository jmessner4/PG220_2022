import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

public class Logiciel {
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("ERP POO'lettes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);
        
        JLabel label = new JLabel("Bienvenue dans l'ERP de POO'Lettes Corp.", JLabel.CENTER);
        frame.add(label);
        
        JPanel panel = new JPanel();
        
        JButton btn1 = new JButton("Factures");
        btn1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            //afficher le jdialog lorsque le bouton est cliqué
            JFrame frame2= new JFrame("Factures");
            frame2.setLocationRelativeTo(frame);
            frame2.setVisible(true);
            JButton btn11 = new JButton("Créer");
            btn11.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
            	    JTextField text2 = new JTextField("Date émission");
            	    text2.setBounds(20,80,200,28);
            	    frame.add(text2);
              }
            });
            frame2.add(btn11);
          }
        });
        
        JButton btn2 = new JButton("Comptabilité");
        btn2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            //afficher le jdialog lorsque le bouton est cliqué
            JDialog dialog = new JDialog(frame, "Comptabilité", true);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
          }
        });
        
        JButton btn3 = new JButton("Gestion RH");
        btn3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            //afficher le jdialog lorsque le bouton est cliqué
            JDialog dialog = new JDialog(frame, "Gestion RH", true);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
          }
        });
        
        JButton btn4 = new JButton("Suivi de Projet");
        btn4.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            //afficher le jdialog lorsque le bouton est cliqué
            JDialog dialog = new JDialog(frame, "Suivi de Projet", true);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
          }
        });
        
        JButton btn5 = new JButton("Prospection");
        btn5.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            //afficher le jdialog lorsque le bouton est cliqué
            JDialog dialog = new JDialog(frame, "Prospection", true);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
          }
        });
         
        frame.setLayout(new GridLayout(5, 1));
    
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);

         
        // Ajouter label et panel au frame
        frame.add(label);
        frame.add(panel);
    }
}
