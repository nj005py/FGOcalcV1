package org.phantancy.fgocalc.adapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.phantancy.fgocalc.R;
import org.phantancy.fgocalc.item.RemoteVersionItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateAdapter extends ListAdapter<RemoteVersionItem.ContentBean, UpdateAdapter.ViewHolder> {
    public static DiffUtil.ItemCallback<RemoteVersionItem.ContentBean> diff = new DiffUtil.ItemCallback<RemoteVersionItem.ContentBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull RemoteVersionItem.ContentBean older, @NonNull RemoteVersionItem.ContentBean newer) {
            return older.getItem().equals(newer.getItem());
        }

        @Override
        public boolean areContentsTheSame(@NonNull RemoteVersionItem.ContentBean older, @NonNull RemoteVersionItem.ContentBean newer) {
            return older.getItem().equals(newer.getItem());
        }
    };


    public UpdateAdapter() {
        super(diff);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View x = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_update, viewGroup, false);
        return new ViewHolder(x);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(getItem(i));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ua_tv_content)
        TextView uaTvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bindView(RemoteVersionItem.ContentBean x) {
            uaTvContent.setText(x.getItem());
        }
    }
}
