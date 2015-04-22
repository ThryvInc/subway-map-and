package com.rndapp.madridmap;

import com.flurry.android.FlurryAgent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public class MapActivity extends ActionBarActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_fragments, new MapFragment(), "Map")
                .setCustomAnimations(R.anim.push_right_in, R.anim.push_left_out)
                .commit();
    }
    
    @Override
    protected void onStart()
    {
    	super.onStart();
    	FlurryAgent.onStartSession(this, "59FBKY5M8VSSDT26SHVB");
    }
     
    @Override
    protected void onStop()
    {
    	super.onStop();		
    	FlurryAgent.onEndSession(this);
    }
}