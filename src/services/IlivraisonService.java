/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import entities.Livraison;

/**
 *
 * @author farah
 */

    public interface IlivraisonService {
    public int ajouterLivraison(Livraison l);
    public boolean modifierLivraison(Livraison l);
    public boolean supprimerLivraison(Livraison l);
    public List<Livraison> afficher();
}

