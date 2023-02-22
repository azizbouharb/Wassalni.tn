/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;
import PIClass.User;
import PIUtils.MyConnection;
import at.favre.lib.crypto.bcrypt.BCrypt;

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
 * @author user
 */
public class ServiceUser implements Iservice<User> {
     Connection cn = MyConnection.getTest().getCnx();
     private static ServiceUser instance;
  @Override
   public int ajouter(User u) {
     
         int id=1;
         try {
         
            System.out.println(u);
            String req = "INSERT INTO Users VALUES  (null,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setString(1, u.getNom_client());
           
            pst.setInt(2, u.getCin_client());

            pst.setString(3, u.getEmail_client()) ;
             
             pst.setString(4, u.getPass_client()) ;
             pst.setString(5, "1");
             

            pst.executeUpdate();
            System.out.println("user ajouté !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
    }
         return id;
}
 
   public void supprimer( User u) {
         try {
            String req = "DELETE FROM Users WHERE cin_Client=?";
            PreparedStatement pst = cn.prepareStatement(req);
            pst.setInt(1, u.getCin_client());
            pst.executeUpdate();
            System.out.println("user supprimé !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
   public void modifier(User u) {
  try {
            String req = "UPDATE users SET nom_client=?,cin_client=?,email_client=? ,pass_client=?,role_client=?   WHERE cin_client=?";
            PreparedStatement pst = cn.prepareStatement(req);
           pst.setString(1, u.getNom_client());
           
            pst.setInt(2, u.getCin_client());

            pst.setString(3, u.getEmail_client()) ;
            
             pst.setString(4, u.getPass_client()) ;
             pst.setInt(5, u.getRole_client()) ;
             pst.setInt(6, u.getCin_client());


            pst.executeUpdate();
            System.out.println("User_id " + u.getId_client()+":" + " modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   @Override
   public List<User> afficher() {
           List<User> list = new ArrayList<>();
      

        try {
            //String requete = "SELECT * FROM article";
            String requete="select * from users";
            Statement st = cn.createStatement();
          
            ResultSet rs = st.executeQuery(requete);
           
            while (rs.next()) {
               while (rs.next()) {
               User p = new User();
               p.setId_client(rs.getInt("id_client"));
               p.setNom_client(rs.getString("nom_client"));
               
               p.setCin_client(rs.getInt("cin_client"));
               p.setEmail_client(rs.getString("email_client"));
               
               p.setRole_client(rs.getInt("role_client"));
               p.setPass_client(rs.getString("pass_client"));
               System.out.println(p.getId_client());
               list.add(p);           
           }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;

   
  
    

}
   public User login(String inputEmail, String inputPassword) {
		User account = new User();
		account.setId_client(-1);

		String hashedPassword = "";
		
        try {
            String requete = "SELECT pass_client FROM users where email_client = ?";
            PreparedStatement pst = cn.prepareStatement(requete);
			pst.setString(1, inputEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
				hashedPassword = rs.getString("pass_client");
            }
			
			       if(inputEmail.equals(hashedPassword)){
				System.out.println("It matches");
                               }
				requete = "SELECT * FROM users where email_client=?";
				pst = cn.prepareStatement(requete);
				pst.setString(1, inputEmail);
				rs = pst.executeQuery();
				while (rs.next()) {
					account.setId_client(rs.getInt("id_client"));
                account.setNom_client(rs.getString("nom_client"));
               account.setCin_client(rs.getInt("Cin_client"));
                
                account.setEmail_client(rs.getString("email_client"));
                account.setPass_client(rs.getString("pass_client"));
                
					System.out.println("  test "+account);
				}
			

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
	
		
		return account;
	}
   public static ServiceUser getInstance(){
            if(instance==null) 
                instance=new ServiceUser();
            return instance;
        }


}