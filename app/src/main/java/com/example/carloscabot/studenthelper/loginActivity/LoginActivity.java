package com.example.carloscabot.studenthelper.loginActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.clases.SharedPreference;

import com.example.carloscabot.studenthelper.R;

public class LoginActivity extends AppCompatActivity {

    private String text1;
    private String text2;

    private SharedPreference sharedPreference;

    public void onclickLogin(View view) {
        EditText password = (EditText) findViewById(R.id.passwd);
        String pass = (password).getText().toString();
        if (!isValidPassword(pass)) {
            password.setError("Contraseña invalida!\nHay que ser 6 números o caracteres al menos!");
        } else if (pass.isEmpty()) {
            password.setError("Contraseña vacia!");
        }else{
            text2 = password.getText().toString();
        }
        EditText usuario = (EditText) findViewById(R.id.user);
        if (usuario.getText().toString().length() == 0) {
            usuario.setError("Tienes que completar usuario primero!");
        }else {
            text1 = usuario.getText().toString();
        }

        // Hides the soft keyboard
        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.hideSoftInputFromWindow(usuario.getWindowToken(), 0);
        InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm2.hideSoftInputFromWindow(password.getWindowToken(), 0);

        // Save the text in SharedPreference
        sharedPreference.save(this, text1 + "" + text2);

        //Comprueba loa campos
        if (!isValidPassword(pass) && (usuario.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Error!\nCampos vacios!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),
                    "Login con éxito.",
                    Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void onclickcancel(View view) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreference = new SharedPreference();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 5) {
            return true;
        }
        return false;
    }
}
