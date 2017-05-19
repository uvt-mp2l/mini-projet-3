/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.beans;

import tn.rnu.isi.gestioninscription.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author Kamel
 */

@Component
public class FormationBean {
    
    @Autowired
    private FormationRepository formationRepository;

    public FormationBean() {

    }

    public FormationRepository getFormationRepository() {
        return formationRepository;
    }

    public void setFormationRepository(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }
    
}
