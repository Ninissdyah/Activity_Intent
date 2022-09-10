package com.example.papb_tugas3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText menu;
    Button btnMakanan, btnMinuman;
    TextView jumlahPesanan;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";
    public static final String MESSAGE_EXTRA2 = "MESSAGE_KEY2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnMinuman = findViewById(R.id.btnMinuman);
        jumlahPesanan = findViewById(R.id.jumlahPesanan);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            String jumlah = result.getData().getStringExtra(SecondActivity.REPLY_EXTRA);
                            jumlahPesanan.setText(jumlah);
                        }
                    }
                });

        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class); //menghubungkan dengan halaman kedua
                String message = menu.getText().toString();
                String message2 = btnMakanan.getText().toString();
                intent.putExtra(MESSAGE_EXTRA, message);
                intent.putExtra(MESSAGE_EXTRA2, message2);
//                startActivity(intent); //agar ketika button diklik berpindah ke halaman kedua
                launcher.launch(intent); //untuk mengaktifkan callback
            }
        });

        btnMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class); //menghubungkan dengan halaman kedua
                String message = menu.getText().toString();
                String message2 = btnMinuman.getText().toString();
                intent.putExtra(MESSAGE_EXTRA, message);
                intent.putExtra(MESSAGE_EXTRA2, message2);
//                startActivity(intent); //agar ketika button diklik berpindah ke halaman kedua
                launcher.launch(intent); //untuk mengaktifkan callback
            }


        });
    }
}