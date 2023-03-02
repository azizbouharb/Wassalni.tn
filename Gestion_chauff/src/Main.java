import PIClass.Chauffeur;
import java.sql.*;
import PIServices.ServiceChauffeur;
import java.util.Iterator;
public class Main {
 
  
    public static void main (String []args){
        Chauffeur p = new Chauffeur(22, "ddddd", "3", "emna3", "emnaaa", "13335");
           
        ServiceChauffeur Service = new ServiceChauffeur();
        System.out.println( Service.ajouter(p));
       // Service.login("aziz@aziz.tn", "aziz1");
    //  Service.supprimer(p);
        Service.modifier(p);
       // Service.afficher();
 
        
}
    
}
