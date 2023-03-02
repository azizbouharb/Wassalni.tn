/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.Chauffeur;
import PIClass.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Comparator;
import PIUtils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ServiceChauffeur implements Iservice<Chauffeur>{
    Connection cn = MyConnection.getTest().getCnx();
    private static ServiceChauffeur instance;

    @Override
    public int ajouter(Chauffeur t) {
     
         int id=1;
         try {
         
            System.out.println(t);
            String req = "INSERT INTO Chauffeurs VALUES  (null,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setString(1, t.getNom_client());
            pst.setString(2, t.getImage_permis());
            pst.setString(3, t.getId_voiture());

            pst.setString(4, t.getEmail_client());
            pst.setString(5, t.getPass_client());
            pst.setInt(6, t.getPermis_chauf());

            pst.executeUpdate();
            System.out.println("Chauffeur ajouté !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
      return id;
    }

    @Override
    public void supprimer(Chauffeur t) {
         try {
            String req = "DELETE FROM Chauffeurs WHERE id_client=?";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setInt(1, t.getId_client());
            pst.executeUpdate();
            System.out.println("Chauffeur supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifier(Chauffeur t) {
  try {
            String req = "UPDATE chauffeurs SET nom_client=?,image_permis=?,id_voiture=?,email_client=?,pass_client=?,permis_chauf=?  WHERE id_client=?";
            PreparedStatement pst = cn.prepareStatement(req);
          pst.setString(1, t.getNom_client());
            pst.setString(2, t.getImage_permis());
            pst.setString(3, t.getId_voiture());

            pst.setString(4, t.getEmail_client());
            pst.setString(5, t.getPass_client());
            pst.setInt(6, t.getPermis_chauf());
            pst.setInt(7, t.getId_client());
            pst.executeUpdate();
            System.out.println("Chauffeur_id " + t.getId_client()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
   
    public List<Chauffeur> afficher() 
    {
        List<Chauffeur> list = new ArrayList<>();
        
        String requete = "SELECT permis_chauf,nom_client,email_client,image_permis,pass_client,matricule_voiture FROM chauffeurs";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new Chauffeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5), rs.getString(6))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }    

    @Override
    public List<Chauffeur> userListe() {
         List<Chauffeur> list = new ArrayList<>();
        
        String requete = "SELECT * FROM chauffeurs";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                Chauffeur c =new Chauffeur();
                c.setId_client(rs.getInt("id_client"));
                c.setNom_client(rs.getString("nom_client"));
               c.setImage_permis(rs.getString("image_permis"));
                c.setId_voiture(rs.getString("id_voiture"));
                c.setEmail_client(rs.getString("email_client"));
                c.setPass_client(rs.getString("pass_client"));
                c.setPermis_chauf(rs.getInt("permis_chauf"));
                list.add(c);
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
     public static Comparator<Chauffeur> clientComparator = new Comparator<Chauffeur>() {
        @Override
        public int compare(Chauffeur c1, Chauffeur c2) {
            return c1.getNom_client().compareTo(c2.getNom_client());
        }
    };

    @Override
    public List<Chauffeur> TrieParUsername() {
         List<Chauffeur> list = this.userListe();
         Chauffeur c = new Chauffeur();
        Collections.sort(list, clientComparator);
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Chauffeur> recherche(String Xusername) {
      ArrayList<Chauffeur> ListChauffeurUsername = new ArrayList<>();
        try {
            String req = "Select * from chauffeurs where nom_client=?";
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(req);
            pst.setString(1, Xusername);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                Chauffeur c = new Chauffeur();
               c.setId_client(rs.getInt("id_client"));
                c.setNom_client(rs.getString("nom_client"));
               c.setImage_permis(rs.getString("image_permis"));
                c.setId_voiture(rs.getString("id_voiture"));
                c.setEmail_client(rs.getString("email_client"));
                c.setPass_client(rs.getString("pass_client"));
                c.setPermis_chauf(rs.getInt("permis_chauf"));
                if (c.getNom_client().equals(Xusername))
                {
                    ListChauffeurUsername.add(c);
                } 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (ListChauffeurUsername.isEmpty()) {
            System.out.println("Cet utilisateur n'éxiste pas.");
        }
        return ListChauffeurUsername;
    }
    
    
     public List<Chauffeur> getChauffeurById(){
        
        List<Chauffeur> list = new ArrayList<Chauffeur>();
        int count =0;
        
        String requete="select * from chauffeurs";
         try{
            Statement st =cn.createStatement();
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
               Chauffeur c = new Chauffeur();
               c.setId_client(rs.getInt("id_client"));
                c.setNom_client(rs.getString("nom_client"));
               c.setImage_permis(rs.getString("image_permis"));
                c.setId_voiture(rs.getString("matricule_voiture"));
                c.setEmail_client(rs.getString("email_client"));
                c.setPass_client(rs.getString("pass_client"));
                c.setPermis_chauf(rs.getInt("permis_chauf"));

                list.add(c);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
               return list;
            
           
        }
         }
        catch (SQLException ex) {
           System.out.println(ex.getMessage());
            return null;
        }
     }
    
     
      public Chauffeur login(String inputEmail, String inputPassword) {
		Chauffeur account = new Chauffeur();
		account.setId_client(-1);

		String hashedPassword = "";
		
        try {
            String requete = "SELECT pass_client FROM chauffeurs where email_client=?";
            PreparedStatement pst = cn.prepareStatement(requete);
			pst.setString(1, inputEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
				hashedPassword = rs.getString("pass_client");
            }
			
			if((inputPassword.equals(hashedPassword))) {
				System.out.println("It matches");
				requete = "SELECT * FROM chauffeurs where email_client=?";
				pst = cn.prepareStatement(requete);
				pst.setString(1, inputEmail);
				rs = pst.executeQuery();
				while (rs.next()) {
					account.setId_client(rs.getInt("id_client"));
                account.setNom_client(rs.getString("nom_client"));
               account.setImage_permis(rs.getString("image_permis"));
                account.setId_voiture(rs.getString("matricule_voiture"));
                account.setEmail_client(rs.getString("email_client"));
                account.setPass_client(rs.getString("pass_client"));
                account.setPermis_chauf(rs.getInt("permis_chauf"));
					System.out.println("  test "+account);
				}
			}
			else {
				System.out.println(" test2 "+account.getId_client());
			}

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
	
		
		return account;
	}
      
      
      public boolean isUserAdmin( String inputEmail) {
          
          		User account = new User();
                                    String email;
                                    int role_u = 1;

                        try {
            String requete = "SELECT email_client,role_client FROM users where email_client=?";
            PreparedStatement pst = cn.prepareStatement(requete);
			pst.setString(1, inputEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
				email = rs.getString("email_client");
                                role_u  =rs.getInt("role_client");
            }
			
			

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    int ADMIN_ROLE = 0;
    return ADMIN_ROLE == role_u;
}
      
            public String Getpass( String inputEmail) {
          
          		Chauffeur account = new Chauffeur();
                                    String email;
                                    String pass = null;
                                  
try {
            String requete = "SELECT pass_client FROM chauffeurs where email_client=?";
            PreparedStatement pst = cn.prepareStatement(requete);
			pst.setString(1, inputEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
				pass = rs.getString("pass_client");
                                System.out.println(pass);
            }
			

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    
    return pass;
}
     
     public static ServiceChauffeur getInstance(){
            if(instance==null) 
                instance=new ServiceChauffeur();
            return instance;
        }
    
     
     
     
     public void modifier_Pass(String email,String pass) {
  try {
            String req = "UPDATE chauffeurs SET pass_client=?  WHERE email_client=?";
            PreparedStatement pst = cn.prepareStatement(req);
          pst.setString(1, pass);
            pst.setString(2, email);
           
            pst.executeUpdate();
            System.out.println("Mot de Passe modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
