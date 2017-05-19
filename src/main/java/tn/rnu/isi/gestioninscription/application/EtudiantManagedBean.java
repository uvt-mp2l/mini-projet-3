/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.beans.EtudiantBean;
import tn.rnu.isi.gestioninscription.entities.Etudiant;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import tn.rnu.isi.gestioninscription.entities.Candidature;

/**
 *
 * @author Kamel
 */

@ManagedBean(name = "etudiantManagedBean")
@ViewScoped
public class EtudiantManagedBean {

    @ManagedProperty(value = "#{etudiantBean}")
    private EtudiantBean etudiantService;
    private List<Etudiant> listEtudiants = new ArrayList<Etudiant>();
    private List<Etudiant> filteredEtudiants;
    private Etudiant etudiant = new Etudiant();
    private Etudiant selectedEtudiant = new Etudiant();
    private String emailadresse;
    private String password;

    public void createEtudiant() {
        try {
            etudiant.setMoisinscript("Feb");
            getEtudiantService().getEtudiantRepository().save(etudiant);
            etudiant = null;
            emailadresse = null;
            password = null;
            etudiant = new Etudiant();
            onSuccess("Etudiant crée avec succée");
        } catch (Exception ex) {
            onError("Etudiant n'est pas pu étre crée");
        }
    }

    public void deleteEtudiant(String idEtudiant) {
        try {
            Etudiant cit = getEtudiantService().getEtudiantRepository().findOne(idEtudiant);
            getEtudiantService().getEtudiantRepository().delete(cit);
            cit = null;
            onSuccess("Etudiant supprimé avec succée");
        } catch (Exception ex) {
            onError("Etudiant n'est pas pu étre supprimé");
        }
    }

    public void editEtudiant() {
        try {
            getEtudiantService().getEtudiantRepository().save(getSelectedEtudiant());
            selectedEtudiant = null;
            selectedEtudiant = new Etudiant();
            onSuccess("Etudiant modifié avec succée");
        } catch (Exception ex) {
            onError("Etudiant n'est pas pu étre modifié");
        }
    }

    public EtudiantBean getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(EtudiantBean etudiantService) {
        this.etudiantService = etudiantService;
    }

    public List<Etudiant> getListEtudiants() {
        return (List<Etudiant>) getEtudiantService().getEtudiantRepository().findAll();
    }

    public void setListEtudiants(List<Etudiant> listEtudiants) {
        this.listEtudiants = listEtudiants;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etudiant getSelectedEtudiant() {
        return selectedEtudiant;
    }

    public void setSelectedEtudiant(Etudiant selectedEtudiant) {
        this.selectedEtudiant = selectedEtudiant;
    }

    public EtudiantManagedBean() {
    }

    public List<Etudiant> getFilteredEtudiants() {
        return filteredEtudiants;
    }

    public void setFilteredEtudiants(List<Etudiant> filteredEtudiants) {
        this.filteredEtudiants = filteredEtudiants;
    }

    public String getEmailadresse() {
        return emailadresse;
    }

    public void setEmailadresse(String emailadresse) {
        this.emailadresse = emailadresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
}
