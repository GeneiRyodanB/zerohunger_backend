package com.zerohunger.models.users;

public class Admin extends Coordinateur {

    public Admin() {
    }

    public Admin(String nom, String email, String tel, String ville, String password) {
        super(nom, email, tel, ville, password);
    }

    public boolean approverCoordinateur(Coordinateur coordinateur){
        return false;
    }

}
