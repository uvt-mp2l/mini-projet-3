/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.repository;

import tn.rnu.isi.gestioninscription.entities.Formation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Kamel
 */
@Repository
public interface FormationRepository extends CrudRepository<Formation, String>{

}
