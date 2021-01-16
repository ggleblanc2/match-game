package com.ggl.match.game.controller;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class SelectionRunnable implements Runnable {
	
	private JButton button1, button2;

	public SelectionRunnable(JButton button1, JButton button2) {
		this.button1 = button1;
		this.button2 = button2;
	}

	@Override
	public void run() {
		sleep(3000L);
		enableButton(button1);
		enableButton(button2);
	}
	
	private void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void enableButton(JButton button) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				button.setEnabled(true);
			}
		});
	}

}
