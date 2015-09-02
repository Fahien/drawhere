package me.fahien.android.drawhere.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.fahien.android.drawhere.R;

/**
 * Draw Here Fragment
 *
 * @author Fahien
 */
public class DrawHereFragment extends Fragment {

	public static DrawHereFragment newInstance() {
		return new DrawHereFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_draw_here, container, false);
		return view;
	}
}
