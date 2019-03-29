package com.course.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "data";

    public static final String FNAME_KEY = "firstName";
    public static final String LNAME_KEY = "lastName";
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";
    public static final String TANDC_KEY = "t&c";


    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private CheckBox mTermsAndCOnditionsCheckBox;
    private Button mShowButton;
    private Button mSaveButton;
    private Button mClearButton;
    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
     mFirstNameEditText = findViewById(R.id.edittext_first_name);
     mLastNameEditText = findViewById(R.id.edittext_last_name);
     mEmailEditText = findViewById(R.id.edittext_email);
     mPasswordEditText = findViewById(R.id.edittext_password);
     mTermsAndCOnditionsCheckBox = findViewById(R.id.check_box_terms_and_conditions);
     mShowButton = findViewById(R.id.button_show);
     mSaveButton = findViewById(R.id.button_save);
     mClearButton = findViewById(R.id.button_clear);
     mContentTextView = findViewById(R.id.textview_content);
    }
    public void save(View view){
        SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor
                .putString(FNAME_KEY,getFirstName())
                .putString(LNAME_KEY,getLastName())
                .putString(EMAIL_KEY,getEmail())
                .putString(PASSWORD_KEY,getPassword())
                .putBoolean(TANDC_KEY,getTermsAndConditions())
                .apply();

    }
    public void show(View view){
        SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
      String firstName = preferences.getString(FNAME_KEY,null);
      String lastName = preferences.getString(LNAME_KEY,null);
      String email = preferences.getString(EMAIL_KEY,null);
      String password = preferences.getString(PASSWORD_KEY,null);
      Boolean tandc = preferences.getBoolean(TANDC_KEY,false);
      mContentTextView.setText("");
        if(firstName != null)
      mContentTextView.append(firstName +'\n');
        if(lastName != null)
      mContentTextView.append(lastName + '\n');
        if(email != null)
      mContentTextView.append(email + '\n');
        if(password != null)
      mContentTextView.append(password + '\n');
      mContentTextView.append(tandc.toString() + '\n');
    }
    public void clear(View view){
      SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
      preferences.edit().clear().apply();
    }
    public String getFirstName(){
        return mFirstNameEditText.getText().toString();
    }
    public String getLastName(){
        return mLastNameEditText.getText().toString();
    }
    public String getEmail(){
        return mEmailEditText.getText().toString();
    }
    public String getPassword(){
        return mPasswordEditText.getText().toString();
    }
    public boolean getTermsAndConditions(){
        return mTermsAndCOnditionsCheckBox.isChecked();
    }

}
