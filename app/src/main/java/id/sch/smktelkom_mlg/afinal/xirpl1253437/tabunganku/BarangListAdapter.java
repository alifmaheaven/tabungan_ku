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


        holder.memberNama.setText(barang.getNamabarang());
        holder.memberHarga.setText(barang.getTargetharga());
        holder.memberTanggalAkhir.setText(barang.getTanggalakhir());
        holder.memberTanggalAwal.setText(barang.getTanggalawal());
        String estimasi = String.valueOf(barang.getEstimasihari());
        holder.memberEstimasi.setText(estimasi);
        holder.memberUid.setText(barang.getUid());




        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String uid = holder.memberUid.getText().toString();
                String targetharga = holder.memberHarga.getText().toString();
                String namabarang = holder.memberNama.getText().toString();
                String tanggalawal = holder.memberTanggalAwal.getText().toString();
                String tanggalakhir = holder.memberTanggalAkhir.getText().toString();
                String estimasi = holder.memberEstimasi.getText().toString();

                Intent i = new Intent(view.getContext(), DetailBarangActivity.class);

                i.putExtra("nm", namabarang);
                i.putExtra("es", estimasi);
                i.putExtra("taw", tanggalawal);
                i.putExtra("tak", tanggalakhir);
                i.putExtra("id", uid);
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

        TextView memberNama;
        TextView memberHarga;
        TextView memberTanggalAwal;
        TextView memberTanggalAkhir;
        TextView memberEstimasi;
        TextView memberUid;

        public MemberViewHolder(final View itemView) {
            super(itemView);

            memberNama = itemView.findViewById(R.id.txtNm);
            memberHarga = itemView.findViewById(R.id.txtHg);
            memberTanggalAwal = itemView.findViewById(R.id.txtAw);
            memberTanggalAkhir = itemView.findViewById(R.id.txtAk);
            memberEstimasi = itemView.findViewById(R.id.txtEs);
            memberUid = itemView.findViewById(R.id.txtId);

        }
    }
}
