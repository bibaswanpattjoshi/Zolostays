package com.example.bibaswanpattjoshi.zolostays.db;

import android.app.Application;
import android.content.Context;

import com.example.bibaswanpattjoshi.zolostays.ZoloApplication;
import com.example.bibaswanpattjoshi.zolostays.ZoloInterface;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ZoloApplication demoApplication);

    @ZoloInterface.ApplicationContext
    Context getContext();

    Application getApplication();

    DataManger.DataManager getDataManager();



    DBHelper getDbHelper();

}
