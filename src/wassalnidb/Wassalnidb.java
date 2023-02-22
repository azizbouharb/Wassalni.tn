package wassalnidb;
import entities.Livraison;
import entities.Payement;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.LivraisonService;
import services.PayementService;
import utils.MyConnection;




/**
 *
 * @author farah
 */
public class Wassalnidb  extends Application {
    public void start(Stage primaryStage) throws Exception  
          
    {
        
        
        Parent parentPage = FXMLLoader.load(getClass().getResource("../interfaces/gui/livraison.fxml"));
      //  Parent parentPage = FXMLLoader.load(getClass().getResource("../interfaces/gui/Payement.fxml"));
        Scene scene = new Scene(parentPage);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
public static void main (String []args){
        MyConnection.getInstance();
       launch(args);
        //livraison l = new livraison(2,3,"mohamed","gejo","fef","fgd",665.59,"rfrgggggg");
        //Livraison l2 = new Livraison(366,65631,"bardo","tounes","hjvjjh",65.22,"kjkk","en cours");
        //Livraison l3 = new Livraison(6,9,"menzah","mlmpk","vguhv",596.0,"02/05/2020","livré");
        //Livraison l4 = new Livraison(1,2,"bringa","kklkm","foufa",4.00,"10/05/2009","en pause");
       // Livraison l5 = new Livraison(10,20,"hkaz","ggue","kouka","hjhe",5889.00,"31/05/2010");
       // Livraison l6 = new Livraison(545,545,"hihihiz","ggue646","kokuka","fgfggr",5889.00,"31/05/2010");
        //Livraison l7 = new Livraison(840,545,"hihihfbgiz","ggue646","kokuka","fgfggr",77589.00,"31/05/2010");
        //Livraison l8 = new Livraison(7868685,545,"hihihfbgiz","ggue646","tttgtgh","fgfggr",77589.00,"31/05/2010");
        //Livraison l10 = new Livraison(99868883,545,"hihihfbgiz","ggue646","kokuka","fgfggr",77589.00,"31/05/2010");
        //System.out.println(l);
        //LivraisonService livraison = new LivraisonService();
        //System.out.println( livraison.ajouterLivraison(l2));
       // System.out.println( livraison.ajouterLivraison(l3));
       // System.out.println( livraison.ajouterLivraison(l4));
        
        //livraison.supprimerLivraison(l2);
        //System.out.println(l);
        //l3.setPrix(5555.2);
        //System.out.println( livraison.modifierLivraison(l3));
        
        
        //l3.setRef(3);
        //l3.setCin_client(55555);
       // System.out.println( livraison.afficher());
        
        //AFFICHAGE
        
       //Payement p1 = new Payement("farah",487,"8ruebardo",65461,"mastercard");
       //PayementService payement = new PayementService();
       //System.out.println(payement.ajouterLivraison(p1));
         //System.out.println(payement.afficher());
       
       
       
       
}
    }
    
//}


