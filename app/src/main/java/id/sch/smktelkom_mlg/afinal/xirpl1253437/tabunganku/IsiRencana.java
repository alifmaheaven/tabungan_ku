package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class IsiRencana extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabase;
    private EditText namaBarang, targetHarga, targetWaktu;
    private TextView hitunganHariTerakhir, hitunganHariAwal;
    private Button inputData, tanggalAwal, tanggalAkhir;
    private DatePickerDialog formatKalender;
    private SimpleDateFormat formatTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_rencana);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        namaBarang = findViewById(R.id.namaBarang);
        targetHarga = findViewById(R.id.targetHarga);
        tanggalAkhir = findViewById(R.id.tanggalAkhir);
        tanggalAwal = findViewById(R.id.tanggalAwal);

        hitunganHariTerakhir = findViewById(R.id.hitunganHariTerakhir);
        hitunganHariAwal = findViewById(R.id.hitunganHariAwal);


        inputData = findViewById(R.id.inputData);

        inputData.setOnClickListener(this);
        tanggalAwal.setOnClickListener(this);
        tanggalAkhir.setOnClickListener(this);

        formatTanggal = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


    }

    private void input() {

        String namabarang = namaBarang.getText().toString().trim();
        String targetharga = targetHarga.getText().toString().trim();
        String tanggalawal = tanggalAwal.getText().toString().trim();
        String tanggalakhir = tanggalAkhir.getText().toString().trim();
        int hitunghariawal = Integer.parseInt(hitunganHariAwal.getText().toString().trim());
        int hitunghariakhir = Integer.parseInt(hitunganHariTerakhir.getText().toString().trim());


        int estimasihari = hitunghariakhir - hitunghariawal;


        String uid = mDatabase.push().getKey();
        Input input = new Input(namabarang, targetharga, tanggalawal, tanggalakhir, estimasihari);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if (user != null) {
            mDatabase.child("user").child(user.getUid()).child("barang").child(uid).setValue(input);
            Toast.makeText(this, "Data tersimpan...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Gagal tersimpan", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == tanggalAwal) {
            tampiltanggalawal();

        }

        if (v == tanggalAkhir) {
            tampiltanggalakhir();
        }

        if (v == inputData) {
            input();
        }


    }

    private void tampiltanggalakhir() {
        Calendar kalender_akhir = Calendar.getInstance();
        formatKalender = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar kalender_akhir = Calendar.getInstance();
                kalender_akhir.set(year, monthOfYear, dayOfMonth);
                int estimasi = kalender_akhir.get(Calendar.DAY_OF_YEAR);


                String hari = Integer.valueOf(estimasi).toString();
                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tanggalAkhir.setText(formatTanggal.format(kalender_akhir.getTime()));


                hitunganHariTerakhir.setText(hari);


            }

        }, kalender_akhir.get(Calendar.YEAR), kalender_akhir.get(Calendar.MONTH), kalender_akhir.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        formatKalender.show();
    }

    private void tampiltanggalawal() {
        Calendar kalender_awal = Calendar.getInstance();
        formatKalender = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar kalender_awal = Calendar.getInstance();
                kalender_awal.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tanggalAwal.setText(formatTanggal.format(kalender_awal.getTime()));
                int estimasi = kalender_awal.get(Calendar.DAY_OF_YEAR);


                String hari = Integer.valueOf(estimasi).toString();

                hitunganHariAwal.setText(hari);
            }

        }, kalender_awal.get(Calendar.YEAR), kalender_awal.get(Calendar.MONTH), kalender_awal.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        formatKalender.show();
    }


}

