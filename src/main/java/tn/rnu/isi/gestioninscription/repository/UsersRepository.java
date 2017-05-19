/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.repository;

import tn.rnu.isi.gestioninscription.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Kamel
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, String>{
    Users findByEmail(String Email);
}
