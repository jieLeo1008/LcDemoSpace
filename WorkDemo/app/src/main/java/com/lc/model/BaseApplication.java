package com.lc.model;

import android.content.Context;

import com.zcx.helper.app.AppApplication;
import com.zcx.helper.app.AppInit;

import iknow.android.utils.BaseUtils;

/**
 * Created by Benny on 2018/3/21.
 */
@AppInit(name = "model",log = true,width = 1080)
public class BaseApplication extends AppApplication {
    public static Context context;

    public static BasePreferences basePreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        basePreferences =new BasePreferences("model");


        /**
         * 工具类
         */
        BaseUtils.init(this);
    }
}
