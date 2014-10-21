package controller;

import gui.GUI;
import hochberger.utilities.application.ApplicationProperties;
import hochberger.utilities.application.BasicLoggedApplication;
import hochberger.utilities.eventbus.EventBus;
import hochberger.utilities.eventbus.SimpleEventBus;

public class ColorLightApplication extends BasicLoggedApplication {
	
	private final static EventBus EVENT_BUS = new SimpleEventBus();
	
	private final ColorChangeTaskManager taskManager;
	
	public static void main(String... args) {
		setUpLoggingServices(ColorLightApplication.class);
		try {
			ApplicationProperties applicationProperties = new ApplicationProperties();
			GUI gui = new GUI(applicationProperties);
			gui.activateGUI();
			eventBus().register(gui, ChangeColorEvent.class);
			ColorLightApplication application = new ColorLightApplication();
			application.start();
		} catch (Exception e) {
			getLogger().fatal("Error while starting application. Shutting down.", e);
		}
	}
	
	public ColorLightApplication() {
		super();
		this.taskManager = new ColorChangeTaskManager(eventBus());
	}

	@Override
	public void start() {
		taskManager.start();
	}

	@Override
	public void stop() {
		taskManager.stop();
	}

	private static EventBus eventBus() {
		return ColorLightApplication.EVENT_BUS;
	}
}
