package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DivActivity extends AppCompatActivity {

    private EditText txtSayi1, txtSayi2;
    private Button btnBol;

    private TextView lblSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_div);
        initComponents();
        registerEventHandlers();
    }

    private void registerEventHandlers(){
        btnBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1 = txtSayi1.getText().toString();
                String input2 = txtSayi2.getText().toString();
                if (input1.isEmpty() || input2.isEmpty())
                    lblSonuc.setText(R.string.error_invalid_input);
                try {
                    int sayi1 = Integer.parseInt(input1);
                    int sayi2 = Integer.parseInt(input2);
                    int bolum = sayi1 / sayi2;
                    lblSonuc.setText(getString(R.string.sonuc_label, bolum));
                    lblSonuc.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    lblSonuc.setText(R.string.error_invalid_input);
                }


            }
        });
    }
    private void initComponents(){
        txtSayi1 = findViewById(R.id.txtSayi1);
        txtSayi2 = findViewById(R.id.txtSayi2);
        btnBol = findViewById(R.id.bol);
        lblSonuc = findViewById(R.id.lblSonuc);
    }
}