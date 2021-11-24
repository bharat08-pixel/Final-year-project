package my.edu.utar.finalyear1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MedReminder extends AppCompatActivity implements View.OnClickListener{

    private int notificationId=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.medication_reminder);

        findViewById(R.id.setBtn).setOnClickListener( this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);
        ;
    }
    @Override
    public void onClick(View v){

        TimePicker timePicker=findViewById(R.id.timePciker);
        EditText editText1=findViewById(R.id.amounttext);

        Intent intent=new Intent(MedReminder.this,AlarmReciever.class);

        intent.putExtra("capsule",editText1.getText().toString());

        PendingIntent alarmIntent=PendingIntent.getBroadcast(
                MedReminder.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT
        );
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        switch (v.getId()){
            case R.id.setBtn:
                int hour=timePicker.getHour();
                int minute=timePicker.getMinute();

                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime=startTime.getTimeInMillis();

                alarmManager.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                alarmManager.cancel(alarmIntent);
                Toast.makeText(this,"Cancelled!",Toast.LENGTH_SHORT).show();
                break;
        }


    }


}
