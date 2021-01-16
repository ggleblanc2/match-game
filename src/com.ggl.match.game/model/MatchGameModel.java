package com.ggl.match.game.model;

public class MatchGameModel {
	
	private final Deck deck;
	
	private Card firstSelection;
	private Card secondSelection;
	
	public MatchGameModel() {
		this.deck = new Deck();
		resetSelection();
	}
	
	public void resetSelection() {
		this.firstSelection = null;
		this.secondSelection = null;
	}

	public Deck getDeck() {
		return deck;
	}

	public Card getFirstSelection() {
		return firstSelection;
	}

	public void setFirstSelection(Card firstSelection) {
		this.firstSelection = firstSelection;
	}

	public Card getSecondSelection() {
		return secondSelection;
	}

	public void setSecondSelection(Card secondSelection) {
		this.secondSelection = secondSelection;
	}
	
	public boolean areCardsEqual() {
		int value1 = firstSelection.getValue();
		int value2 = secondSelection.getValue();
		return value1 == value2;
	}

}
