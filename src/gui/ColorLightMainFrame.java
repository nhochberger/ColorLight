package gui;

import hochberger.utilities.gui.EDTSafeFrame;
import hochberger.utilities.gui.lookandfeel.SetLookAndFeelTo;

import java.awt.Color;

import javax.swing.JPanel;

public class ColorLightMainFrame extends EDTSafeFrame {

	public ColorLightMainFrame(String title) {
		super(title);
	}

	@Override
	protected void buildUI() {
		SetLookAndFeelTo.nimbusLookAndFeel();
		notResizable();
		maximize();
		exitOnClose();
		setContentPane(new JPanel());
		getContentPane().setBackground(Color.WHITE);
	}

	public void changeColorTo(final Color newColor) {
		performBlockingOnEDT(new Runnable() {
			
			@Override
			public void run() {
				getContentPane().setBackground(newColor);
			}
		});
	}
}
