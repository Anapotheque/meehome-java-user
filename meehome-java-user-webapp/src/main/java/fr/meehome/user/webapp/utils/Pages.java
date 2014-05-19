package fr.meehome.user.webapp.utils;

public enum Pages {

    // @formatter:off
    ACCUEIL("accueil"), INSCRIPTION_USER("inscriptionUser"), AUTHENTIFICATION_USER("authentificationUser"), UPDATE_USER(
                    "updateUser"), VALIDATION_FORMULAIRE_SUCCESS("validationFormulaire");
    // @formatter:on

    private String libelle;

    private Pages(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }
}
