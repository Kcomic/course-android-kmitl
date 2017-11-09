package com.example.student.roomdemo.Adapter.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.student.roomdemo.R;

/**
 * Created by Kcomic on 9/11/2560.
 */

public class LedgerInfoHolder extends RecyclerView.ViewHolder {

    public TextView type, detail, value;

    public LedgerInfoHolder(View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.type);
        detail = itemView.findViewById(R.id.detail);
        value = itemView.findViewById(R.id.value);
    }
}
