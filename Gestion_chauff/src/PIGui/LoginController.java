/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;
import PIClass.Chauffeur;
import PIClass.Voiture;
import PIUtils.Mail_Chauff;
import PIServices.ServiceChauffeur;
import PIServices.ServiceVoiture;
import PIServices.Session;
import animatefx.animation.ZoomIn;
import com.stripe.Stripe;
import static com.stripe.Stripe.apiKey;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.log;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.File;
import net.sourceforge.tess4j.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
//import projet.utils.JavaMailUtilUser;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

     @FXML
    private Button upload_file;
    @FXML
    private TextField tfnom;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField emailm;
    @FXML
    private TextField tfpath;
    @FXML
    private TextField tfpermis;
     @FXML
    private TextField tfvoiture;
    @FXML
    private Button btnnext;
    @FXML
    private Button btnCancel;
    private String code ;
      @FXML
    private TextField tf_mat;
    @FXML
    private TextField tfgrise;
    @FXML
    private TextField tfvoi;
    @FXML
    private Label nom;
    
     @FXML
    private Button upload1;
     @FXML
    private Button upload2;
    
     @FXML
    private TextField tf_mail;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btncancel;
    @FXML
    private PasswordField tf_pass;
    
    
    @FXML
    private Button login;
    @FXML
   
 
    
    private Button sign_up_l;
    @FXML
    private Button sign_in_l;
    @FXML
    private Button sign_up_s;
    @FXML
    private Button sign_in_s;
  
    @FXML
    private Pane pane_signup;
    @FXML
    private Pane pane_signin;
    @FXML
    private Button closeb;
   
    @FXML
    private Button importer;
    @FXML
    private Button inscprition;
   
    @FXML
    private Pane pane_voiture;

    @FXML
    private Button motdepasse;
    @FXML
    private Pane pane_password;
    @FXML
    private PasswordField password_nc;
    @FXML
    private PasswordField password_n;
    @FXML
    private Button modifier;
    @FXML
    private Button back_p;
    @FXML
    private Pane pane_email;
    @FXML
    private Button envoyerm;
    @FXML
    private Button back_a;
    @FXML
    private Button envoyer_c;
    @FXML
    private Button back_c;
    @FXML
    private Label pasword_ne;
    @FXML
    private Label pasword_nec;
    private String email ;

    /**
     * Initializes the controller class.
     */
 
    
       Voiture u = new Voiture();
    public void setVoiture(Voiture u) {
		this.u = u;
	}
	
	public void refresh() {
		tf_mat.setText(u.getMatricule());

	}
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

     @FXML
    private void loginN(ActionEvent event) throws IOException
    {
        ServiceChauffeur sU = ServiceChauffeur.getInstance();
		Chauffeur u = sU.login(tf_mail.getText(), tf_pass.getText());
		if (u.getId_client()> -1) {                                                 
                    
            JOptionPane.showMessageDialog(null,"Bienvenue ");
			FXMLLoader loader1= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));              
			Parent root1= loader1.load();
			tf_mail.getScene().setRoot(root1);

           Profil_chaufController controller = (Profil_chaufController) loader1.getController();
            controller.setChauf(u);
            controller.setLbMat(u.getId_voiture());
			controller.refresh();
		}
		else {
			
            JOptionPane.showMessageDialog(null,"Mot de passe ou login incorrect ");
             
		}
    }
    
    @FXML
    private void InscriptionUtilisateur(ActionEvent event) throws TesseractException {
            
        String ocr_path = tfpath.getText().trim();
        ocr_path = ocr_path.substring(0, ocr_path.length() - 4);
        String test ="permis";
         File imageFile =new File(ocr_path+".png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("D:\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
       
            String result = instance.doOCR(imageFile);
            System.out.println(result);
            if(!(result.toLowerCase().contains(test))){
                 Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Entrer une image de permis valide ! ");
            al.showAndWait();
            }
       
        
        
            else  if ( tfnom.getText().isEmpty() | tfpassword.getText().isEmpty() | tfemail.getText().isEmpty() | tfpermis.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez remplir les champs vides ! ");
            al.showAndWait();
        }
        
        else if (!tfemail.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
       
        else if (!tfemail.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez une adresse mail valide ! ");
            a2.showAndWait();
        }
        
        else if (!tfpermis.getText().matches("\\d*"))
        {
            Alert a2 = new Alert(Alert.AlertType.ERROR);
            a2.setHeaderText(null);
            a2.setContentText("Veuillez entrer que des chiffre en tant que permis ! ");
            a2.showAndWait();
        }
        else if (tfnom.getText().equals(tfpassword.getText()))
        {
            Alert a3 = new Alert(Alert.AlertType.ERROR);
            a3.setHeaderText(null);
            a3.setContentText("Veuillez ne pas mettre votre nom en tant que mot de passe ! ");
            a3.showAndWait();
        }
                  else
        { 
            int permis = Integer.valueOf(tfpermis.getText());
            ServiceChauffeur sc= new ServiceChauffeur();
            sc.ajouter(new Chauffeur(permis,tfpath.getText(), tfvoiture.getText(), tfnom.getText(), tfemail.getText(),tfpassword.getText() )) ;
                 
            
                           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Inscription");
                    alert.setContentText("Succee");
                    alert.showAndWait();
                     new ZoomIn(pane_voiture).play();
        pane_voiture.toFront();
                    this.setNom(tfnom.getText());
                    this.setTfmat(tfvoiture.getText());
             
                 }
                 
                 
    }
    
    
     @FXML
       private String FileChooser(ActionEvent event) throws IOException 
    {
         String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfpath.setText(path);
        return path;
        
        
        
    }

    @FXML
    private void To_signin(ActionEvent event) {
        new ZoomIn(pane_signin).play();
        pane_signin.toFront();
        
    }
    @FXML
 private void importer(ActionEvent event) {
       
    }

    @FXML
    private void To_signup(ActionEvent event) {
         new ZoomIn(pane_signup).play();
        pane_signup.toFront();
    }

    @FXML
    private void Close(ActionEvent event) {
        Stage window = (Stage) closeb.getScene().getWindow();
        window.close();
    }

    @FXML
    private void To_mot_de_passe(ActionEvent event) {
        new ZoomIn(pane_email).play();
        pane_email.toFront();
    }

    @FXML
    private void ModifierPassword(ActionEvent event) {
         

    }

    @FXML
    private void BackP(ActionEvent event) {
           new ZoomIn(pane_signin).play();
        pane_signin.toFront();
    }
public static String getRandomNumberString() {
 
    Random rnd = new Random();
    int number = rnd.nextInt(999999);

    return String.format("%06d", number);
}
    @FXML
    private void EnvoyerMail(ActionEvent event) {
                          Mail_Chauff mail = new Mail_Chauff();
                          ServiceChauffeur ps = new ServiceChauffeur();
                          
    code =  getRandomNumberString();
    
         String content = "Recuperer le mot de passe\n" +
"une requete du recupération de mot passe à eté envoyer \n" +
"ceci est Votre mot de passe : "+ code;
        try {
            mail.sendMail("Recuperation du mot de passe",content,emailm.getText());
            ps.modifier_Pass(emailm.getText(), code);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                     new ZoomIn(pane_signin).play();
        pane_signin.toFront();
    }

    @FXML
    private void BackA(ActionEvent event) {
           new ZoomIn(pane_signin).play();
        pane_signin.toFront();
    }

    @FXML
    private void EnvoyerCode(ActionEvent event) {
      /*  if (codem.getText().equals(code)){
            new ZoomIn(pane_password).play();
        pane_password.toFront();
        }else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("login");
                    alert.setContentText("Le code est incorrect !");
                    alert.showAndWait();
        }*/
    }

    @FXML
    private void BackC(ActionEvent event) {
           new ZoomIn(pane_signin).play();
        pane_signin.toFront();
    }
    
    
    
       public void setTfmat(String username) {
        this.tf_mat.setText(username);
    }
      public void setNom(String username) {
        this.nom.setText(username);
    }
    
      @FXML
    private void ajouter_Voiture(ActionEvent event) throws IOException, TesseractException 
    {      
      
         String test ="gris";
         File imageFileC =new File(tfgrise.getText());
        ITesseract instance = new Tesseract();
        instance.setDatapath("D:\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
       
            String result = instance.doOCR(imageFileC);
            System.out.println(result);
            if(!(result.toLowerCase().contains(test))){
                 Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Entrer une image de Carte Grise valide ! ");
            al.showAndWait();
            }
            
        
            else if ( tfvoi.getText().isEmpty() | tfgrise.getText().isEmpty() )
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText(null);
            al.setContentText("Veuillez joindre tous les fichiers ! ");
            al.showAndWait();
        }
       
        
        else
        { 
           
            ServiceVoiture sc= new ServiceVoiture();
            sc.ajouter(new Voiture(tf_mat.getText(), tfvoi.getText(), tfgrise.getText())) ;

            JOptionPane.showMessageDialog(null,"Voiture bien enregistrer dans la base ");

            FXMLLoader loader= new FXMLLoader(getClass().getResource("Profil_chauf.fxml"));
            Parent root= loader.load();
            tf_mat.getScene().setRoot(root);
            Profil_chaufController pc= loader.getController();
         
            pc.setLbMat(tf_mat.getText());
            pc.setLbUsername(nom.getText());
          
        }
    }
    
    
     @FXML
       private String FileChooser1(ActionEvent event) throws IOException 
    {
         String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfgrise.setText(path);
      
        return path;
        
        
        
    }
       
     @FXML
       private String FileChooser2(ActionEvent event) throws IOException 
    {
        
        
        String path;
        FileChooser fileChooser = new FileChooser();
     
        File selectedFile = fileChooser.showOpenDialog(null);
       
      path =  selectedFile.toString();
      tfvoi.setText(path);
      
        return path;
        
        
        
    }
       
       
   
    
}