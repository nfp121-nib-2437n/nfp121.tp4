package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_2 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);
    private JMouseObserver observer1,observer2,observer3;
 
    public IHMQuestion2_2() {
        super("IHM Question2_2");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        setLocation(150,150);pack();show();
        enHaut.setBackground(Color.magenta);
        
        
        observer1 = new JMouseObserver("jbo1",contenu);
        observer2 = new JMouseObserver("jbo2",contenu);
        observer3 = new JMouseObserver("jbo3",contenu);
        ActionListener obs1=observer1.new ClicAction();
        ActionListener obs2=observer2.new ClicAction();
        ActionListener obs3=observer3.new ClicAction();
        
        
        MouseListener obs1Mouse=observer1.new MouseAction();
        MouseListener obs2Mouse=observer2.new MouseAction();
        MouseListener obs3Mouse=observer3.new MouseAction();
        // à compléter à l'identique de la question 2_1, (du copier/coller)...
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        boutonA.addActionListener(obs1);
        boutonA.addActionListener(obs2);
        boutonA.addActionListener(obs3);
        //le bouton B a 2 observateurs jbo1 et jbo2
        boutonB.addActionListener(obs1);
        boutonB.addActionListener(obs2);

        // le bouton C a 1 observateur jbo1
        boutonC.addActionListener(obs1);
            // le bouton A a 1 observateur jmo1
            boutonA.addMouseListener(obs1Mouse);
            // le bouton B a 1 observateur jmo2
            boutonB.addMouseListener(obs2Mouse);
            // le bouton C a 1 observateur jmo3
            boutonC.addMouseListener(obs3Mouse);
    }
    
     public static void main(String[] args){
        new IHMQuestion2_2();
    }


}
