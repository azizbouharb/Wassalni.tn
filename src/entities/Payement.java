/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.time.Instant;
import java.util.Objects;

/**
 *
 * @author farah
 */
public class Payement {
    private int id_payement;
    private String nom_client;
    private int cin_cl;
    private String adresse;
    private int tel;
    private String type_carte;
    
    
  public Payement(){
      
  }

    public Payement(int id_payement, String nom_client, int cin_cl, String adresse, int tel, String type_carte) {
        this.id_payement = id_payement;
        this.nom_client = nom_client;
        this.cin_cl = cin_cl;
        this.adresse = adresse;
        this.tel = tel;
        this.type_carte = type_carte;
    }

    public Payement(String nom_client, int cin_cl, String adresse, int tel, String type_carte) {
        this.nom_client = nom_client;
        this.cin_cl = cin_cl;
        this.adresse = adresse;
        this.tel = tel;
        this.type_carte = type_carte;
    }
    

    public int getId_payement() {
        return id_payement;
    }

    public String getNom_client() {
        return nom_client;
    }

    public int getCin_cl() {
        return cin_cl;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public String getType_carte() {
        return type_carte;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setCin_cl(int cin_cl) {
        this.cin_cl = cin_cl;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setType_carte(String type_carte) {
        this.type_carte = type_carte;
    }

    @Override
    public String toString() {
        return "Payement{" + "id_payement=" + id_payement + ", nom_client=" + nom_client + ", cin_cl=" + cin_cl + ", adresse=" + adresse + ", tel=" + tel + ", type_carte=" + type_carte + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Payement other = (Payement) obj;
        if (this.id_payement != other.id_payement) {
            return false;
        }
        if (this.cin_cl != other.cin_cl) {
            return false;
        }
        if (this.tel != other.tel) {
            return false;
        }
        if (!Objects.equals(this.nom_client, other.nom_client)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.type_carte, other.type_carte)) {
            return false;
        }
        return true;
    }
  
    
}

