package com.postitviewedit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    public static final String EXTRA_FNAME = "EXTRA_FNAME";
    public static final String EXTRA_LNAME = "EXTRA_LNAME";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";

    String Fname, Lname, email;
    EditText FNInput, LNInput, emailInput;
    Button okButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        FNInput = (EditText) findViewById(R.id.FNInput);
        LNInput = (EditText) findViewById(R.id.LNInput);
        emailInput = (EditText) findViewById(R.id.emailInput);
        okButton = (Button) findViewById(R.id.okButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateViewActivity();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FNInput.setText("");
                LNInput.setText("");
                emailInput.setText("");
                finish();
            }
        });
    }

    public void updateViewActivity(){
        Fname = FNInput.getText().toString();
        Lname = LNInput.getText().toString();
        email = emailInput.getText().toString();

        Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
        intent.putExtra(EXTRA_FNAME, Fname);
        intent.putExtra(EXTRA_LNAME, Lname);
        intent.putExtra(EXTRA_EMAIL, email);
        startActivity(intent);
    }
}
