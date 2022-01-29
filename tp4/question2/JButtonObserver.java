package question2;

import java.awt.event.*;
import java.awt.event.*;
import java.awt.TextArea;
import java.util.*;

/**
 * Décrivez votre classe JButtonObserver ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class JButtonObserver extends Observable{ 

    private String nom;
    private TextArea contenu;

    /**
     * Constructeur d'objets de classe JButtonObserver
     * 
     * @param nom
     *            le nom du bouton, jbo1, jbo2, jbo3, jmo1, jmo2, jmo3
     * @param contenu
     *            la zone de texte de l'applette
     */
    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }
    public String getNom(){
        return this.nom;
    }
     
    /**
     * affichage d'un message dans la zone de texte ce message est de la forme
     * observateur this.nom : clic du bouton nom_du_bouton exemple : observateur
     * jbo1 : clic du bouton A, voir la méthode getActionCommand()
     * 
     * @param à
     *            compléter
     */
     public class ClicAction implements ActionListener{
         String name=nom;
        public void actionPerformed(ActionEvent e) {
        String message = "";
        if(e.getActionCommand()=="A") message+="observateur "+name+" : clic du bouton A";
        
        else if(e.getActionCommand()=="B") message+="observateur "+name+" : clic du bouton B";
        else
        if(e.getActionCommand()=="C") message+="observateur "+name+" : clic du bouton C";
  
        contenu.append(message + "\n");
        
    }
    
}

  
}



