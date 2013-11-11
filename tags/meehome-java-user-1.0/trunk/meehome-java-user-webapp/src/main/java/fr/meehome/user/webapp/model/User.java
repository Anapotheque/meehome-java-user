package fr.meehome.user.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Veuillez renseigner votre login")
    private String login;

    @NotEmpty(message = "Veuillez renseigner votre password")
    private String password;

    @NotEmpty(message = "Veuillez renseigner votre nom")
    private String nom;

    @NotEmpty(message = "Veuillez renseigner votre prenom")
    private String prenom;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
