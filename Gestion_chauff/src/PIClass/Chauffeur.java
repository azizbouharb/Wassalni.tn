/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIClass;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.Comparator;

/**
 *
 * @author Aziz Bouharb
 */
public class Chauffeur extends User{

    private int permis_chauf;
    private String image_permis;
   
    private String id_voiture;

    public Chauffeur() {
    }

    public Chauffeur(int permis_chauf, String image_permis, String id_voiture, String nom_client, String email_client, String pass_client) {
        super(nom_client, email_client, pass_client);
        this.permis_chauf = permis_chauf;
        this.image_permis = image_permis;
        this.id_voiture = id_voiture;
    }

    public Chauffeur(int permis_chauf, String image_permis, String id_voiture, int id_client, String nom_client, String email_client, String pass_client) {
        super(id_client, nom_client, email_client, pass_client);
        this.permis_chauf = permis_chauf;
        this.image_permis = image_permis;
        this.id_voiture = id_voiture;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public int getPermis_chauf() {
        return permis_chauf;
    }

    public void setPermis_chauf(int permis_chauf) {
        this.permis_chauf = permis_chauf;
    }

    public String getImage_permis() {
        return image_permis;
    }

    public void setImage_permis(String image_permis) {
        this.image_permis = image_permis;
    }

    public String getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(String id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public int getCin_client() {
        return cin_client;
    }

    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getPass_client() {
        return pass_client;
    }

    public void setPass_client(String pass_client) {
        this.pass_client = pass_client;
    }

    public int getRole_client() {
        return role_client;
    }

    public void setRole_client(int role_client) {
        this.role_client = role_client;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chauffeur other = (Chauffeur) obj;
        if (this.permis_chauf != other.permis_chauf) {
            return false;
        }
        if (!Objects.equals(this.image_permis, other.image_permis)) {
            return false;
        }
        if (!Objects.equals(this.id_voiture, other.id_voiture)) {
            return false;
        }
        return true;
    }

    
    
      
    public int compare(Chauffeur o1, Chauffeur o2)
    {
        return o1.getNom_client().compareTo(o2.getNom_client());
    }

   
    
    
    
  
}
