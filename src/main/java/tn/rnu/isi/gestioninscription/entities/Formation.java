/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MacBook
 */
@Entity
@Table(name = "formation")
@Cacheable(false)
public class Formation implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeform")
    private List<Paiement> paiementList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codeform")
    private String codeform;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categorie")
    private String categorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedebutcandidature")
    @Temporal(TemporalType.DATE)
    private Date datedebutcandidature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefincandidature")
    @Temporal(TemporalType.DATE)
    private Date datefincandidature;
    @Column(name = "prix")
    private Integer prix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeform")
    private List<Candidature> candidatureList;
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiantList;

    public Formation() {
    }

    public Formation(String codeform) {
        this.codeform = codeform;
    }

    public Formation(String codeform, String categorie, String libelle, String description, Date datedebutcandidature, Date datefincandidature) {
        this.codeform = codeform;
        this.categorie = categorie;
        this.libelle = libelle;
        this.description = description;
        this.datedebutcandidature = datedebutcandidature;
        this.datefincandidature = datefincandidature;
    }

    public String getCodeform() {
        return codeform;
    }

    public void setCodeform(String codeform) {
        this.codeform = codeform;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebutcandidature() {
        return datedebutcandidature;
    }

    public void setDatedebutcandidature(Date datedebutcandidature) {
        this.datedebutcandidature = datedebutcandidature;
    }

    public Date getDatefincandidature() {
        return datefincandidature;
    }

    public void setDatefincandidature(Date datefincandidature) {
        this.datefincandidature = datefincandidature;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @XmlTransient
    public List<Candidature> getCandidatureList() {
        return candidatureList;
    }

    public void setCandidatureList(List<Candidature> candidatureList) {
        this.candidatureList = candidatureList;
    }

    @XmlTransient
    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeform != null ? codeform.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.codeform == null && other.codeform != null) || (this.codeform != null && !this.codeform.equals(other.codeform))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tn.rnu.isi.gestioninscription.entities.Formation[ codeform=" + codeform + " ]";
    }

    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }
    
}
