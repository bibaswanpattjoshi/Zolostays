package com.example.bibaswanpattjoshi.zolostays.db;

import com.example.bibaswanpattjoshi.zolostays.MainActivity;
import com.example.bibaswanpattjoshi.zolostays.ZoloInterface;

import dagger.Component;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

@ZoloInterface.PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
