package com.example.carloscabot.studenthelper.loginActivity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.carloscabot.studenthelper.clases.SharedPreference;

import com.example.carloscabot.studenthelper.R;

public class LoginActivity extends AppCompatActivity {

    private EditText textEtxt1;
    private EditText textEtxt2;
    private Button btn1;

    private String text1;
    private String text2;

    private SharedPreference sharedPreference;

    Activity context = this;

    public void onclickLogin(View view) {
        EditText password = (EditText) findViewById(R.id.passwd);
        String pass = (password).getText().toString();
        if (!isValidPassword(pass)) {
            password.setError("Contraseña invalida!\nHay que ser 6 números o caracteres al menos!");
        } else if (pass.isEmpty()) {
            password.setError("Contraseña vacia!");
        }
        EditText usuario = (EditText) findViewById(R.id.user);
        if (usuario.getText().toString().length() == 0) {
            usuario.setError("Tienes que completar usuario primero!");
        }
        if (!isValidPassword(pass) && (usuario.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Error!\nCampos vacios!", Toast.LENGTH_SHORT).show();
        }
        text1 = textEtxt1.getText().toString();
        text2 = textEtxt2.getText().toString();

        // Hides the soft keyboard
        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.hideSoftInputFromWindow(textEtxt1.getWindowToken(), 0);
        InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm2.hideSoftInputFromWindow(textEtxt2.getWindowToken(), 0);

        // Save the text in SharedPreference
        sharedPreference.save(context, text1+""+text2);
        Toast.makeText(context,
                "Login con éxito.",
                Toast.LENGTH_LONG).show();
        finish();
    }

    private void findViewsById() {
        textEtxt1 = (EditText) findViewById(R.id.user);
        textEtxt2 = (EditText) findViewById(R.id.passwd);
        btn1 = (Button) findViewById(R.id.login);
    }

    public void onclickcancel(View view) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreference = new SharedPreference();

        findViewsById();
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
