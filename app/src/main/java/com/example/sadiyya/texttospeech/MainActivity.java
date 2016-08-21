package com.example.sadiyya.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech ts;
    int result;
    EditText et;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.et_text);

        ts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                   result = ts.setLanguage(Locale.ENGLISH);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Language not available for your country!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onBtnSpeechClick(View v){

        if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){

            Toast.makeText(getApplicationContext(),
                    "Language not available for your country!", Toast.LENGTH_SHORT).show();


        }else{
            text = et.getText().toString();
            ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        }

    }
}
