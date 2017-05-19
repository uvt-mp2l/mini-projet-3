/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.repository;

import java.util.List;
import tn.rnu.isi.gestioninscription.entities.Candidature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.gestioninscription.entities.Etudiant;
import tn.rnu.isi.gestioninscription.entities.Formation;
/**
 *
 * @author Kamel
 */
@Repository
public interface CandidatureRepository extends CrudRepository<Candidature, Integer>{
    List<Candidature> findByNumeroOrderByDatecandidatureDesc(Etudiant Numero);
    List<Candidature> findByCodeform(Formation Codeform);
}
