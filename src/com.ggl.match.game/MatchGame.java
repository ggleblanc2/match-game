package com.ggl.match.game;

import javax.swing.SwingUtilities;

import com.ggl.match.game.model.MatchGameModel;
import com.ggl.match.game.view.MatchGameFrame;

public class MatchGame implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new MatchGame());
	}

	@Override
	public void run() {
		new MatchGameFrame(new MatchGameModel());
	}

}
