package com.lc.model;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurfaceActivity extends AppCompatActivity {

	@BindView(R.id.surface_view)
	SurfaceView surfaceView;
	@BindView(R.id.fla_btn)
	FloatingActionButton flaBtn;


	private android.hardware.Camera camera ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surface);
		ButterKnife.bind(this);


		camera = Camera.open();

		try {
			camera.setPreviewDisplay(surfaceView.getHolder());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
