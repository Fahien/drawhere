package me.fahien.android.drawhere.model;

import android.graphics.PointF;

/**
 * Box being draw on the screen
 *
 * @author Fahien
 */
public class Box {
	private PointF origin;
	private PointF current;

	public Box(PointF origin) {
		this.origin = origin;
		current = origin;
	}

	public PointF getCurrent() {
		return current;
	}

	public void setCurrent(PointF current) {
		this.current = current;
	}

	public PointF getOrigin() {
		return origin;
	}
}
