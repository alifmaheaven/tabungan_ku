package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BarangListAdapter extends RecyclerView.Adapter<BarangListAdapter.MemberViewHolder> {

    private List<Barang> barangList;

    public BarangListAdapter() {
        barangList = new ArrayList<>();
    }

    private void add(Barang item) {
        barangList.add(item);
        notifyItemInserted(barangList.size() - 1);
    }

    public void addAll(List<Barang> barangList) {
        for (Barang barang : barangList) {
            add(barang);
        }
    }

    public void remove(Barang item) {
        int position = barangList.indexOf(item);
        if (position > -1) {
            barangList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Barang getItem(int position) {
        return barangList.get(position);
    }


    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(final MemberViewHolder holder, int position) {
        final Barang barang = barangList.get(position);

        // holder.memberThumb.setImageResource(travel.getThumb());
        holder.memberUid.setText(barang.getUid());
        holder.memberHarga.setText(barang.getTargetharga());



        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String uid = holder.memberUid.getText().toString();
                String targetharga = holder.memberHarga.getText().toString();
                Intent i = new Intent(view.getContext(), DetailBarangActivity.class);

                i.putExtra("nm", uid);
                i.putExtra("hg", targetharga);
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {
        TextView memberUid;
        TextView memberHarga;


        public MemberViewHolder(final View itemView) {
            super(itemView);
            memberUid = itemView.findViewById(R.id.txtNm);
            memberHarga = itemView.findViewById(R.id.txtHg);
        }
    }
}
