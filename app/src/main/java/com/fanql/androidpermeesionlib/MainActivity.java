package com.fanql.androidpermeesionlib;

import android.Manifest;
import android.Manifest.permission;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    static final int CALL_PHONE = 0x01;
    static final int ACCESS_SDCARD = 0x02;
    // 查看危险权限的方法 adb shell pm list permissions -d -g

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 打电话权限申请
        findViewById(R.id.btn_call_phone).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                requesDynamictPermission(CALL_PHONE, new String[]{Manifest.permission.CALL_PHONE}, new DynamicPermissionListener() {

                    @Override
                    public void onSuccess() {

                        Toast.makeText(MainActivity.this, "电话权限获取成功", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "电话权限被用户拒绝", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

        // SD卡权限申请
        findViewById(R.id.btn_access_sdcard).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                requesDynamictPermission(ACCESS_SDCARD, new String[]{permission.WRITE_EXTERNAL_STORAGE}, new DynamicPermissionListener() {

                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "SD卡权限获取成功", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "SD卡权限被用户拒绝", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
