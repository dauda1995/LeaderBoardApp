package com.example.leaderboardapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.ui.main.PageViewModel;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SubmitActivity extends AppCompatActivity {

    private EditText mFirst;
    private EditText mLast;
    private EditText mLink;
    private EditText mEmail;
    private Button submit;

    private PageViewModel pageViewModel;
    LiveData<Boolean> getResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);


        initialize();


    }

    public void initialize(){
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);

        mFirst = findViewById(R.id.firstname);
        mLast = findViewById(R.id.lastname);
        mLink = findViewById(R.id.githubLink);
        mEmail = findViewById(R.id.email);
        submit = findViewById(R.id.submitBtnRetro);
        submit.setOnClickListener(view ->{
            submit();

        });
    }

    public Boolean validate(){
        if(mFirst.getText().equals(null)){
            mFirst.setError("check");
            return false;
        }else if(mLast.getText().equals(null)){
            mLast.setError("check");
            return false;
        }else if(mEmail.getText().equals(null)){
            mEmail.setError("check");
            return false;
        }else if(mLink.getText().equals(null)){
            mLink.setError("check");
            return false;
        }else{
            mFirst.setError(null);
            mLast.setError(null);
            mLink.setError(null);
            mEmail.setError(null);
            return true;
        }
    }

    public void submit(){
       if(!validate())
           return;
        new SweetAlertDialog(SubmitActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setConfirmText("Yes")
                .setConfirmClickListener(sDialog ->
                {
                    sDialog.dismissWithAnimation();
                    confirmSubmit();

                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }

    private void goToMainActivity() {
        new SweetAlertDialog(SubmitActivity.this)
                .setTitleText("Submission Successful")
                .show();
        finish();
    }

    private void confirmSubmit() {

        String firstname = mFirst.getText().toString();
        String lastname = mLast.getText().toString();
        String link = mLink.getText().toString();
        String email = mEmail.getText().toString();
        RetroModel model = new RetroModel(firstname, lastname, email, link);
        pageViewModel.submitDetails(model);
            if(!pageViewModel.getSubmitResponse().getValue()) {
                new SweetAlertDialog(SubmitActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Submission Unsuccessful")

                        .show();
                return;
            }
            goToMainActivity();


    }


}
