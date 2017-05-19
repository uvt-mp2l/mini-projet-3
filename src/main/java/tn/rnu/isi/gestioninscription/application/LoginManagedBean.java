/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.entities.Users;
import tn.rnu.isi.gestioninscription.beans.UsersBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.security.core.context.SecurityContextHolder;
import tn.rnu.isi.gestioninscription.beans.EtudiantBean;
import tn.rnu.isi.gestioninscription.entities.Etudiant;

/**
 *
 * @author Kamel
 */
@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    /**
     * Creates a new instance of LoginManagedBean
     */
    @ManagedProperty(value = "#{usersBean}")
    private UsersBean service;

    @ManagedProperty(value = "#{etudiantBean}")
    private EtudiantBean etudiantService;

    private List<Users> userList = new ArrayList<Users>();

    private Users userAccount = new Users();
    private Etudiant me = new Etudiant();

    public LoginManagedBean() {

    }

    public UsersBean getService() {
        return service;
    }

    public void setService(UsersBean service) {
        this.service = service;
    }

    public EtudiantBean getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(EtudiantBean etudiantService) {
        this.etudiantService = etudiantService;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }

    public Users getUsersAccount() {
        return userAccount;
    }

    public void setUsersAccount(Users userAccount) {
        this.userAccount = userAccount;
    }

    public Etudiant getMe() {
        return me;
    }

    public void setMe(Etudiant me) {
        this.me = me;
    }

    public List<Users> getUsersList() {
        return (List<Users>) getService().getUsersRepository().findAll();
    }

    public void setUsersList(List<Users> userList) {
        this.userList = userList;
    }

    //Login UsersInfo
    public void checkSessionInfo() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            org.springframework.security.core.userdetails.User userInf = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userAccount = getService().getUsersRepository().findByEmail((String) userInf.getUsername());
            me = getEtudiantService().getEtudiantRepository().findByEmail((String) userInf.getUsername());
        } else {
            FacesContext fContext = FacesContext.getCurrentInstance();
            ExternalContext extContext = fContext.getExternalContext();
            try {
                extContext.redirect(extContext.getRequestContextPath() + "/login.xhtml?faces-redirect=true");
            } catch (Exception eax) {
                Logger.getLogger(LoginManagedBean.class.getName()).info(Level.SEVERE + " Exception msg: " + eax.getMessage());
            }
        }
    }

}
