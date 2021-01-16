package com.ggl.match.game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ggl.match.game.model.Card;
import com.ggl.match.game.model.MatchGameModel;

public class CardListener implements ActionListener {
	
	private JButton firstSelectionButton;
	
	private final MatchGameModel model;

	public CardListener(MatchGameModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Card[] cards = model.getDeck().getDeck();
		JButton button = (JButton) event.getSource();
		
		if (model.getFirstSelection() == null) {
			this.firstSelectionButton = button;
			int index = Integer.valueOf(button.getActionCommand());
			model.setFirstSelection(cards[index]);
			button.setEnabled(false);
		} else if (model.getSecondSelection() == null) {
			int index = Integer.valueOf(button.getActionCommand());
			model.setSecondSelection(cards[index]);
			button.setEnabled(false);
			if (!model.areCardsEqual()) {
				new Thread(new SelectionRunnable(
						firstSelectionButton, button)).start();
			}
			model.resetSelection();
		}
	}

}
