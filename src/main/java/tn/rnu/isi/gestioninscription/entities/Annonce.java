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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MacBook
 */
@Entity
@Table(name = "annonce")
@Cacheable(false)
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codeannonce")
    private String codeannonce;
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
    @Column(name = "dateannonce")
    @Temporal(TemporalType.DATE)
    private Date dateannonce;

    public Annonce() {
    }

    public Annonce(String codeannonce) {
        this.codeannonce = codeannonce;
    }

    public Annonce(String codeannonce, String libelle, String description, Date dateannonce) {
        this.codeannonce = codeannonce;
        this.libelle = libelle;
        this.description = description;
        this.dateannonce = dateannonce;
    }

    public String getCodeannonce() {
        return codeannonce;
    }

    public void setCodeannonce(String codeannonce) {
        this.codeannonce = codeannonce;
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

    public Date getDateannonce() {
        return dateannonce;
    }

    public void setDateannonce(Date dateannonce) {
        this.dateannonce = dateannonce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeannonce != null ? codeannonce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.codeannonce == null && other.codeannonce != null) || (this.codeannonce != null && !this.codeannonce.equals(other.codeannonce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tn.rnu.isi.gestioninscription.entities.Annonce[ codeannonce=" + codeannonce + " ]";
    }
    
}
