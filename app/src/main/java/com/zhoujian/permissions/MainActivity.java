package com.zhoujian.permissions;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BasePermissionsActivity
{

    private Intent intent;
    private Button mTake_phone;
    private Button mTake_photo;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        clickEvents();
    }

    private void initViews()
    {
        mTake_phone = (Button)findViewById(R.id.take_phone);
        mTake_photo = (Button)findViewById(R.id.take_photo);
    }

    private void clickEvents()
    {

        mTake_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestPermission(new String[]{Manifest.permission.CALL_PHONE},1);
            }
        });


        mTake_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestPermission(new String[]{Manifest.permission.CAMERA},2);
            }
        });

    }


    /**
     * 权限成功回调函数
     *
     * @param requestCode
     */
    @Override
    public void permissinSucceed(int requestCode) {
        super.permissinSucceed(requestCode);
        switch (requestCode) {
            case 1:
                intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel:15855759639"));
                startActivity(intent);
                break;

            case 2:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;

        }

    }

    @Override
    public void permissionFailing(int code) {
        super.permissionFailing(code);

    }
}
