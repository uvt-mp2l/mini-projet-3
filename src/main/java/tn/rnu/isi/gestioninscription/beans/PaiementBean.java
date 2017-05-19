/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.beans;

import tn.rnu.isi.gestioninscription.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Kamel
 */

@Component
public class PaiementBean {
    
    @Autowired
    private PaiementRepository paiementRepository;

    public PaiementBean() {

    }

    public PaiementRepository getPaiementRepository() {
        return paiementRepository;
    }

    public void setPaiementRepository(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }
    
}
