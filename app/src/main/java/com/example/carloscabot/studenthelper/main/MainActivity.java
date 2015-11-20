package com.example.carloscabot.studenthelper.main;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.example.carloscabot.studenthelper.fragments.NotasGeneralesFragment;
import com.example.carloscabot.studenthelper.juegosActivity.JuegosActivity;
import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.clases.SharedPreference;
import com.example.carloscabot.studenthelper.fragments.AsignaturaFragment;
import com.example.carloscabot.studenthelper.fragments.ChatFragment;
import com.example.carloscabot.studenthelper.fragments.HomeFragment;
import com.example.carloscabot.studenthelper.fragments.JuegosFragment;
import com.example.carloscabot.studenthelper.fragments.NavigationDrawerFragment;
import com.example.carloscabot.studenthelper.fragments.NotasFragment;
import com.example.carloscabot.studenthelper.loginActivity.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreference sharedPreference = new SharedPreference();

        if(null==sharedPreference.getValue(this)){
            startActivity(new Intent(this, LoginActivity.class));
            //finish();
        }

        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment=null;
        switch (position){
           case 0:
               fragment = HomeFragment.newInstance(position + 1);
               break;
           case 1:
               fragment = ChatFragment.newInstance(position + 1);
               break;
           case 2:
               fragment = NotasFragment.newInstance(position + 1);
               break;
           case 3:
               fragment = AsignaturaFragment.newInstance(position + 1);
               break;
           case 4:
               fragment = JuegosFragment.newInstance(position + 1);
               break;
       }

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);

        //Aqui cambiamos el color de la barra
        actionBar.setBackgroundDrawable(new ColorDrawable(0xff003333));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.global, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_example) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickChallenge(View v){
        Intent intent = new Intent(this, JuegosActivity.class);
        startActivity(intent);
    }
    public void onClickGeneral(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragmentNotasGenerales = null;

        //Averiguar uso position
        int position = 4;
        fragmentNotasGenerales = NotasGeneralesFragment.newInstance(position + 1);
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragmentNotasGenerales)
                .commit();
    }
}
