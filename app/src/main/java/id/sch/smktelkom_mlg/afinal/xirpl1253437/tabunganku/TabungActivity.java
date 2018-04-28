package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class TabungActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabase;
    private TextInputLayout iUang;
    private Button tabung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        iUang = findViewById(R.id.iUang);

        tabung = findViewById(R.id.tabung);
        tabung.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == tabung) {
            input();
        }

    }

    private void input() {
        String iuang = iUang.getEditText().getText().toString();


        // Ini tanggal
        Calendar kalender = Calendar.getInstance();

        int hari, bulan, tahun;
        hari = kalender.get(Calendar.DATE);
        bulan = kalender.get(Calendar.MONTH);
        tahun = kalender.get(Calendar.YEAR);

        String tanggal = hari + "-" + bulan + "-" + tahun;

        String uid = mDatabase.push().getKey();

        InputCicilan input = new InputCicilan(iuang, tanggal);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if (user != null) {
            mDatabase.child("user").child(user.getUid()).child("barang").child(uid).child("kampung").setValue(input);
            Toast.makeText(this, "Data tersimpan...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Gagal tersimpan", Toast.LENGTH_LONG).show();
        }


    }
}
