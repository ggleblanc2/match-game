package com.ggl.match.game.model;

import java.awt.image.BufferedImage;

public class Card {
	
	private BufferedImage image;
	
	private final int value;
	
	private final String suit;
	private final String displayValue;
	
	public Card(String displayValue, String suit, int value) {
		this.displayValue = displayValue;
		this.suit = suit;
		this.value = value;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [displayValue=");
		builder.append(displayValue);
		builder.append(", suit=");
		builder.append(suit);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

	

}
