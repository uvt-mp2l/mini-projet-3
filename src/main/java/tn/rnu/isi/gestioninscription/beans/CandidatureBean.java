/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.beans;

import tn.rnu.isi.gestioninscription.repository.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Kamel
 */

@Component
public class CandidatureBean {
    
    @Autowired
    private CandidatureRepository candidatureRepository;

    public CandidatureBean() {

    }

    public CandidatureRepository getCandidatureRepository() {
        return candidatureRepository;
    }

    public void setCandidatureRepository(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }
    
}
