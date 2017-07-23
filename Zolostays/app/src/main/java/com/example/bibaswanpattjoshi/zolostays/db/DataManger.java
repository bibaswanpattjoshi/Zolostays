package com.example.bibaswanpattjoshi.zolostays.db;

import android.content.Context;
import android.content.res.Resources;

import com.example.bibaswanpattjoshi.zolostays.ZoloInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Ronit Pattjoshi on 23-07-2017.
 */

public class DataManger {


    @Singleton
    public class DataManager {

        private Context mContext;
        private DBHelper mDbHelper;

        @Inject
        public DataManager(@ZoloInterface.ApplicationContext Context context,
                           DBHelper dbHelper) {
            mContext = context;
            mDbHelper = dbHelper;

        }



        public Long createUser(UserModel user) throws Exception {
            return mDbHelper.addUser(user);

        }


    }
}
