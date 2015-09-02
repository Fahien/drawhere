package me.fahien.android.drawhere.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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

	private Paint boxPaint;
	private Paint backgroundPaint;

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

		// Paint the boxes a nice semitransparent red (ARGB)
		boxPaint = new Paint();
		boxPaint.setColor(0x22ff0000);

		// Paint the background off-white
		backgroundPaint = new Paint();
		backgroundPaint.setColor(0xfff8efe0);
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

	/**
	 * Draws the boxes to the screen
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		// Fill the background
		canvas.drawPaint(backgroundPaint);

		for (Box box : boxList) {
			float left = Math.min(box.getOrigin().x, box.getCurrent().x);
			float right = Math.max(box.getOrigin().x, box.getCurrent().x);
			float top = Math.min(box.getOrigin().y, box.getCurrent().y);
			float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);

			canvas.drawRect(left, top, right, bottom, boxPaint);
		}
	}
}
