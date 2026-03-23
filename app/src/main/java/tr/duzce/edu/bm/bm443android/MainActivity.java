package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final String TAG = MainActivity.class.getName();
    private EditText txtSayi1, txtSayi2;
    private Button btnTopla;
    private TextView lblSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        registerEventHandlers();
        Log.i(TAG, "onCreate() metodu calisti.");
    }

    private void registerEventHandlers() {
        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = txtSayi1.getText().toString();
                String input2 = txtSayi2.getText().toString();

                if (input1.isEmpty() || input2.isEmpty()) {
                    lblSonuc.setText(R.string.error_invalid_input);
                    return;
                }

                try {
                    int sayi1 = Integer.parseInt(input1);
                    int sayi2 = Integer.parseInt(input2);
                    int toplam = sayi1 + sayi2;
                    lblSonuc.setText(getString(R.string.sonuc_label, toplam));
                } catch (NumberFormatException e) {
                    lblSonuc.setText(R.string.error_invalid_input);
                }
            }
        });
    }

    private void initComponents() {
        txtSayi1 = findViewById(R.id.txtSayi1);
        txtSayi2 = findViewById(R.id.txtSayi2);
        btnTopla = findViewById(R.id.tpla);
        lblSonuc = findViewById(R.id.lblSonuc);
    }
}
