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
public class Livraison {
    private int id_livraison;
    private int cin_client;
    private int cin_livreur;
    private String depart_liv;
    private String dest_liv;
    private String image_pr;
    private Double prix;
    private String date_liv;
    private String etat_liv;
    private int ref;

    public Livraison() {
    }

    public Livraison(int id_livraison, int cin_client, int cin_livreur, String depart_liv, String dest_liv, String image_pr, Double prix, String date_liv, String etat_liv, int ref) {
        this.id_livraison = id_livraison;
        this.cin_client = cin_client;
        this.cin_livreur = cin_livreur;
        this.depart_liv = depart_liv;
        this.dest_liv = dest_liv;
        this.image_pr = image_pr;
        this.prix = prix;
        this.date_liv = date_liv;
        this.etat_liv = etat_liv;
        this.ref = ref;
    }

    public Livraison(int cin_client,   String image_pr,String depart_liv, String dest_liv, String date_liv,Double prix) {
        this.cin_client = cin_client;
        this.depart_liv = depart_liv;
        this.dest_liv = dest_liv;
        this.image_pr = image_pr;
        this.date_liv = date_liv;
        this.prix=prix;
    }

    public Livraison(int cin_client, int cin_livreur, String depart_liv, String dest_liv, String image_pr, Double prix, String date_liv, String etat_liv, int ref) {
        this.cin_client = cin_client;
        this.cin_livreur = cin_livreur;
        this.depart_liv = depart_liv;
        this.dest_liv = dest_liv;
        this.image_pr = image_pr;
        this.prix = prix;
        this.date_liv = date_liv;
        this.etat_liv = etat_liv;
        this.ref = ref;
    }

    public Livraison(int cin_client, int cin_livreur, String depart_liv, String dest_liv, String image_pr, Double prix, String date_liv, String etat_liv) {
        this.cin_client = cin_client;
        this.cin_livreur = cin_livreur;
        this.depart_liv = depart_liv;
        this.dest_liv = dest_liv;
        this.image_pr = image_pr;
        this.prix = prix;
        this.date_liv = date_liv;
        this.etat_liv = etat_liv;
    }

    public Livraison(int cin_client, String depart_liv, String dest_liv, String image_pr, Double prix, String date_liv) {
        this.cin_client = cin_client;
        this.depart_liv = depart_liv;
        this.dest_liv = dest_liv;
        this.image_pr = image_pr;
        this.prix = prix;
        this.date_liv = date_liv;
    }

    

    

    public int getId_livraison() {
        return id_livraison;
    }

    public int getCin_client() {
        return cin_client;
    }

    public int getCin_livreur() {
        return cin_livreur;
    }

    public String getDepart_liv() {
        return depart_liv;
    }

    public String getDest_liv() {
        return dest_liv;
    }

    public String getImage_pr() {
        return image_pr;
    }

    public Double getPrix() {
        return prix;
    }

    public String getDate_liv() {
        return date_liv;
    }

    public String getEtat_liv() {
        return etat_liv;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
    
    

    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }

    public void setCin_livreur(int cin_livreur) {
        this.cin_livreur = cin_livreur;
    }

    public void setDepart_liv(String depart_liv) {
        this.depart_liv = depart_liv;
    }

    public void setDest_liv(String dest_liv) {
        this.dest_liv = dest_liv;
    }

    public void setImage_pr(String image_pr) {
        this.image_pr = image_pr;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void setDate_liv(String date_liv) {
        this.date_liv = date_liv;
    }

    public void setEtat_liv(String etat_liv) {
        this.etat_liv = etat_liv;
    }

   
    

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", cin_client=" + cin_client + ", cin_livreur=" + cin_livreur + ", depart_liv=" + depart_liv + ", dest_liv=" + dest_liv + ", image_pr=" + image_pr + ", prix=" + prix + ", date_liv=" + date_liv + ", etat_liv=" + etat_liv + '}';
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
        final Livraison other = (Livraison) obj;
        if (this.id_livraison != other.id_livraison) {
            return false;
        }
        if (!Objects.equals(this.cin_client, other.cin_client)) {
            return false;
        }
        if (!Objects.equals(this.cin_livreur, other.cin_livreur)) {
            return false;
        }
        if (!Objects.equals(this.depart_liv, other.depart_liv)) {
            return false;
        }
        if (!Objects.equals(this.dest_liv, other.dest_liv)) {
            return false;
        }
        if (!Objects.equals(this.image_pr, other.image_pr)) {
            return false;
        }
        if (!Objects.equals(this.date_liv, other.date_liv)) {
            return false;
        }
        if (!Objects.equals(this.etat_liv, other.etat_liv)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
         if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        return true;
    }

   
   
    
}
