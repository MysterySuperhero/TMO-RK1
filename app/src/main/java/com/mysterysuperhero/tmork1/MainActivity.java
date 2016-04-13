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

import com.mysterysuperhero.tmork1.fragments.InputParamsFragment;
import com.mysterysuperhero.tmork1.fragments.ResultsFragment;
import com.mysterysuperhero.tmork1.fragments.ValuesFragment;
import com.mysterysuperhero.tmork1.utils.InputEvent;
import com.mysterysuperhero.tmork1.utils.ValuesEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Fragment valuesFragment;
    Fragment inputParamsFragment;
    Fragment resultsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        this.fragmentManager = getFragmentManager();

        valuesFragment = new ValuesFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer, valuesFragment);
        transaction.commit();
        inputParamsFragment = new InputParamsFragment();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                if (inputParamsFragment == null)
                    inputParamsFragment = new InputParamsFragment();
                transaction.replace(R.id.fragmentContainer, inputParamsFragment);
                transaction.addToBackStack(null);
                EventBus.getDefault().register(inputParamsFragment);
                EventBus.getDefault().post(new ValuesEvent(((ValuesFragment) valuesFragment).getData()));
                break;
            case "Results":
                if (resultsFragment == null)
                    resultsFragment = new ResultsFragment();
                getFragmentManager().popBackStack();
                transaction.replace(R.id.fragmentContainer, resultsFragment);
                transaction.addToBackStack(null);
                EventBus.getDefault().register(resultsFragment);
                EventBus.getDefault().post(new InputEvent(
                        ((InputParamsFragment) inputParamsFragment).getValues(),
                        ((InputParamsFragment) inputParamsFragment).getParams()
                ));
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
