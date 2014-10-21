package controller;

import java.awt.Color;

import hochberger.utilities.eventbus.Event;

public class ChangeColorEvent implements Event {

	private final Color color;
	
	public ChangeColorEvent(Color color) {
		super();
		this.color = color;
	}

	public Color getNewColor() {
		return color;
	}
	
	@Override
	public void performEvent() {
		// TODO Auto-generated method stub
	}
}
