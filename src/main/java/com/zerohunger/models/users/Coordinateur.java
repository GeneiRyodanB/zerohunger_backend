package com.zerohunger.models.users;

import com.zerohunger.models.actions.Action;

public class Coordinateur extends Benevole {

    public Coordinateur(){}

    public Coordinateur(String nom, String email, String tel, String ville, String password) {
        super(nom, email, tel, ville, password);
    }

    public int creerAction(Action action){
        return 0;
    }

    public int majAction(Action action){
        return 0;
    }

    public boolean deleteAction(int actionId){
        return false;
    }

    public boolean approverBenevole(Benevole benevole){
        return false;
    }
}