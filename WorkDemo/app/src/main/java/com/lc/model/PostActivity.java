package com.lc.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zcx.helper.http.AsyCallBack;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

	String filepath="/storage/emulated/0/bluetooth/1522480674658.mp4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);

		findViewById(R.id.btn_01).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_01:
				new PostVideo(new AsyCallBack<PostVideo.VideoInfo>(){
					@Override
					public void onSuccess(String toast, int type, PostVideo.VideoInfo videoInfo) throws Exception {
						super.onSuccess(toast, type, videoInfo);

					}
				}).execute(true);
				break;
		}
	}


	public  byte[] file2byte(String filePath)
	{
		byte[] buffer = null;
		try
		{
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1)
			{
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return buffer;
	}
}
