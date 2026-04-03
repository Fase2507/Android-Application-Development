package tr.duzce.edu.bm.bm443android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToAdd;
    private Button btnGoToSub;

    private TextView karsila;
    SharedPreferences shrd;

    private Button btnGoToDiv;
    private EditText editText;

    private Button btnGoToReg;

    private Button btnGoToVal;

    private Button btnGoStartEnd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.requestFocus();

        karsila = findViewById(R.id.karsilama);

        // Kayıtlı verilere erişmek için aynı isimle preferences dosyasını açıyoruz
        shrd = getSharedPreferences("GirisBilgileri", Context.MODE_PRIVATE);

        // Veriyi çekme (Eğer veri yoksa varsayılan olarak boş string döner)
        String kullaniciAdi = shrd.getString("username", "");

        // Karşılama metnini ayarlama
        karsila.setText(String.format("%s  %s", getString(R.string.ho_geldin), kullaniciAdi));



        btnGoToAdd = findViewById(R.id.btnGoToAdd);
        btnGoToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Correct way to create an Intent: use the current Context (this)
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        btnGoToSub = findViewById(R.id.btnGoToSub);
        btnGoToSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        }
        );

        btnGoToDiv = findViewById(R.id.btnGoToDiv);
        btnGoToDiv.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v){
                  Intent intent = new Intent(MainActivity.this, DivActivity.class);
                  startActivity(intent);
              }
          }
        );

        btnGoToReg = findViewById(R.id.btnGoToReg);
        btnGoToReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

        });

        btnGoStartEnd = findViewById(R.id.btnStartEnd);
        btnGoStartEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToggleBtnActivity.class);
                startActivity(intent);
            }
        });

        btnGoToVal = findViewById(R.id.btnGoToVal);
        btnGoToVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ValidationActivity.class);
                startActivity(intent);
            }
        });
    }

}
