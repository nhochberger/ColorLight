package controller;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import hochberger.utilities.application.Lifecycle;
import hochberger.utilities.eventbus.EventBus;

public class ColorChangeTaskManager implements Lifecycle {
	
	private final EventBus eventBus;
	private final Timer timer;
	private float hue;
	
	public ColorChangeTaskManager(EventBus eventBus) {
		super();
		this.eventBus = eventBus;
		this.timer = new Timer();
		this.hue = 0.0f;
	}

	@Override
	public void start() {
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				hue += 0.003f;
				hue %= 1;
				Color color = Color.getHSBColor(hue, 0.9f, 1f);
				ColorChangeTaskManager.this.eventBus.publish(new ChangeColorEvent(color));
				ColorLightApplication.getLogger().info("new color is " + color);
			}
		}, 0, 100);
	}

	@Override
	public void stop() {
		timer.cancel();
	}
}
