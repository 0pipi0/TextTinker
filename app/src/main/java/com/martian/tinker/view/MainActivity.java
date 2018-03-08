package com.martian.tinker.view;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.martian.tinker.R;
import com.martian.tinker.util.Utils;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    initView();
  }

  /**
   * 初始化布局
   */
  private void initView() {
    textView = findViewById(R.id.tv);
    textView.setText(Utils.getContent());
    Button button = findViewById(R.id.button);
    button.setOnClickListener(this);
  }
  @Override public void onClick(View v) {
    switch (v.getId()){
      case  R.id.button:
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed.apk");
        break;
    }

  }
}
