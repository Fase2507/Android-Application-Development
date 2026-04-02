package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView txt;

    private EditText input;
    private int sayac;
    private Button btnKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        initComponents();
        registerEventHandlers();

    }

    private void registerEventHandlers() {
        btnKaydet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                sayac++;
                input.setText(getString(R.string.click_count_msg, sayac));
           }
        });
    }

    private void initComponents(){
        txt = findViewById(R.id.kayitFormu);
        input = findViewById(R.id.kayitText);
        btnKaydet = findViewById(R.id.kayitButon);
    }
}