package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailBarangActivity extends AppCompatActivity {
    TextView tv;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        initComp();
        Intent i = getIntent();
        tv.setText(i.getStringExtra("nm"));

    }

    private void initComp() {
        tv = findViewById(R.id.tv);
        mDatabase = FirebaseDatabase.getInstance().getReference("Posts");
    }

}
