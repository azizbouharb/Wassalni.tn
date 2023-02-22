import PIClass.User;
import java.sql.*;
import PIServices.ServiceUser;
import java.util.Iterator;
public class Main {
 
  
    public static void main (String []args){
        User p = new User ( "bourawi", 8, "hssan.bourawi@esprit.tn",  "hssa1478");
                User p1 = new User ( "bourawi", 8, "hssan.bourawi@esprit.tn",  "hssa1478");
                User p2 = new User ( "jjjjj", 8, "hssan.bourawi@esprit.tn",  "hssa1478");
                
        
               // User p1 = new User ( );
                // User p2 = new User ( );

        ServiceUser Service = new ServiceUser();
        //System.out.println( Service.ajouter(p));
        // System.out.println( Service.ajouter(p1));
        Service.login("kjhf@gma.com", "547");
         //System.out.println( Service.ajouter (p2));
          //System.out.println( Service.ajouter(p1));
          // System.out.println( Service.ajouter(p1));
        // System.out.println( Service.ajouter(p1));
         // System.out.println( Service.ajouter(p2));
         
       // Service.supprimer(p);
        Service.modifier(p1);
        //Service.afficher();
 
        
}
    
}
