package com.smile.autoupdataapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Smile on 2017/9/26.
 */

public class UpdataDialog extends Dialog implements View.OnClickListener {

    public interface OnUpdateClickListener {
        void click();
    }

    private Button btnUpdateNow;
    private ImageButton ibtnClose;
    private TextView tvVersionName;
    private TextView tvAppSizq;
    private TextView tvUpdateMsg;
    private OnUpdateClickListener updateClickListener = null;

    private boolean isForse = false;
    private String versionName = "";
    private String appSizq = "";
    private String updateMsg = "";

    public UpdataDialog(@NonNull Context context) {
        super(context, R.style.BaseDialog);
    }

    private UpdataDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.BaseDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_updata);

        ibtnClose = findViewById(R.id.ibtn_close);
        btnUpdateNow = findViewById(R.id.btn_update_now);
        tvVersionName = findViewById(R.id.tv_version_name);
        tvAppSizq = findViewById(R.id.tv_app_size);
        tvUpdateMsg = findViewById(R.id.tv_updata_msg);

        ibtnClose.setOnClickListener(this);
        btnUpdateNow.setOnClickListener(this);

        tvVersionName.setText("最新版本：" + versionName);
        tvAppSizq.setText("新版本大小：" + appSizq);
        tvUpdateMsg.setText(updateMsg);

        if (isForse) {
            ibtnClose.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_update_now) {
            dismiss();
            if (null != updateClickListener) {
                updateClickListener.click();
            }
        } else if (view.getId() == R.id.ibtn_close) {
            dismiss();
        }

    }

    public UpdataDialog setUpdateClickListener(OnUpdateClickListener updateClickListener) {
        this.updateClickListener = updateClickListener;
        return this;
    }

    public UpdataDialog setForse(boolean forse) {
        isForse = forse;
        return this;
    }

    public UpdataDialog setVersionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    public UpdataDialog setAppSizq(String appSizq) {
        this.appSizq = appSizq;
        return this;
    }

    public UpdataDialog setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
        return this;
    }
}
