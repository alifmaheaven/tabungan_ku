package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Detail2Adapter extends RecyclerView.Adapter<Detail2Adapter.MyViewHolder> {

    private List<Detail> detailList;

    public Detail2Adapter() {
        detailList = new ArrayList<>();
    }

    private void add(Detail item) {
        detailList.add(item);
        notifyItemInserted(detailList.size() - 1);
    }

    public void addAll(List<Detail> detailList) {
        for (Detail detail : detailList) {
            add(detail);
        }
    }

    public void remove(Detail item) {
        int position = detailList.indexOf(item);
        if (position > -1) {
            detailList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Detail getItem(int position) {
        return detailList.get(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail, parent, false);
        Detail2Adapter.MyViewHolder memberViewHolder = new MyViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Detail detail = detailList.get(position);

        // holder.memberThumb.setImageResource(travel.getThumb());
        holder.memberIuang.setText(detail.getIuang());
        holder.memberTanggal.setText(detail.getTanggal());

    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView memberIuang;
        TextView memberTanggal;

        public MyViewHolder(View itemView) {
            super(itemView);
            memberIuang = itemView.findViewById(R.id.txtRp);
            memberTanggal = itemView.findViewById(R.id.txtTgl);
        }
    }
}
