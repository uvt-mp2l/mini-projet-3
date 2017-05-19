/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import tn.rnu.isi.gestioninscription.beans.FormationBean;
import tn.rnu.isi.gestioninscription.entities.Formation;

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

@ManagedBean(name = "formationManagedBean")
@ViewScoped
public class FormationManagedBean {

    @ManagedProperty(value = "#{formationBean}")
    private FormationBean formationService;
    private List<Formation> listFormations = new ArrayList<Formation>();
    private List<Formation> filteredFormations;
    private Formation formation = new Formation();
    private Formation selectedFormation = new Formation();
    private NoArgGenerator timeBasedGenerator = Generators.timeBasedGenerator();

    public void createFormation() {
        try {
            formation.setCodeform("F"+timeBasedGenerator.generate().timestamp());
            getFormationService().getFormationRepository().save(formation);
            formation = null;
            formation = new Formation();
            onSuccess("Formation crée avec succée");
        } catch (Exception ex) {
            onError("Formation n'est pas pu étre crée");
        }
    }

    public void deleteFormation(String idFormation) {
        try {
            Formation cit = getFormationService().getFormationRepository().findOne(idFormation);
            getFormationService().getFormationRepository().delete(cit);
            cit = null;
            onSuccess("Formation supprimé avec succée");
        } catch (Exception ex) {
            onError("Formation n'est pas pu étre supprimé");
        }
    }

    public void editFormation() {
        try {
            getFormationService().getFormationRepository().save(getSelectedFormation());
            selectedFormation = null;
            selectedFormation = new Formation();
            onSuccess("Formation modifié avec succée");
        } catch (Exception ex) {
            onError("Formation n'est pas pu étre modifié");
        }
    }

    public FormationBean getFormationService() {
        return formationService;
    }

    public void setFormationService(FormationBean formationService) {
        this.formationService = formationService;
    }

    public List<Formation> getListFormations() {
        return (List<Formation>) getFormationService().getFormationRepository().findAll();
    }

    public void setListFormations(List<Formation> listFormations) {
        this.listFormations = listFormations;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Formation getSelectedFormation() {
        return selectedFormation;
    }

    public void setSelectedFormation(Formation selectedFormation) {
        this.selectedFormation = selectedFormation;
    }

    public FormationManagedBean() {
    }

    public List<Formation> getFilteredFormations() {
        return filteredFormations;
    }

    public void setFilteredFormations(List<Formation> filteredFormations) {
        this.filteredFormations = filteredFormations;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
}
