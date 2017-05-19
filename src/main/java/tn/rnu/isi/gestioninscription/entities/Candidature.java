/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MacBook
 */
@Entity
@Table(name = "candidature")
@Cacheable(false)
public class Candidature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "candidatureid")
    private Integer candidatureid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecandidature")
    @Temporal(TemporalType.DATE)
    private Date datecandidature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat")
    private int etat;
    @JoinColumn(name = "numero", referencedColumnName = "numero")
    @ManyToOne(optional = false)
    private Etudiant numero;
    @JoinColumn(name = "codeform", referencedColumnName = "codeform")
    @ManyToOne(optional = false)
    private Formation codeform;

    public Candidature() {
    }

    public Candidature(Integer candidatureid) {
        this.candidatureid = candidatureid;
    }

    public Candidature(Integer candidatureid, Date datecandidature, int etat) {
        this.candidatureid = candidatureid;
        this.datecandidature = datecandidature;
        this.etat = etat;
    }

    public Integer getCandidatureid() {
        return candidatureid;
    }

    public void setCandidatureid(Integer candidatureid) {
        this.candidatureid = candidatureid;
    }

    public Date getDatecandidature() {
        return datecandidature;
    }

    public void setDatecandidature(Date datecandidature) {
        this.datecandidature = datecandidature;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Etudiant getNumero() {
        return numero;
    }

    public void setNumero(Etudiant numero) {
        this.numero = numero;
    }

    public Formation getCodeform() {
        return codeform;
    }

    public void setCodeform(Formation codeform) {
        this.codeform = codeform;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidatureid != null ? candidatureid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidature)) {
            return false;
        }
        Candidature other = (Candidature) object;
        if ((this.candidatureid == null && other.candidatureid != null) || (this.candidatureid != null && !this.candidatureid.equals(other.candidatureid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tn.rnu.isi.gestioninscription.entities.Candidature[ candidatureid=" + candidatureid + " ]";
    }
    
}
