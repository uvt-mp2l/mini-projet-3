/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.beans.PaiementBean;
import tn.rnu.isi.gestioninscription.entities.Paiement;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import tn.rnu.isi.gestioninscription.entities.Etudiant;

/**
 *
 * @author Kamel
 */

@ManagedBean(name = "paiementManagedBean")
@ViewScoped
public class PaiementManagedBean {

    @ManagedProperty(value = "#{paiementBean}")
    private PaiementBean paiementService;
    private List<Paiement> listPaiements = new ArrayList<Paiement>();
    private List<Paiement> filteredPaiements;
    private Paiement paiement = new Paiement();
    private Paiement selectedPaiement = new Paiement();

    public void createPaiement() {
        try {
            getPaiementService().getPaiementRepository().save(paiement);
            paiement = null;
            paiement = new Paiement();
            onSuccess("Paiement crée avec succée");
        } catch (Exception ex) {
            onError("Paiement n'est pas pu étre crée");
        }
    }

    public void deletePaiement(String idPaiement) {
        try {
            Paiement cit = getPaiementService().getPaiementRepository().findOne(idPaiement);
            getPaiementService().getPaiementRepository().delete(cit);
            cit = null;
            onSuccess("Paiement supprimé avec succée");
        } catch (Exception ex) {
            onError("Paiement n'est pas pu étre supprimé");
        }
    }

    public void editPaiement() {
        try {
            getPaiementService().getPaiementRepository().save(getSelectedPaiement());
            selectedPaiement = null;
            selectedPaiement = new Paiement();
            onSuccess("Paiement modifié avec succée");
        } catch (Exception ex) {
            onError("Paiement n'est pas pu étre modifié");
        }
    }
    
    public List<Paiement> getMyListPaiements(Etudiant numero) {
        return (List<Paiement>) getPaiementService().getPaiementRepository().findByNumeroOrderByDateDesc(numero);
    }

    public PaiementBean getPaiementService() {
        return paiementService;
    }

    public void setPaiementService(PaiementBean paiementService) {
        this.paiementService = paiementService;
    }

    public List<Paiement> getListPaiements() {
        return (List<Paiement>) getPaiementService().getPaiementRepository().findByEtatOrderByDateDesc(1);
    }

    public void setListPaiements(List<Paiement> listPaiements) {
        this.listPaiements = listPaiements;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Paiement getSelectedPaiement() {
        return selectedPaiement;
    }

    public void setSelectedPaiement(Paiement selectedPaiement) {
        this.selectedPaiement = selectedPaiement;
    }

    public PaiementManagedBean() {
    }

    public List<Paiement> getFilteredPaiements() {
        return filteredPaiements;
    }

    public void setFilteredPaiements(List<Paiement> filteredPaiements) {
        this.filteredPaiements = filteredPaiements;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
}
