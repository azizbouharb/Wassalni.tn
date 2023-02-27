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
       
    private int id;
    private int programme_id;
    private String Destination;
    private String date;
    private String rapport;
    private int Num_tel;
    private String mail;
                    
    public Alerts(){}

    public Alerts(int id, String Destination, String date, String rapport, int Num_tel, String mail) 
    {
        this.id = id;
        this.Destination = Destination;
        this.date = date;
        this.rapport = rapport;
        this.Num_tel = Num_tel;
        this.mail = mail;
    }
    public Alerts(int id,int programme_id, String Destination, String date, String rapport, int Num_tel, String mail) 
    {
        this.id = id;
        this.programme_id = programme_id;
        this.Destination= Destination;
        this.date = date;
        this.rapport = rapport;
        this.Num_tel = Num_tel;
        this.mail = mail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(int programme_id) {
        this.programme_id = programme_id;
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
        return "Alerts{" + "id=" + id + ", programme_id=" + programme_id + ", Destination=" + Destination + ", date=" + date + ", rapport=" + rapport + ", Num_tel=" + Num_tel + ", mail=" + mail + '}';
    }

    
 

    
}