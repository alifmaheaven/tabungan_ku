package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Page1Activity extends AppCompatActivity {

    protected Context context;
    Barang barang;
    List<Barang> barangList = new ArrayList<>();
    RecyclerView.Adapter adapter;
    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private BarangListAdapter barangListAdapter;
    private DatabaseReference mData;
    private DatabaseReference mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        listMember = findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(context);
        barangListAdapter = new BarangListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(barangListAdapter);

        loadData();
    }

    private void loadData() {
        barang = new Barang();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mData = FirebaseDatabase.getInstance().getReference("user").child(user.getUid()).child("barang");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                barangListAdapter.clear();
                barangList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Barang barang = snapshot.getValue(Barang.class);
                    barangList.add(barang);
                }
                barangListAdapter.addAll(barangList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
