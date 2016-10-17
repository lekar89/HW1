package com.vlad.homework1.ui;

/**
 * Created by Влад on 28.09.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vlad.homework1.Config;
import com.vlad.homework1.R;

public class SecondActivity extends AppCompatActivity {

    TextView secondTextView;
     // переменная класа типа  TextView
    Button mBtnBack;
     // переменная класа типа  Button
    Button mBtnAddData;
    // переменная класа типа  Button
    EditText editText;
    // переменная класа типа  EditText

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
         //вызывается при создании или перезапуска активности
        // принимает объект Bundle, содержащий состояние пользовательского интерфейса, 
        //сохранённое в последнем вызове обработчика onSaveInstanceState.
        super.onCreate(savedInstanceState);
        //вызов родиельского метода содержащий состояние пользовательского интерфейса, 
        //сохранённое в последнем вызове обработчика onSaveInstanceState.
        setContentView(R.layout.activity_second);
           // соединение разметки и активити 
        secondTextView = (TextView) findViewById(R.id.txt_second_activity);
         // назанчение перменной предствления из разметки и приведение представления к типу TextView
        secondTextView.setText("Second Actitvity");
         //вызов методау переменной mainTextView  для установки текста 
        mBtnBack = (Button) findViewById(R.id.btn_followSecond_activity);
        // назанчение перменной предствления из разметки и приведение представления к типу Button
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            // назначени и создание листенера для возврата на предыдущую  активность
            @Override
            public void onClick(View v) {
                onBackPressed();
                //вызов преопределенного метода 
            }
        });

        editText = (EditText) findViewById(R.id.edit_txt_edit);
 // назанчение перменной предствления из разметки и приведение представления к типу EditText
        mBtnAddData = (Button) findViewById(R.id.btn_addData);
        // назанчение перменной предствления из разметки и приведение представления к типу Button
        mBtnAddData.setOnClickListener(new View.OnClickListener() {
                  // назначени и создание листенера для пердачи данных в  предыдущую  активность
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                  // создание намериния для сохранения данных 
                intent.putExtra("name", editText.getText().toString());
                // сохранение даных из поля editText по ключю name
                setResult(RESULT_OK, intent);
                // возвращение данных в родительскую активность и код результата закрытия активности
                finish();
                //завершить работу активности
            }
        });
        Log.d(Config.TAG, "SecondActivity - onCreate");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    protected void onStart() {
         // Вызывается непосредственно перед тем, как активность становится видимой
        super.onStart();
        Log.d(Config.TAG, "SecondActivity - onStart");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    protected void onResume() {
          // вызывается  каждый раз, когда  активность идёт на переднем плане
        super.onResume();
        Log.d(Config.TAG, "SecondActivity - onResume");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    protected void onPause() {
        // вызывается при свертывании активности 
        super.onPause();
        Log.d(Config.TAG, "SecondActivity - onPause");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    protected void onStop() {
        //вызывается, когда окно становится невидимым для пользователя. 
        //при  уничтожении активности , или если была запущена другая активность перекрывшая окно текущей активности
        super.onStop();
        Log.d(Config.TAG, "SecondActivity - onStop");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    protected void onRestart() {
         // активность была остановлена и снова была запущена пользователем
                super.onRestart();
         Log.d(Config.TAG, "SecondActivity - onRestart");
         //сообщение в консоль выполнится при отработке метода
    }

    @Override
    protected void onDestroy() {
         //вызывается по окончании работы активности, при вызове метода finish()
        //или в случае, когда система уничтожает этот экземпляр активности
        super.onDestroy();
        Log.d(Config.TAG, "SecondActivity - onDestroy");
         //сообщение в консоль выполнится при отработке метода 
    }

    @Override
    public void onBackPressed() {
        //Метод, позволяющий отследить нажатине на кнопку Back. 
        super.onBackPressed();
        Log.d(Config.TAG, "SecondActivity - onBackPressed()");
         //сообщение в консоль выполнится при отработке метода 

    }
}
