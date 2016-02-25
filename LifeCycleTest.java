package com.paraonensk.tests;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ParaOneNSK on 2/25/2016.
 */
public class LifeCycleTest extends Activity {
    StringBuilder builder = new StringBuilder();
    TextView textView;

    private void log(String text){
        Log.d("LifeCycleTest", text);
        builder.append(text);
        builder.append('\n');
        textView.setText(builder.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText(builder.toString());
        setContentView(textView);
        log("created");
        Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("resumed");
        Toast.makeText(this, "resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("paused");
        Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();

        if(isFinishing()){
            log("finishing");
            Toast.makeText(this, "finishing", Toast.LENGTH_SHORT).show();
        }
    }
}
