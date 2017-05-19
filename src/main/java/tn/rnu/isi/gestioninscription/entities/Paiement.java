/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paiement")
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_recu")
    private String numeroRecu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private int montant;
    @Size(max = 50)
    @Column(name = "mois")
    private String mois;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
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

    public Paiement() {
    }

    public Paiement(String numeroRecu) {
        this.numeroRecu = numeroRecu;
    }

    public Paiement(String numeroRecu, int montant, int etat) {
        this.numeroRecu = numeroRecu;
        this.montant = montant;
        this.etat = etat;
    }

    public String getNumeroRecu() {
        return numeroRecu;
    }

    public void setNumeroRecu(String numeroRecu) {
        this.numeroRecu = numeroRecu;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (numeroRecu != null ? numeroRecu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.numeroRecu == null && other.numeroRecu != null) || (this.numeroRecu != null && !this.numeroRecu.equals(other.numeroRecu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tn.rnu.isi.gestioninscription.entities.Paiement[ numeroRecu=" + numeroRecu + " ]";
    }
    
}
