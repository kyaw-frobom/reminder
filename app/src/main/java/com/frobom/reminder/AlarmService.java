package com.frobom.reminder;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class AlarmService extends Service{
    int DD;


    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        // do your jobs here
        startAlarm(intent);
        return super.onStartCommand(intent, flags, startId);
    }

    void startAlarm(Intent ID)
    {
        Bundle a = ID.getExtras();
        DD = a.getInt("id");

        Intent intent = new Intent(AlarmService.this, alarm.class);
        Bundle b = new Bundle();
        b.putInt("id", DD);
        intent.putExtras(b);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        stopService(new Intent(this, ReminderAlarmManger.class));
        startService(new Intent(this, ReminderAlarmManger.class));
    }

    public AlarmService()
    {
        super();
    }
}
