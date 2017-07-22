package com.example.bibaswanpattjoshi.zolostays;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.bibaswanpattjoshi.zolostays.db.DBHelper;
import com.example.bibaswanpattjoshi.zolostays.db.UserModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ronit Pattjoshi on 22-07-2017.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.phone_number_e_txt)
    EditText phone_number_e_txt;
    @BindView(R.id.email_e_txt)
    EditText email_e_txt;
    @BindView(R.id.name_e_txt)
    EditText name_e_txt;
    @BindView(R.id.password_e_txt)
    EditText password_e_txt;


    private DBHelper databaseHelper;
    private UserModel userModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initDBObject();
    }

    private void initDBObject() {
        databaseHelper = new DBHelper(RegisterActivity.this);
        userModel = new UserModel();
    }

    public void registerClick(View view){
        String number_input = phone_number_e_txt.getText().toString().trim();
        String password_input = password_e_txt.getText().toString().trim();
        String email_input = email_e_txt.getText().toString().trim();
        String name_input = name_e_txt.getText().toString().trim();
        if(number_input == null && number_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_number), Snackbar.LENGTH_LONG).show();
        }else if(email_input == null && email_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_mail), Snackbar.LENGTH_LONG).show();
        }else if(name_input == null && name_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_name), Snackbar.LENGTH_LONG).show();
        }else if(password_input == null && password_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_password), Snackbar.LENGTH_LONG).show();
        }else {


            if (!databaseHelper.checkUser(email_input)) {

                userModel.setName(name_input);
                userModel.setEmail(email_input);
                userModel.setPassword(password_input);
                userModel.setNumber(number_input);

                databaseHelper.addUser(userModel);

                // Snack Bar to show success message that record saved successfully
                Snackbar.make(view, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();


            } else {
                // Snack Bar to show error message that record already exists
                Snackbar.make(view, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
            }
        }
    }
}
