package com.smile.autoupdataapp;

import android.view.KeyEvent;

import com.allenliu.versionchecklib.core.VersionDialogActivity;

public class UpdataDialogActivity extends VersionDialogActivity {

    private UpdataDialog updataDialog = null;
    private boolean force = false;

    @Override
    protected void showVersionDialog() {

        force = getVersionParamBundle().getBoolean("force", false);
        String size = getVersionParamBundle().getString("size");

        updataDialog = new UpdataDialog(this).setForse(true)
                .setAppSizq(size)
                .setUpdateMsg(getVersionUpdateMsg())
                .setVersionName(getVersionTitle())
                .setForse(force)
                .setUpdateClickListener(new UpdataDialog.OnUpdateClickListener() {
                    @Override
                    public void click() {
                        dealAPK();
                    }
                });

        updataDialog.setCanceledOnTouchOutside(false);

        updataDialog.show();

    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}
