package com.example.helloworld;

import android.os.Bundle;
import android.widget.QuickContactBadge;
import android.app.Activity;

public class QuicContactBadgeTest extends Activity 
{
	QuickContactBadge badge;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quic_contact_badge_test);
        // 获取QuickContactBadge组件
        badge = (QuickContactBadge) findViewById(R.id.badge);
        // 将QuickContactBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("18758251523", false);
    }
}
