package gui;

import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.eventbus.Event;
import hochberger.utilities.eventbus.EventReceiver;
import controller.ChangeColorEvent;

public class GUI implements EventReceiver {
	private final ColorLightMainFrame frame;

	public GUI(ApplicationProperties applicationProperties) {
		super();
		this.frame = new ColorLightMainFrame(applicationProperties.title());
	}

	public void activateGUI() {
		this.frame.show();
	}

	@Override
	public <TYPE extends Event> void receive(TYPE event) {
		if (event instanceof ChangeColorEvent) {
			ChangeColorEvent changeColorEvent = (ChangeColorEvent) event;
			frame.changeColorTo(changeColorEvent.getNewColor());
		}
	}
}
