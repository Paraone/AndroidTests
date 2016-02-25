package com.paraonensk.tests;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

/**
 * Created by ParaOneNSK on 2/25/2016.
 */
public class KeyTest extends Activity implements View.OnKeyListener {
    StringBuilder builder = new StringBuilder();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText("Press keys");
        textView.setOnKeyListener(this);
        textView.setFocusableInTouchMode(true);
        textView.requestFocus();
        setContentView(textView);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        builder.setLength(0);
        switch(keyEvent.getAction()){
            case KeyEvent.ACTION_DOWN:
                builder.append("down, ");
                break;
            case KeyEvent.ACTION_UP:
                builder.append("up, ");
                break;
        }
        builder.append(keyEvent.getKeyCode());
        builder.append(", ");
        builder.append((char) keyEvent.getUnicodeChar());
        String text = builder.toString();
        Log.d("KeyTest", text);
        textView.setText(text);
        return keyEvent.getKeyCode() != KeyEvent.KEYCODE_BACK;
    }
}
