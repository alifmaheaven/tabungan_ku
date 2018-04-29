package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailBarangActivity extends AppCompatActivity {
    TextView tv;
    DatabaseReference mDatabase;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        initComp();
        Intent i = getIntent();
        tv.setText(i.getStringExtra("idbarang"));

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailBarangActivity.this, TabungActivity.class);

                i.putExtra("idbarang", tv.getText());

                startActivity(i);
            }
        });

    }

    private void initComp() {
        tv = findViewById(R.id.tv);
        mDatabase = FirebaseDatabase.getInstance().getReference("Posts");
    }

}
