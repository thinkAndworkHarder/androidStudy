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
        // ��ȡQuickContactBadge���
        badge = (QuickContactBadge) findViewById(R.id.badge);
        // ��QuickContactBadge������ض��绰�����Ӧ����ϵ�˽�������
        badge.assignContactFromPhone("18758251523", false);
    }
}
