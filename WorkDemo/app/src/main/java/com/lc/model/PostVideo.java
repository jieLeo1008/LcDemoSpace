package com.lc.model;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.note.HttpInlet;

import org.json.JSONObject;

import java.io.File;

/**
 * create by：Benny on 2018/4/13 10:42
 */
@HttpInlet(Conn.TASK)
public class PostVideo extends BaseAcyPost<PostVideo.VideoInfo> {


	public File img;

	public PostVideo setImg(File img) {
		this.img = img;
		return this;
	}

	public PostVideo(AsyCallBack<VideoInfo> asyCallBack) {
		super(asyCallBack);
	}

	@Override
	protected VideoInfo parser(JSONObject object) throws Exception {
		return new VideoInfo();
	}

	public class VideoInfo{
		private String success;
	}
}
