package org.phantancy.fgocalc.adapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.phantancy.fgocalc.R;
import org.phantancy.fgocalc.entity.CharacterEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterOptionAdapter extends ListAdapter<CharacterEntity.OptionEntity, CharacterOptionAdapter.ViewHolder> {
    static @NonNull
    DiffUtil.ItemCallback<CharacterEntity.OptionEntity> diffCallback = new DiffUtil.ItemCallback<CharacterEntity.OptionEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull CharacterEntity.OptionEntity o, @NonNull CharacterEntity.OptionEntity n) {
            return o == n;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CharacterEntity.OptionEntity o, @NonNull CharacterEntity.OptionEntity n) {
            return o.text.equals(n.text);
        }
    };


    public CharacterOptionAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_option, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(getItem(i));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.io_tv_option)
        TextView ioTvOption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(final CharacterEntity.OptionEntity en) {
            if (!TextUtils.isEmpty(en.text)) {
                ioTvOption.setText(en.text);
            }
            if (en.characterInterface != null) {
                ioTvOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        en.characterInterface.onClick();
                    }
                });
            }
        }
    }

}