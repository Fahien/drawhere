package me.fahien.android.drawhere.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.fahien.android.drawhere.model.Box;

/**
 * Box Drawing View is a simple custom view
 *
 * @author Fahien
 */
public class BoxDrawingView extends View {
	private static final String TAG = BoxDrawingView.class.getSimpleName();

	private Box currentBox;

	/**
	 * When user touches the view, a new box will be
	 * created and added to the list of existing boxes
	 */
	private List<Box> boxList;

	/**
	 * Used when creating the view in code
	 */
	public BoxDrawingView(Context context) {
		this(context, null);
	}

	/**
	 * Used when inflating the view from XML
	 */
	public BoxDrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		boxList = new ArrayList<>();
	}

	/**
	 * Logs a message for each of the four different actions
	 */
	@Override
	public boolean onTouchEvent(@NonNull MotionEvent event) {
		PointF current = new PointF(event.getX(), event.getY());

		String action;

		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				action = "ACTION_DOWN";
				// Reset drawing state
				currentBox = new Box(current);
				boxList.add(currentBox);
				break;
			case MotionEvent.ACTION_MOVE:
				action = "ACTION_MOVE";
				if (currentBox != null) {
					currentBox.setCurrent(current);
					// forces the view to redraw itself
					invalidate();
				}
				break;
			case MotionEvent.ACTION_UP:
				action = "ACTION_UP";
				currentBox = null;
				break;
			case MotionEvent.ACTION_CANCEL:
				action = "ACTION_CANCEL";
				currentBox = null;
				break;
			default:
				action = "ACTION_UNKNOWN";
				break;
		}

		Log.i(TAG, action + " at x = " + current.x + ", y = " + current.y);

		return true;
	}
}
