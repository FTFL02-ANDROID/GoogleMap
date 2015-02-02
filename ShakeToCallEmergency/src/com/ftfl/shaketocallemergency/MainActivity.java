package com.ftfl.shaketocallemergency;


import com.ftfl.shaketocallemergency.ShakeDetector.OnShakeListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	
	private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    String mPhoneNumner = null, 
    	   mName = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                                                                                                                        mName = "pRaNtO";  mPhoneNumner = "008801671443203";
        
        


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new OnShakeListener() {
           
        	@Override
            public void onShake() {
                // Do stuff!
        		
        		Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mPhoneNumner));
				startActivity(callIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }   
}
