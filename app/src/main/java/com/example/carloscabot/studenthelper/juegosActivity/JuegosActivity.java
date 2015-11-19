package com.example.carloscabot.studenthelper.juegosActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.main.MainActivity;

public class JuegosActivity extends AppCompatActivity {
    private TextView contador;

    public void RadioButtonClicked(View view) {
        CharSequence charSequence = "";

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Respuesta1:
                if (checked)
                    charSequence = "EPIC FAIL!";
                Toast.makeText(this.getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Respuesta2:
                if (checked)
                    charSequence = "FAIL!";
                Toast.makeText(this.getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Respuesta3:
                if (checked)
                    charSequence = "GOOD JOB!";
                Toast.makeText(this.getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Respuesta4:
                if (checked)
                    charSequence = "FAIL!";
                Toast.makeText(this.getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void goBack(){
        try {
            JuegosActivity.this.finish();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        //Contador de pregunta
        contador = (TextView) findViewById(R.id.textViewContador);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                contador.setText(millisUntilFinished / 1000+"");

                if(Integer.parseInt(contador.getText().toString())==10){
                    CharSequence charSequence = "Hurry up!";
                    Toast.makeText(getApplicationContext(),charSequence,Toast.LENGTH_SHORT).show();
                }
            }

            public void onFinish() {
                contador.setText("0");

                try {
                    JuegosActivity.this.finish();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juegos, menu);
        //ActionBar
        restoreActionBar();
        return true;
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Quiz Challenge");

        //Aqui cambiamos el color de la barra
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff003333));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            try {
                JuegosActivity.this.finish();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
