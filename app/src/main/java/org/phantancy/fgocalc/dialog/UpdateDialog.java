package org.phantancy.fgocalc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.phantancy.fgocalc.R;
import org.phantancy.fgocalc.adapter.UpdateAdapter;
import org.phantancy.fgocalc.item.RemoteVersionItem;
import org.phantancy.fgocalc.item.UpdateItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HATTER on 2017/8/8.
 */

public class UpdateDialog extends Dialog{
    @BindView(R.id.du_rv_list)
    RecyclerView duRvList;
    @BindView(R.id.du_tv_update)
    TextView duTvUpdate;
    @BindView(R.id.du_tv_cancel)
    TextView duTvCancel;
    @BindView(R.id.du_tv_ignore)
    TextView duTvIgnore;
    @BindView(R.id.du_tv_download)
    TextView duTvDownload;
    private Context mContext;

    public UpdateDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(R.layout.diag_update,null,false);
        setContentView(view);
        ButterKnife.bind(view);
        mContext = context;
        duTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setDownloadListener(View.OnClickListener onClickListener) {
        duTvDownload.setOnClickListener(onClickListener);
    }

    public void setUpdate(RemoteVersionItem item) {
        UpdateAdapter adapter = new UpdateAdapter();
        duRvList.setAdapter(adapter);
        adapter.submitList(item.getContent());


    }

    public void setIgnoreListener(View.OnClickListener listener) {
        duTvIgnore.setOnClickListener(listener);
    }
}
