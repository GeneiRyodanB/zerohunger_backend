package com.zerohunger.models.users;


import com.zerohunger.models.actions.Action;

import java.util.Objects;

public class Benevole {

	protected Long Id;
    protected String nom;
    protected String email;
    protected String tel;
    protected String ville;
    protected String password;

    public Benevole() {}

    public Benevole(String nom, String email, String tel, String ville, String password) {
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.ville = ville;
        this.password = password;
    }

    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int participerAction(Action action){
        return 0;
    }

    @Override
    public String toString() {
        return "Benevole{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", ville='" + ville + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benevole benevole = (Benevole) o;
        return Objects.equals(nom, benevole.nom) &&
                Objects.equals(email, benevole.email) &&
                Objects.equals(tel, benevole.tel) &&
                Objects.equals(ville, benevole.ville) &&
                Objects.equals(password, benevole.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nom, email, tel, ville, password);
    }
}
