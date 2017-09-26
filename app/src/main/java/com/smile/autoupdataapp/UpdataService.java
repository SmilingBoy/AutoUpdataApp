package com.smile.autoupdataapp;

import android.os.Bundle;
import android.util.Log;

import com.allenliu.versionchecklib.core.AVersionService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Smile on 2017/9/19.
 */

public class UpdataService extends AVersionService {
    @Override
    public void onResponses(AVersionService service, String response) {

        Log.e("TGA", response);

        JSONObject data = null;

        try {
            data = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String version_name = data.optString("version_name");
        String version_code = data.optString("version_code");
        String updata_msg = data.optString("updata_msg");
        String force = data.optString("force");
        String target_size = data.optString("target_size");
        String download_url = data.optString("download_url");

        boolean isForceUpdate = force.equals("1");
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", isForceUpdate);
        bundle.putString("size", target_size);
        showVersionDialog(download_url,
                version_name,
                updata_msg,
                bundle);
    }
}
