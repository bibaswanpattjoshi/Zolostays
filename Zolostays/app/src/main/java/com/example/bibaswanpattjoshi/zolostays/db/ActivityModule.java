package com.example.bibaswanpattjoshi.zolostays.db;

import android.app.Activity;
import android.content.Context;

import com.example.bibaswanpattjoshi.zolostays.ZoloInterface;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ZoloInterface.ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
