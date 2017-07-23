package com.example.bibaswanpattjoshi.zolostays;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bibaswanpattjoshi.zolostays.db.ActivityComponent;
import com.example.bibaswanpattjoshi.zolostays.db.ActivityModule;
import com.example.bibaswanpattjoshi.zolostays.db.DBHelper;
import com.example.bibaswanpattjoshi.zolostays.db.DataManger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.internal.DaggerCollections;


public class MainActivity extends AppCompatActivity {
  @BindView(R.id.phone_number_e_txt)
  TextInputEditText phone_number_e_txt;
    @BindView(R.id.password_e_txt)
    TextInputEditText password_e_txt;



    private DBHelper databaseHelper;
    private ActivityComponent activityComponent;
    @Inject
    DataManger.DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDBObject();
        getActivityComponent().inject(this);

    }

    public ActivityComponent getActivityComponent() {

        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(ZoloApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    private void initDBObject() {
        databaseHelper = new DBHelper(MainActivity.this);
    }


    public void crtAccountClick(View view){
        navigateToPage(RegisterActivity.class);
    }
    public void forgotPswdClick(View view){
        navigateToPage(ForgotPasswordActivity.class);
    }
    public void loginClick(View view){
        String number_input = phone_number_e_txt.getText().toString();
        String password_input = password_e_txt.getText().toString();
        if(number_input == null && number_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_number), Snackbar.LENGTH_LONG).show();
        }else if(password_input == null && password_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_password), Snackbar.LENGTH_LONG).show();
        }else {
//


            if (databaseHelper.checkUser(number_input
                    , password_input)) {

                navigateToPage(RegisterActivity.class);


            } else {
                // Snack Bar to show success message that record is wrong
                Snackbar.make(view, getString(R.string.error_valid_credential), Snackbar.LENGTH_LONG).show();
            }
        }
    }
    public void navigateToPage(Class activityClass){
        Intent intent = new Intent(MainActivity.this,activityClass);
        startActivity(intent);
    }


}
