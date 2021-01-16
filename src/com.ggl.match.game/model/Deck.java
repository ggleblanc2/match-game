package com.ggl.match.game.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

public class Deck {
	
	private BufferedImage cardBackImage;
	private BufferedImage blankImage;
	
	private Card[] deck;

	public Deck() {
		this.deck = new Card[52];
		createDeck();
	}
	
	private void createDeck() {
		BufferedImage totalImage = getImage();
		String[] suits = { "spades", "hearts", "diamonds", "clubs" };
		String[] displayValues = { "Ace", "Two", "Three", "Four", "Five", 
				"Six", "Seven", "Eight", "Nine", "Ten",
				"Jack", "Queen", "King" };

		int x = 9;
		int y = 7;
		int index = 0;
		for (int i = 0; i < 4; i++) {
			String suit = suits[i];
			for (int j = 0; j < 13; j++) {
				BufferedImage image = totalImage.getSubimage(x, y, 90, 135);
				Card card = new Card(displayValues[j], suit, (j + 1));
				card.setImage(image);
				deck[index++] = card;
				x += 98;
			}
			y += 143;
			x = 9;
		}

		this.cardBackImage = totalImage.getSubimage(402, 579, 90, 135);
		this.blankImage = new BufferedImage(90, 135, BufferedImage.TYPE_INT_RGB);
	}
	
	public Card[] shuffleDeck() {
		List<Card> cardList = Arrays.asList(deck);
		Collections.shuffle(cardList);
		return cardList.toArray(new Card[deck.length]);
	}

	public BufferedImage getCardBackImage() {
		return cardBackImage;
	}

	public BufferedImage getBlankImage() {
		return blankImage;
	}

	public Card[] getDeck() {
		return deck;
	}
	
	private BufferedImage getImage() {
		try {
			return ImageIO.read(getClass().getResourceAsStream("/deckofcards.png"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
