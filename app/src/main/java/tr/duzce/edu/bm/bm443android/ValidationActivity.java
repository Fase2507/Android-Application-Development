package tr.duzce.edu.bm.bm443android;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ValidationActivity extends AppCompatActivity {

    private EditText txtAd,txtSoy;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validation);
        initComponents();
        registerEventHandler();
    }


    private void initComponents() {
        txtAd = findViewById(R.id.txtAd);
        txtSoy = findViewById(R.id.txtSoy);
        btn = findViewById(R.id.btnKaydet);
    }

    private void registerEventHandler() {
        btnKaydet_onClick();

        txtAd.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             if(charSequence.length()<3){
                 Resources resources = ValidationActivity.this.getResources();
                 Drawable errorImage = ContextCompat.getDrawable(ValidationActivity.this, R.drawable.err);
                 int yukseklik = errorImage.getIntrinsicHeight();
                 int genislik = errorImage.getIntrinsicWidth();
                 errorImage.setBounds(0, 0, genislik, yukseklik);
                 txtAd.setError("Hata mesajı", errorImage);
             } else {
                 txtAd.setError(null);
             }
            }

        });

        txtSoy.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()<3){
                    Resources resources = ValidationActivity.this.getResources();
                    Drawable errorImage = ContextCompat.getDrawable(ValidationActivity.this, R.drawable.err);
                    int yukseklik = errorImage.getIntrinsicHeight();
                    int genislik = errorImage.getIntrinsicWidth();
                    errorImage.setBounds(0, 0, genislik, yukseklik);
                    txtSoy.setError("Hata mesajı", errorImage);
                } else {
                    txtSoy.setError(null);
                }
            }

        });
    }

    private void btnKaydet_onClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ValidationActivity.this, "Kaydetme işlemi başarılı",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
