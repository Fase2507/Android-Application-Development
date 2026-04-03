package tr.duzce.edu.bm.bm443android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fab);
        initComponenets();
        registerEventHandlers();

    }

    private void initComponenets(){
        fab = findViewById(R.id.floatingActionButton);
    }

    private void registerEventHandlers (){
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FabActivity.this,"tetiklendi",Toast.LENGTH_SHORT).show();
            }
        });
    }
}