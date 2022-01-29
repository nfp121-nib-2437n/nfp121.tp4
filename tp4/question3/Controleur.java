package question3;


import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(new ActionPile());
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new ActionPile());
        boutons.add(add);   add.addActionListener(new ActionPile());
        boutons.add(sub);   sub.addActionListener(new ActionPile());
        boutons.add(mul);   mul.addActionListener(new ActionPile());
        boutons.add(div);   div.addActionListener(new ActionPile());
        boutons.add(clear); clear.addActionListener(new ActionPile());
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        // à compléter
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }
    
    public class ActionPile implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==push){
                try{
                pile.empiler(operande());
                }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "invalid number", "Error",
                JOptionPane.ERROR_MESSAGE);
                } 
                catch(PilePleineException ex){
                JOptionPane.showMessageDialog(null, "PilePleine", "Error",
        JOptionPane.ERROR_MESSAGE);                   
                }
                donnee.setText("");
                
            }
            else if(e.getSource()==add){
                     try{
                pile.empiler(pile.depiler() + pile.depiler());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "invalid number", "Error",
        JOptionPane.ERROR_MESSAGE);    
                } 
                
                catch(PilePleineException ex){
                    JOptionPane.showMessageDialog(null, "PilePleine", "Error",
        JOptionPane.ERROR_MESSAGE);                   
                }
                catch(PileVideException ex){
                    JOptionPane.showMessageDialog(null, "PileVide", "Error",
        JOptionPane.ERROR_MESSAGE);
                }
                donnee.setText("");
            }
            else if(e.getSource()==sub){
                    try{
                pile.empiler(pile.depiler() - pile.depiler());
                }catch(PileVideException ex){
                    JOptionPane.showMessageDialog(null, "PileVide", "Error",
        JOptionPane.ERROR_MESSAGE);
                }
                 catch(PilePleineException ex){
                    JOptionPane.showMessageDialog(null, "PilePleine", "Error",
        JOptionPane.ERROR_MESSAGE);                   
                }
                
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "invalid number", "Error",
        JOptionPane.ERROR_MESSAGE);    
                } 
                donnee.setText("");
            }
            else if(e.getSource()==mul){
                    try{
                pile.empiler(pile.depiler() * pile.depiler());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "invalid number", "Error",
        JOptionPane.ERROR_MESSAGE);    
                } 
                catch(PilePleineException ex){
                    JOptionPane.showMessageDialog(null, "PilePleine", "Error",
        JOptionPane.ERROR_MESSAGE);                   
                }
                catch(PileVideException ex){
                    JOptionPane.showMessageDialog(null, "PileVide" , "Error",
        JOptionPane.ERROR_MESSAGE);
                }
                donnee.setText("");
            }
            else if(e.getSource()==div){
                    try{
                        int op1=pile.depiler();
                        int op2=pile.depiler(); 
                        pile.empiler(op1 / op2); 
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "invalid number", "Error",
        JOptionPane.ERROR_MESSAGE);    
                }  
                catch(ArithmeticException ex){
                    JOptionPane.showMessageDialog(null,"Error : Division by 0", "Error",
        JOptionPane.ERROR_MESSAGE);                   
                }
                catch(PilePleineException ex){
                    JOptionPane.showMessageDialog(null, "PilePleine", "Error",
        JOptionPane.ERROR_MESSAGE);
                }
                catch(PileVideException ex){
                    JOptionPane.showMessageDialog(null, "PileVide", "Error",
        JOptionPane.ERROR_MESSAGE);
                }
                donnee.setText("");
            }
            else if(e.getSource()==clear){
                donnee.setText("");
            }
        }
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)

}
