package com.example.bibaswanpattjoshi.zolostays;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ronit Pattjoshi on 22-07-2017.
 */

public class ForgotPasswordActivity extends AppCompatActivity {
    @BindView(R.id.phone_number_e_txt)
    EditText phone_number_e_txt;
    @BindView(R.id.email_e_txt)
    EditText email_e_txt;
    @BindView(R.id.name_e_txt)
    EditText name_e_txt;
    @BindView(R.id.password_e_txt)
    EditText password_e_txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgot);
        ButterKnife.bind(this);
    }
    public void resetPswdClick(View view){
        String number_input = phone_number_e_txt.getText().toString().trim();
        if(number_input == null && number_input.length() == 0){
            Snackbar.make(view, getString(R.string.enter_number), Snackbar.LENGTH_LONG).show();
        }else{
            Snackbar.make(view, getString(R.string.otp_check), Snackbar.LENGTH_LONG).show();
        }
    }

}
