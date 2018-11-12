package com.zerohunger.models.actions;

public enum Article {
	FROMAGE("fromage"),
	OEUF("ouef"),
	LAIT("lait"),
	YAGOURT("yagourt"),
	PAIN("pain"),
	SARDINE("sardine"),
	EAU("eau"),
	MADLINE_PETITPAIN("madline_petitpain"),
	FRUIT("fruit"),
	PACKET_SACHET("packet_sachet"),
	SERVIETTE("serviette"),
	CUILLERE("cuillere"),
	STICKERS("stickers"),
	SANDWITCH("sandwitch");
	private final String name;
	private Article (String name) {
		this.name = name;
	}
}
