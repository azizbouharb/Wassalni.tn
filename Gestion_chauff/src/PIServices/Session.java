/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;
import PIClass.Chauffeur;
import PIClass.Voiture;

import java.util.HashMap;

/**
 *
 * @author Aziz Bouharb
 */

        public final class Session {

    private static Session instance;

    private Chauffeur utilisateur ;
   

    public Session(Chauffeur utilisateur) {
        this.utilisateur = utilisateur;
       
    }

    public Chauffeur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Chauffeur utilisateur) {
        this.utilisateur = utilisateur;
    }

   
    public static Session getInstace() {
        return instance;
    }
    public static void setInstace(Chauffeur utilisateur) {
            instance = new Session(utilisateur);
        
    }
    
  
}

