package fr.meehome.user.dao.domain;

public enum RoleEnum {
    ADMINISTRATEUR(1, "adminsitrateur"), VISITEUR(2, "visiteur");

    private int code;

    private String libelle;

    private RoleEnum(int code, String libelle) {
        this.code = code;
        this.setLibelle(libelle);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
