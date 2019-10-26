package com.postitviewedit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ViewActivity extends AppCompatActivity {
    public static final String EXTRA_FNAME = "EXTRA_FNAME";
    public static final String EXTRA_LNAME = "EXTRA_LNAME";
    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";

    String Fname, Lname, email;
    TextView FNInput, LNInput, emailInput;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        FNInput = (TextView) findViewById(R.id.FNInput);
        LNInput = (TextView) findViewById(R.id.LNInput);
        emailInput = (TextView) findViewById(R.id.emailInput);

        editButton = (Button) findViewById(R.id.okButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditActivity();
            }
        });

        receiveUpdates();
    }
    public void openEditActivity(){
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

    public void receiveUpdates(){
        Intent intent = getIntent();
        Fname = intent.getStringExtra("EXTRA_FNAME");
        Lname = intent.getStringExtra("EXTRA_LNAME");
        email = intent.getStringExtra("EXTRA_EMAIL");

        FNInput.setText(Fname);
        LNInput.setText(Lname);
        emailInput.setText(email);

    }
}

/*
2: "Post-It"
    Create a new application with two Activities: ViewActivity and EditActivity

    ViewActivity should have an "edit" Button that starts the EditActivity
    ViewActivity should have a TextView that is initially empty - after having edited something
    the latest data entry from the EditActivity should be in this TextField

    EditActivity should have an EditText input field where the user can type some text
    and a button called "OK", which then sends this data back to the first Activity
    EditActivity should also have a "Cancel" button that takes the user back but does not update
    the TextView in ViewActivity
 */