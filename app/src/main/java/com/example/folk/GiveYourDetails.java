package com.example.folk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GiveYourDetails extends AppCompatActivity {
    Button login;


    EditText folk_id_edit_text ;

   //    String[] names_of_folk_guides = {"ABCD","EFGH","IJKL","MNOP"};
  //  int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_your_details);



        folk_id_edit_text = findViewById(R.id.folk_id);

        login = findViewById(R.id.login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent generate_qr_intent = new Intent(GiveYourDetails.this,GenerateQRActivity.class);
                generate_qr_intent.putExtra("folk_id",folk_id_edit_text.getText().toString());
                startActivity(generate_qr_intent);
            }
        });


    }
}
