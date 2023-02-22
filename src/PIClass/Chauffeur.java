/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIClass;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Aziz Bouharb
 */
public class Chauffeur {
     private int id_chauf;
    private int cin_chauf;
    private int permis_chauf;
    private String image_cin;
    private int id_voiture;

      public Chauffeur() {
    }

    public Chauffeur(int id_chauf, int cin_chauf, int permis_chauf, String image_cin, int id_voiture) {
        this.id_chauf = id_chauf;
        this.cin_chauf = cin_chauf;
        this.permis_chauf = permis_chauf;
        this.image_cin = image_cin;
        this.id_voiture = id_voiture;
    }

    public Chauffeur(int cin_chauf, int permis_chauf, String image_cin, int id_voiture) {
        this.cin_chauf = cin_chauf;
        this.permis_chauf = permis_chauf;
        this.image_cin = image_cin;
        this.id_voiture = id_voiture;
    }

    public int getId_chauf() {
        return id_chauf;
    }

    public void setId_chauf(int id_chauf) {
        this.id_chauf = id_chauf;
    }

    public int getCin_chauf() {
        return cin_chauf;
    }

    public void setCin_chauf(int cin_chauf) {
        this.cin_chauf = cin_chauf;
    }

    public int getPermis_chauf() {
        return permis_chauf;
    }

    public void setPermis_chauf(int permis_chauf) {
        this.permis_chauf = permis_chauf;
    }

    public String getImage_cin() {
        return image_cin;
    }

    public void setImage_cin(String image_cin) {
        this.image_cin = image_cin;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Chauffeur other = (Chauffeur) obj;
        if (this.id_chauf != other.id_chauf) {
            return false;
        }
        if (this.cin_chauf != other.cin_chauf) {
            return false;
        }
        if (this.permis_chauf != other.permis_chauf) {
            return false;
        }
        if (this.id_voiture != other.id_voiture) {
            return false;
        }
        if (!Objects.equals(this.image_cin, other.image_cin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id_chauf=" + id_chauf + ", cin_chauf=" + cin_chauf + ", permis_chauf=" + permis_chauf + ", image_cin=" + image_cin + ", id_voiture=" + id_voiture + '}';
    }

   
    
}

