package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Detail2 extends Fragment {

    protected Context context;
    Detail detail;
    List<Detail> detailList = new ArrayList<>();
    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private Detail2Adapter detail2Adapter;
    private DatabaseReference mData;

    public static Detail2 newInstace() {
        return new Detail2();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail2, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        linearLayoutManager = new LinearLayoutManager(context);
        detail2Adapter = new Detail2Adapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(detail2Adapter);

        loadData();
    }


    private void loadData() {
        detail = new Detail();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mData = FirebaseDatabase.getInstance().getReference("user").child(user.getUid()).child("barang");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                detail2Adapter.clear();
                detailList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Detail detail = snapshot.getValue(Detail.class);
                    detailList.add(detail);
                }
                detail2Adapter.addAll(detailList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public interface OnFragmentInteractionListener {
    }
}