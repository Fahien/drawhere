package me.fahien.android.drawhere.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.fahien.android.drawhere.R;

/**
 * Single Fragment Activity inflates a single fragment-containing layout
 *
 * @author Fahien
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
	protected abstract Fragment createFragment();

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);

		FragmentManager fragmentManager = getFragmentManager();
		// The fragment could be already in the list
		Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			// This code creates and commits a fragment transaction
			fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}