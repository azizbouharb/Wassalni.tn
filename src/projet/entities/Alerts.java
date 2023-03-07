/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entities;
import java.sql.Date;



/**
 *
 * @author Taher
 */
public class Alerts {
       
    private int id_alerts;
    private int id_annonce;
    private String Destination;
    private String date;
    private String rapport;
    private int Num_tel;
    private String mail;
                    
    public Alerts(){}

    public Alerts(int id_alerts) {
        this.id_alerts = id_alerts;
    }

   

    public Alerts(int id_annonce, String rapport, String mail) {
        this.id_annonce = id_annonce;
        this.rapport = rapport;
        this.mail = mail;
    }

    

    public int getId_alerts() {
        return id_alerts;
    }

    public void setId_alerts(int id_alerts) {
        this.id_alerts = id_alerts;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
    


    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public int getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(int Num_tel) {
        this.Num_tel = Num_tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Alerts{" + "id_alerts=" + id_alerts + ", id_annonce=" + id_annonce + ", Destination=" + Destination + ", date=" + date + ", rapport=" + rapport + ", Num_tel=" + Num_tel + ", mail=" + mail + '}';
    }

    
    
 

    
}