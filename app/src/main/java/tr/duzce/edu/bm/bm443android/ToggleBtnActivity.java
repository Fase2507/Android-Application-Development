package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ToggleBtnActivity extends AppCompatActivity {

    private ToggleButton btnStartEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toggle_btn);
        initComponents();
        registerEventHandlers();

    }

    private void registerEventHandlers() {
        btnStartEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = "";
                if (btnStartEnd.isChecked()) {
                    txt = "Kayit bitti";
                }
                else{
                    txt = "Kayit basladi";
                }

                Toast.makeText(ToggleBtnActivity.this, txt, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void initComponents(){
        btnStartEnd = findViewById(R.id.btnStartEnd);
    }
}