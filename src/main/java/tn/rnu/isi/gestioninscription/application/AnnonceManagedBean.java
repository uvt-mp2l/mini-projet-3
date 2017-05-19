/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.beans.AnnonceBean;
import tn.rnu.isi.gestioninscription.entities.Annonce;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kamel
 */

@ManagedBean(name = "annonceManagedBean")
@ViewScoped
public class AnnonceManagedBean {

    @ManagedProperty(value = "#{annonceBean}")
    private AnnonceBean annonceService;
    private List<Annonce> listAnnonces = new ArrayList<Annonce>();
    private List<Annonce> filteredAnnonces;
    private Annonce annonce = new Annonce();
    private Annonce selectedAnnonce = new Annonce();
    private NoArgGenerator timeBasedGenerator = Generators.timeBasedGenerator();

    public void createAnnonce() {
        try {
            annonce.setCodeannonce("A"+timeBasedGenerator.generate().timestamp());
            getAnnonceService().getAnnonceRepository().save(annonce);
            annonce = null;
            annonce = new Annonce();
            onSuccess("Annonce crée avec succée");
        } catch (Exception ex) {
            onError("Annonce n'est pas pu étre crée");
        }
    }

    public void deleteAnnonce(String idAnnonce) {
        try {
            Annonce cit = getAnnonceService().getAnnonceRepository().findOne(idAnnonce);
            getAnnonceService().getAnnonceRepository().delete(cit);
            cit = null;
            onSuccess("Annonce supprimé avec succée");
        } catch (Exception ex) {
            onError("Annonce n'est pas pu étre supprimé");
        }
    }

    public void editAnnonce() {
        try {
            getAnnonceService().getAnnonceRepository().save(getSelectedAnnonce());
            selectedAnnonce = null;
            selectedAnnonce = new Annonce();
            onSuccess("Annonce modifié avec succée");
        } catch (Exception ex) {
            onError("Annonce n'est pas pu étre modifié");
        }
    }

    public AnnonceBean getAnnonceService() {
        return annonceService;
    }

    public void setAnnonceService(AnnonceBean annonceService) {
        this.annonceService = annonceService;
    }

    public List<Annonce> getListAnnonces() {
        return (List<Annonce>) getAnnonceService().getAnnonceRepository().findAll();
    }

    public void setListAnnonces(List<Annonce> listAnnonces) {
        this.listAnnonces = listAnnonces;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Annonce getSelectedAnnonce() {
        return selectedAnnonce;
    }

    public void setSelectedAnnonce(Annonce selectedAnnonce) {
        this.selectedAnnonce = selectedAnnonce;
    }

    public AnnonceManagedBean() {
    }

    public List<Annonce> getFilteredAnnonces() {
        return filteredAnnonces;
    }

    public void setFilteredAnnonces(List<Annonce> filteredAnnonces) {
        this.filteredAnnonces = filteredAnnonces;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
}
