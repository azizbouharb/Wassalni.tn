/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIClass;

/**
 *
 * @author bahar
 */
public class Voiture_location {
     private int id_voiture;
   private String matricule;
    private String modele;
    private String carte_grise;
    private int prix_jour;

    public Voiture_location() {
    }

    public Voiture_location(int id_voiture, String matricule, String modele, String carte_grise, int prix_jour) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.modele = modele;
        this.carte_grise = carte_grise;
        this.prix_jour = prix_jour;
    }

    public Voiture_location(String matricule, String modele, String carte_grise, int prix_jour) {
        this.matricule = matricule;
        this.modele = modele;
        this.carte_grise = carte_grise;
        this.prix_jour = prix_jour;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarte_grise() {
        return carte_grise;
    }

    public void setCarte_grise(String carte_grise) {
        this.carte_grise = carte_grise;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id_voiture=" + id_voiture + ", matricule=" + matricule + ", modele=" + modele + ", carte_grise=" + carte_grise + ", prix_jour=" + prix_jour + '}';
    }
   
    
}
