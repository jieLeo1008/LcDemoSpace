package com.lc.model;

import android.support.annotation.Nullable;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.AsyParser;
import com.zcx.helper.http.AsyPost;
import com.zcx.helper.http.AsyPostForm;
import com.zcx.helper.http.note.HttpServer;

import org.jetbrains.annotations.Contract;
import org.json.JSONObject;

/**
 * create by：Benny on 2018/4/13 09:55
 */
@HttpServer(Conn.SERVICE_PATH)
public class BaseAcyPost<T> extends AsyPost<T> {


	public BaseAcyPost(AsyCallBack<T> asyCallBack) {
		super(asyCallBack);
	}

	@Override
	protected T parser(JSONObject object) throws Exception {
		return object.optString("result").equals("200") ? successParser(object) : null;
	}


	private T successParser(JSONObject jsonObject){
		return null;
	}
}
