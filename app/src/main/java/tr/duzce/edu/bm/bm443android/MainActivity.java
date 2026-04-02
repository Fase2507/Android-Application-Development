package tr.duzce.edu.bm.bm443android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToAdd;
    private Button btnGoToSub;

    private Button btnGoToDiv;

    private Button btnGoToReg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

}
