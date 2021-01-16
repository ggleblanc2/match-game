package com.ggl.match.game.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.ggl.match.game.model.Card;
import com.ggl.match.game.model.MatchGameModel;
import com.ggl.match.game.view.MatchGameFrame;

public class ResetListener implements ActionListener {
	
	public MatchGameFrame frame;
	
	public MatchGameModel model;

	public ResetListener(MatchGameFrame frame, MatchGameModel model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Card[] cards = model.getDeck().shuffleDeck();
		model.resetSelection();
		
		Component[] components = frame.getCardPanel().getComponents();
		for (int i = 0; i < components.length; i++) {
			JButton button = (JButton) components[i];
			button.setDisabledIcon(new ImageIcon(cards[i].getImage()));
			button.setEnabled(true);
		}
	}

}
