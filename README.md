# AndroidPermissionLib 基于Android新权限的封装
1. 查看Android危险权限的方法,在控制台输入 ‘adb shell pm list permissions -d -g’
2. 使用说明

   (1) 将需要申请权限的 Activity 继承 BaseActivity
   
   (2) 在 Activity 中直接调用 requesDynamictPermission() 方法进行获取权限，注意传入获取权限后的监听
   
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
        
      (3) 在 BaseActivity 内部针对不同的 requestCode 映射了不同的权限监听，所以会保证 requestCode 和回调监听一一对应
      
          protected SparseArray<DynamicPermissionListener> mListenerArray;
          // 权限获取监听
          interface DynamicPermissionListener {
             void onSuccess();
             void onFailure();
          }
