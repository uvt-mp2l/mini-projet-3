/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.repository;

import java.util.List;
import tn.rnu.isi.gestioninscription.entities.Paiement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.gestioninscription.entities.Etudiant;
/**
 *
 * @author Kamel
 */
@Repository
public interface PaiementRepository extends CrudRepository<Paiement, String>{
    List<Paiement> findByEtatOrderByDateDesc(int etat);
    List<Paiement> findByNumeroOrderByDateDesc(Etudiant Numero);
}
