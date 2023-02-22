/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Payement;
import java.util.List;

/**
 *
 * @author farah
 */
public interface IpayementService {
     public int ajouterLivraison(Payement p);
     public List<Payement> afficher();
     
    
}
