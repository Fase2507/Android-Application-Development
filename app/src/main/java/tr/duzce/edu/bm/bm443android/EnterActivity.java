package tr.duzce.edu.bm.bm443android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EnterActivity extends AppCompatActivity {

    private EditText editKullaniciAdi, editSifre;

    private Button btn;

    SharedPreferences shrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter);
        initComponents();
        registerEventHandler();
    }

    private void initComponents() {
        editKullaniciAdi = findViewById(R.id.editKullaniciAdi);
        editSifre = findViewById(R.id.editSifre);
        btn = findViewById(R.id.btnGiris);
        shrd = getSharedPreferences("GirisBilgileri", Context.MODE_PRIVATE);
        if (shrd.contains("username")) {
            yonlendirme();
        }
    }

    private void registerEventHandler(){
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String ad = editKullaniciAdi.getText().toString();
                String sifre = editSifre.getText().toString();

                if(ad.equals("fatih") && sifre.equals("1234")){
                    // Bilgileri SharedPreferences içine kaydetme
                    SharedPreferences.Editor editor = shrd.edit();
                    editor.putString("username", ad);
                    editor.putString("password", sifre);
                    editor.apply(); // Değişiklikleri onayla

                    yonlendirme();
                }
                else{
                    Toast.makeText(EnterActivity.this, "hatali kullanıcı adı veya şifre", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void yonlendirme(){
        Intent intent = new Intent(EnterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}