package com.example.bibaswanpattjoshi.zolostays.db;

import android.app.Application;
import android.content.Context;

import com.example.bibaswanpattjoshi.zolostays.ZoloInterface;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

@Module
public class ApplicationModule {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ZoloInterface.ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ZoloInterface.DatabaseInfo
    String provideDatabaseName() {
        return DATABASE_NAME;
    }

    @Provides
    @ZoloInterface.DatabaseInfo
    Integer provideDatabaseVersion() {
        return DATABASE_VERSION;
    }


}