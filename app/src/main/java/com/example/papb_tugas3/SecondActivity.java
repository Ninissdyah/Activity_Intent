package com.example.papb_tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView menuMakanan, menuMinuman;
    EditText jumlah;
    Button btnOK;
    public static final String REPLY_EXTRA = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        menuMakanan = findViewById(R.id.menuMakanan);
        menuMinuman = findViewById(R.id.menuMinuman);
        jumlah = findViewById(R.id.jumlah);
        btnOK = findViewById(R.id.btnOK);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        String message2 = intent.getStringExtra(MainActivity.MESSAGE_EXTRA2);
        menuMakanan.setText(message);
        menuMinuman.setText(message2);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String jmlPesanan = jumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA, jmlPesanan);
                setResult(RESULT_OK, intent);
                finish();
            }
        });




    }
}