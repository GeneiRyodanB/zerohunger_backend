package com.zerohunger.models.actions;

public enum ParticipationType {
	COLLECTE("collecte"),
	PREPARATION("preparation"),
	DISTRIBUTION("distribution");
	private final String name;
	private ParticipationType (String name) {
        this.name = name;
    }
}
