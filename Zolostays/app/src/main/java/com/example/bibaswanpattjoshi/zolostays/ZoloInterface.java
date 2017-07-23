package com.example.bibaswanpattjoshi.zolostays;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

public interface ZoloInterface {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ActivityContext {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationContext {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DatabaseInfo {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }
}

