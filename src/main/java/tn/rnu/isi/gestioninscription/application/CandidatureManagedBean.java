/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.beans.CandidatureBean;
import tn.rnu.isi.gestioninscription.entities.Candidature;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import tn.rnu.isi.gestioninscription.beans.PaiementBean;
import tn.rnu.isi.gestioninscription.entities.Etudiant;
import tn.rnu.isi.gestioninscription.entities.Formation;
import tn.rnu.isi.gestioninscription.entities.Paiement;

/**
 *
 * @author Kamel
 */
@ManagedBean(name = "candidatureManagedBean")
@ViewScoped
public class CandidatureManagedBean {

    @ManagedProperty(value = "#{paiementBean}")
    private PaiementBean paiementService;
    private Paiement paiement = new Paiement();
    @ManagedProperty(value = "#{candidatureBean}")
    private CandidatureBean candidatureService;
    private List<Candidature> listCandidatures = new ArrayList<Candidature>();
    private List<Candidature> filteredCandidatures;
    private Candidature candidature = new Candidature();
    private Candidature selectedCandidature = new Candidature();
    private NoArgGenerator timeBasedGenerator = Generators.timeBasedGenerator();

    public void createCandidature(Etudiant numero) {
        try {
            
            if (getCandidatureService().getCandidatureRepository().findByCodeform(candidature.getCodeform()).isEmpty()) {
                candidature.setEtat(0);
                candidature.setNumero(numero);
                candidature.setDatecandidature(new Date());
                getCandidatureService().getCandidatureRepository().save(candidature);
                onSuccess("Candidature crée avec succée");
            } else {
                onWarn("Vous avez candidaté deja pour cette formation");
            }
            candidature = null;
            candidature = new Candidature();
            candidature.setNumero(new Etudiant());
            candidature.setCodeform(new Formation());

        } catch (Exception ex) {
            onError("Candidature n'est pas pu étre crée");
        }
    }

    public void deleteCandidature(Integer idCandidature) {
        try {
            Candidature cit = getCandidatureService().getCandidatureRepository().findOne(idCandidature);
            getCandidatureService().getCandidatureRepository().delete(cit);
            cit = null;
            onSuccess("Candidature supprimé avec succée");
        } catch (Exception ex) {
            onError("Candidature n'est pas pu étre supprimé");
        }
    }

    public void editCandidature() {
        try {
            
            getCandidatureService().getCandidatureRepository().save(getSelectedCandidature());
            if (getSelectedCandidature().getEtat() == 1){
                Calendar cal = Calendar.getInstance();
                paiement = new Paiement();
                paiement.setCodeform(getSelectedCandidature().getCodeform());
                paiement.setNumero(getSelectedCandidature().getNumero());
                paiement.setDate(new Date());
                paiement.setEtat(0);
                paiement.setMontant(getSelectedCandidature().getCodeform().getPrix());
                paiement.setNumeroRecu(timeBasedGenerator.generate().toString());
                paiement.setMois(new SimpleDateFormat("MMMM").format(cal.getTime()).toString());
                getPaiementService().getPaiementRepository().save(paiement);
            }
            selectedCandidature = null;
            selectedCandidature = new Candidature();
            paiement = null;
            onSuccess("Candidature modifié avec succée");
        } catch (Exception ex) {
            onError("Candidature n'est pas pu étre modifié");
        }
    }

    public CandidatureBean getCandidatureService() {
        return candidatureService;
    }

    public void setCandidatureService(CandidatureBean candidatureService) {
        this.candidatureService = candidatureService;
    }

    public List<Candidature> getMyListCandidatures(Etudiant numero) {
        return (List<Candidature>) getCandidatureService().getCandidatureRepository().findByNumeroOrderByDatecandidatureDesc(numero);
    }

    public List<Candidature> getListCandidatures() {
        return (List<Candidature>) getCandidatureService().getCandidatureRepository().findAll();
    }

    public void setListCandidatures(List<Candidature> listCandidatures) {
        this.listCandidatures = listCandidatures;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public Candidature getSelectedCandidature() {
        return selectedCandidature;
    }

    public void setSelectedCandidature(Candidature selectedCandidature) {
        this.selectedCandidature = selectedCandidature;
    }

    public CandidatureManagedBean() {
        candidature.setNumero(new Etudiant());
        candidature.setCodeform(new Formation());
    }

    public List<Candidature> getFilteredCandidatures() {
        return filteredCandidatures;
    }

    public void setFilteredCandidatures(List<Candidature> filteredCandidatures) {
        this.filteredCandidatures = filteredCandidatures;
    }

    public PaiementBean getPaiementService() {
        return paiementService;
    }

    public void setPaiementService(PaiementBean paiementService) {
        this.paiementService = paiementService;
    }
    
    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
    
    public void onWarn(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn!", msg));
    }
}
