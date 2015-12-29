package fr.meehome.user.services.dto;

public class UserDto {

    private int id;

    private String email;

    private String password;

    private String nom;

    private String prenom;

    private RoleEnumDto roleEnumDto;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public RoleEnumDto getRoleEnumDto() {
        return roleEnumDto;
    }

    public void setRoleEnumDto(RoleEnumDto roleEnumDto) {
        this.roleEnumDto = roleEnumDto;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public String toString() {
        return super.toString();
    }
}
