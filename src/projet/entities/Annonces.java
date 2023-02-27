/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entities;

/**
 *
 * @author ASUS
 */

import java.util.Objects;




public class Annonces {
    
     private int id_annonce;
    private String date_annonce;
    private String destination_annonce;
    private String depart_annonce;
    private int dispo_annonce;
    private int Num_tel;
    
    public Annonces(){
    }

    public Annonces(int id_annonce, String date_annonce, String destination_annonce, String depart_annonce, int dispo_annonce, int Num_tel) {
        this.id_annonce = id_annonce;
        this.date_annonce = date_annonce;
        this.destination_annonce = destination_annonce;
        this.depart_annonce = depart_annonce;
        this.dispo_annonce = dispo_annonce;
        this.Num_tel = Num_tel;
    }

    public Annonces(String date_annonce, String destination_annonce, String depart_annonce, int dispo_annonce, int Num_tel) {
        this.date_annonce = date_annonce;
        this.destination_annonce = destination_annonce;
        this.depart_annonce = depart_annonce;
        this.dispo_annonce = dispo_annonce;
        this.Num_tel = Num_tel;
    }

    public Annonces(int i, String type, String description, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public String getDate_annonce() {
        return date_annonce;
    }

    public String getDestination_annonce() {
        return destination_annonce;
    }

    public String getDepart_annonce() {
        return depart_annonce;
    }

    public int getDispo_annonce() {
        return dispo_annonce;
    }

    public int getNum_tel() {
        return Num_tel;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public void setDate_annonce(String date_annonce) {
        this.date_annonce = date_annonce;
    }

    public void setDestination_annonce(String destination_annonce) {
        this.destination_annonce = destination_annonce;
    }

    public void setDepart_annonce(String depart_annonce) {
        this.depart_annonce = depart_annonce;
    }

    public void setDispo_annonce(int dispo_annonce) {
        this.dispo_annonce = dispo_annonce;
    }

    public void setNum_tel(int Num_tel) {
        this.Num_tel = Num_tel;
    }

    @Override
    public String toString() {
        return "Annonces{" + "id_annonce=" + id_annonce + ", date_annonce=" + date_annonce + ", destination_annonce=" + destination_annonce + ", depart_annonce=" + depart_annonce + ", dispo_annonce=" + dispo_annonce + ", Num_tel=" + Num_tel + '}';
    }

    public void setContentText(String etes_vous_sure_de_supprimer_cette_element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
   
    
    
    
}
