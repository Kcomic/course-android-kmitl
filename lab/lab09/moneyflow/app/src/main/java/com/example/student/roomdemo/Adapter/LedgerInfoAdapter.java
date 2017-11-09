package com.example.student.roomdemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.roomdemo.Adapter.Holder.LedgerInfoHolder;
import com.example.student.roomdemo.Model.LedgerInfo;
import com.example.student.roomdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kcomic on 9/11/2560.
 */

public class LedgerInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<LedgerInfo> ledgerInfoList;
    private LedgerInfoAdapterListener listener;
    public LedgerInfoAdapter(Context mContext, LedgerInfoAdapterListener listener){
        this.mContext = mContext;
        this.listener = listener;
        ledgerInfoList = new ArrayList<>();
    }
    public interface LedgerInfoAdapterListener {

        public void onItemTouched(LedgerInfo ledgerInfo);
    }
    public void setLedgerInfoList(List<LedgerInfo> ledgerInfoList) {
        this.ledgerInfoList = ledgerInfoList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_ledger, parent, false);
        LedgerInfoHolder ledgerInfoHolder = new LedgerInfoHolder(view);

        return ledgerInfoHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((LedgerInfoHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemTouched(ledgerInfoList.get(position));
            }
        });
        ((LedgerInfoHolder)holder).detail.setText(ledgerInfoList.get(position).getLedgerList());
        ((LedgerInfoHolder)holder).type.setText(ledgerInfoList.get(position).getType());
        ((LedgerInfoHolder)holder).value.setText(ledgerInfoList.get(position).getAmount()+"");
        if(position%2 != 0){
            ((LedgerInfoHolder)holder).itemView.setBackgroundColor(Color.parseColor("#DCDCDC"));
        }
    }

    @Override
    public int getItemCount() {
        return ledgerInfoList.size();
    }

}
