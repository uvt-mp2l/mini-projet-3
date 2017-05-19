/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.rnu.isi.gestioninscription.application;

import tn.rnu.isi.gestioninscription.beans.UsersBean;
import tn.rnu.isi.gestioninscription.entities.Users;

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

@ManagedBean(name = "usersManagedBean")
@ViewScoped
public class UsersManagedBean {

    @ManagedProperty(value = "#{usersBean}")
    private UsersBean usersService;
    private List<Users> listUserss = new ArrayList<Users>();
    private List<Users> filteredUserss;
    private Users users = new Users();
    private Users selectedUsers = new Users();

    public void createUsers() {
        try {
            getUsersService().getUsersRepository().save(users);
            users = null;
            users = new Users();
            onSuccess("Users crée avec succée");
        } catch (Exception ex) {
            onError("Users n'est pas pu étre crée");
        }
    }

    public void deleteUsers(String idUsers) {
        try {
            Users cit = getUsersService().getUsersRepository().findOne(idUsers);
            getUsersService().getUsersRepository().delete(cit);
            cit = null;
            onSuccess("Users supprimé avec succée");
        } catch (Exception ex) {
            onError("Users n'est pas pu étre supprimé");
        }
    }

    public void editUsers() {
        try {
            getUsersService().getUsersRepository().save(getSelectedUsers());
            selectedUsers = null;
            selectedUsers = new Users();
            onSuccess("Users modifié avec succée");
        } catch (Exception ex) {
            onError("Users n'est pas pu étre modifié");
        }
    }

    public UsersBean getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersBean usersService) {
        this.usersService = usersService;
    }

    public List<Users> getListUserss() {
        return (List<Users>) getUsersService().getUsersRepository().findAll();
    }

    public void setListUserss(List<Users> listUserss) {
        this.listUserss = listUserss;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(Users selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public UsersManagedBean() {
    }

    public List<Users> getFilteredUserss() {
        return filteredUserss;
    }

    public void setFilteredUserss(List<Users> filteredUserss) {
        this.filteredUserss = filteredUserss;
    }

    //Messages
    public void onSuccess(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
    }

    public void onError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg));
    }
}
