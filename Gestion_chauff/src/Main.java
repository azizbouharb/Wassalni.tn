import PIClass.Chauffeur;
import java.sql.*;
import PIServices.ServiceChauffeur;
import java.util.Iterator;
public class Main {
 
  
    public static void main (String []args){
        Chauffeur p = new Chauffeur(0, "", 0, "", 0, "","");
           
        ServiceChauffeur Service = new ServiceChauffeur();
        System.out.println( Service.ajouter(p));
    
        Service.supprimer(p);
        Service.modifier(p);
        Service.afficher();
 
        
}
    
}
