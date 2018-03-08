package com.martian.tinker.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.File;

/**
 * @author martian on 2017/9/20.
 */

public class AppInfoUtil {

  public static int getScreenWidth(Context context) {
    DisplayMetrics dm = new DisplayMetrics();
    ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
    return dm.widthPixels;
  }

  public static int getScreenHeight(Context context) {
    DisplayMetrics dm = new DisplayMetrics();
    ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
    return dm.heightPixels;
  }

  public static int getActionBarHeight(Context context) {
    TypedValue tv = new TypedValue();
    int actionBarHeight = 0;
    if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
      actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
          context.getResources().getDisplayMetrics());
    }
    return actionBarHeight;
  }

  public static int getStatusBarHeight(Context context) {
    int statusBarHeight = 0;
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      //根据资源ID获取响应的尺寸值
      statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
    }
    return statusBarHeight;
  }

  /**
   * 返回当前程序版本名
   */
  public static String getAppVersionName(Context context) {
    String versionName = "";
    try {
      // ---get the package info---
      PackageManager pm = context.getPackageManager();
      PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
      versionName = pi.versionName;
      if (versionName == null || versionName.length() <= 0) {
        return "";
      }
    } catch (Exception e) {
    }
    return versionName;
  }

  public static int getVersionCode(Context context) {
    try {
      PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      return pi.versionCode;
    } catch (Exception e) {
      return 0;
    }
  }

    public static boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }
}
