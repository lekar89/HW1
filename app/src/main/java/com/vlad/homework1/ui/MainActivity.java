package com.vlad.homework1.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vlad.homework1.Config;
import com.vlad.homework1.R;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    // переменная класа типа  TextView
    Button mBtnFollowSecAct;
      // переменная класа типа Button
    Button mBtnStartForResult; 
         // переменная класа типа Button
    Button mBtnSendNot;    
        // переменная класа типа Button
    private static final int NOTIFY_ID = 101;
// константа для ид уведомления 
    @Override
    protected void onCreate(Bundle savedInstanceState)
        //вызывается при создании или перезапуска активности
        // принимает объект Bundle, содержащий состояние пользовательского интерфейса, 
        //сохранённое в последнем вызове обработчика onSaveInstanceState.
    {
        
        super.onCreate(savedInstanceState);
        //вызов родиельского метода содержащий состояние пользовательского интерфейса, 
        //сохранённое в последнем вызове обработчика onSaveInstanceState.
        setContentView(R.layout.activity_main);
        // соединение разметки и активити 

        mainTextView = (TextView) findViewById(R.id.txt_main_activity);
          // назанчение перменной предствления из разметки и приведение представления к типу TextView
        mainTextView.setText("Main Activity");
        //вызов методау переменной mainTextView  для установки текста 

        mBtnFollowSecAct = (Button) findViewById(R.id.btn_followMain_activity);
            // назанчение перменной предствления из разметки и приведение представления к типу Button
        mBtnFollowSecAct.setOnClickListener(new View.OnClickListener() {
            // назначени и создание листенера для перхода на вторую активность
            @Override
            public void onClick(View v)
            {
               
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // создание намериния агрументами передаем для какой активности вызван и какую хотим вызвать 
                startActivity(intent);
                //запуск другой активности без возможности передавать данные 
            }
        });

        mBtnStartForResult = (Button) findViewById(R.id.btn_forResult);
         // назанчение перменной предствления из разметки и приведение представления к типу Button
        mBtnStartForResult.setOnClickListener(new View.OnClickListener() {
              // назначени и создание листенера для перхода на вторую активность
            @Override
            public void onClick(View v) {
                Intent result = new Intent(MainActivity.this, SecondActivity.class);
                // создание намериния агрументами передаем для какой активности вызван и какую хотим вызвать 
                startActivityForResult(result, 1);
                 //запуск другой активности с возможностью передавать данные 
            }
        });

        mBtnSendNot = (Button) findViewById(R.id.btn_sendNotification);
         // назанчение перменной предствления из разметки и приведение представления к типу Button
        mBtnSendNot.setOnClickListener(new View.OnClickListener() {
             // назначени и создание листенера для вызова уведомления 
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
        Log.d(Config.TAG, "MainActivity - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Config.TAG, "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Config.TAG, "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Config.TAG, "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Config.TAG, "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Config.TAG, "MainActivity - onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra("name");
        mainTextView.setText("Your name is " + name);
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    private void createNotification()
    {
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);



        Notification.Builder builder = new Notification.Builder(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            builder.setContentIntent(contentIntent)
                    .setSmallIcon(R.drawable.br)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(String.valueOf(R.string.notification_title))
                    .setContentText(String.valueOf(R.string.notification_text))
                    .setAutoCancel(true);
        }

        Notification notification = builder.getNotification();
        nm.notify(NOTIFY_ID, notification);
    }
}
