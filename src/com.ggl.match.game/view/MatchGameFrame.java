package com.ggl.match.game.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ggl.match.game.controller.CardListener;
import com.ggl.match.game.controller.ResetListener;
import com.ggl.match.game.model.Card;
import com.ggl.match.game.model.Deck;
import com.ggl.match.game.model.MatchGameModel;

public class MatchGameFrame {
	
	private JPanel cardPanel;
	
	private MatchGameModel model;

	public MatchGameFrame(MatchGameModel model) {
		this.model = model;
		createGUI();
	}
	
	private void createGUI() {
		JFrame frame = new JFrame("Match Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.cardPanel = createCardPanel();
		frame.add(cardPanel, BorderLayout.CENTER);
		frame.add(createButtonPanel(), BorderLayout.AFTER_LAST_LINE);
		
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		System.out.println(frame.getSize());
	}
	
	private JPanel createCardPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 13, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Deck deck = model.getDeck();
		Card[] cards = deck.shuffleDeck();
		BufferedImage backImage = deck.getCardBackImage();
		BufferedImage blankImage = deck.getBlankImage();
		CardListener listener = new CardListener(model);
		
		for (int i = 0; i < 52; i++) {
			JButton button = new JButton();
			button.addActionListener(listener);
			button.setActionCommand(Integer.toString(i));
			button.setIcon(new ImageIcon(backImage));
			button.setDisabledIcon(new ImageIcon(cards[i].getImage()));
			button.setPressedIcon(new ImageIcon(blankImage));
			button.setPreferredSize(new Dimension(90, 135));
			panel.add(button);
		}
 		
		return panel;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		
		JButton button = new JButton("Reset Game");
		button.addActionListener(new ResetListener(this, model));
		panel.add(button);
		
		return panel;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

}
