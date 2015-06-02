package com.berheley.main.plugins;

import java.io.File;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class OnlineUpdatePlugin extends CordovaPlugin {

	@SuppressLint("DefaultLocale")
	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) throws JSONException {
		String path = args.getString(0);
		Context context = cordova.getActivity().getApplicationContext();
		try {
			Intent i = this.getFileIntent(path);
			context.startActivity(i);
			/*// 文件路径
			PackageManager manager = context.getPackageManager();
	        // 这里的是你下载好的文件路径
	        PackageInfo info = manager.getPackageArchiveInfo(Environment.getExternalStorageDirectory().getAbsolutePath()
	                + path, PackageManager.GET_ACTIVITIES);
	        if (info != null) {
	            Intent intent = manager.getLaunchIntentForPackage(info.applicationInfo.packageName);
	            context.startActivity(intent);
	        }*/
			callbackContext.success("运行程序成功");
		} catch (Exception e) {
			callbackContext.error(e.toString());
			callbackContext.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	public Intent getFileIntent(String param) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param));
		intent.setDataAndType(uri, "application/vnd.android.package-archive");
		return intent;
	}
}
