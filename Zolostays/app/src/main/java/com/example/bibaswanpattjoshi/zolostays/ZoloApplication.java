package com.example.bibaswanpattjoshi.zolostays;

import android.app.Application;
import android.content.Context;

import com.example.bibaswanpattjoshi.zolostays.db.ApplicationComponent;
import com.example.bibaswanpattjoshi.zolostays.db.ApplicationModule;
import com.example.bibaswanpattjoshi.zolostays.db.DataManger;

import javax.inject.Inject;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

public class ZoloApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManger dataManager;

    public static ZoloApplication get(Context context) {
        return (ZoloApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
