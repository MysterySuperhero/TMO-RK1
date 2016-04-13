package com.mysterysuperhero.tmork1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.mysterysuperhero.tmork1.fragments.ValuesFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Fragment valuesFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.fragmentManager = getFragmentManager();

//        fab.hide();

        valuesFragment = new ValuesFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer, valuesFragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void switchFragmetns(String fragmentName) {
        transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        switch (fragmentName) {
            case "Values":
                transaction.replace(R.id.fragmentContainer, valuesFragment);
                // clear back stack
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case "InputParams":
//                if (taskFragment == null)
//                    taskFragment = new TaskFragment();
//                transaction.replace(R.id.fragmentContainer, taskFragment);
//                transaction.addToBackStack(null);
                break;
            case "Results":
//                transaction.replace(R.id.fragmentContainer, myFriendsFragment);
//                transaction.addToBackStack(null);
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
