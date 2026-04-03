package tr.duzce.edu.bm.bm443android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ToggleBtnActivity extends AppCompatActivity {

    private ToggleButton btnStartEnd;
    private FloatingActionButton btnFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toggle_btn);

        // Handle window insets for Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
                } else {
                    txt = "Kayit basladi";
                }
                Toast.makeText(ToggleBtnActivity.this, txt, Toast.LENGTH_SHORT).show();
            }
        });

        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToggleBtnActivity.this, FabActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        btnStartEnd = findViewById(R.id.btnStartEnd);
        btnFab = findViewById(R.id.floatingActionButton);
    }
}