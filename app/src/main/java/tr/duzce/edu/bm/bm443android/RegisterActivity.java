package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

    private AutoCompleteTextView txtBolum;

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
        txtBolum = findViewById(R.id.txtBolum);
        txt = findViewById(R.id.kayitFormu);
        input = findViewById(R.id.kayitText);
        btnKaydet = findViewById(R.id.kayitButon);
        String[] bolumler = getResources().getStringArray(R.array.bolumler);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                bolumler
        );

        // 3. Set the adapter to the AutoCompleteTextView
        txtBolum.setAdapter(adapter);

        // Optional: Set threshold to 1 so suggestions appear after typing 1 character
        txtBolum.setThreshold(1);
    }
}