package me.fahien.android.drawhere.activity;

import android.app.Fragment;

import me.fahien.android.drawhere.fragment.DrawHereFragment;

/**
 * Draw Here Activity
 *
 * @author Fahien
 */
public class DrawHereActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		return DrawHereFragment.newInstance();
	}
}
