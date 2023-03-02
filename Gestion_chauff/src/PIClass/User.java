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
 * @author user
 */
public class User {

    protected int id_client;
    protected String nom_client;
    protected int cin_client;
    protected String email_client;
    protected String pass_client;
    protected int role_client;

    public User() {
    }

    public User(int id_client, String nom_client, int cin_client, String email_client, String pass_client, int role_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;

        this.cin_client = cin_client;
        this.email_client = email_client;

        this.pass_client = pass_client;
        this.role_client = role_client;
    }

    public User(String nom_client, String email_client, String pass_client) {
        this.nom_client = nom_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
    }

    public User(int id_client, String nom_client, String email_client, String pass_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
    }

    public User(int id_client, String nom_client, int cin_client, String email_client, String pass_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.cin_client = cin_client;
        this.email_client = email_client;
        this.pass_client = pass_client;
    }

    public User(String nom_client, int cin_client, String email_client, String pass_client, int role_client) {
        this.nom_client = nom_client;

        this.cin_client = cin_client;
        this.email_client = email_client;

        this.pass_client = pass_client;
        this.role_client = role_client;
    }

    public User(String nom_client, int cin_client, String email_client, String pass_client) {
        this.nom_client = nom_client;

        this.cin_client = cin_client;
        this.email_client = email_client;

        this.pass_client = pass_client;
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public int getCin_client() {
        return cin_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public String getPass_client() {
        return pass_client;
    }

    public int getRole_client() {
        return role_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public void setPass_client(String pass_client) {
        this.pass_client = pass_client;
    }

    public void setRole_client(int role_client) {
        this.role_client = role_client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final User other = (User) obj;
        if (this.cin_client != other.cin_client) {
            return false;
        }
        return true;
    }


    

}
