/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.beans;

import tn.rnu.isi.gestioninscription.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Kamel
 */

@Component
public class AnnonceBean {
    
    @Autowired
    private AnnonceRepository annonceRepository;

    public AnnonceBean() {

    }

    public AnnonceRepository getAnnonceRepository() {
        return annonceRepository;
    }

    public void setAnnonceRepository(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }
    
}
