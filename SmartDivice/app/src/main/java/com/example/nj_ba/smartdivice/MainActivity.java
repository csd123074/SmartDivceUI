package com.example.nj_ba.smartdivice;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    Button button_yes, button_no, button_send;
    CheckBox checkBox_always_on;
    SeekBar seekBar_Brightness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.button_no);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.button_yes);
        button.setOnClickListener(this);
        button = (Button) findViewById(R.id.checkBox_always_on);
        button.setOnClickListener(this);

        SeekBar bar = (SeekBar)findViewById(R.id.seekBar_Brightness);
        bar.setOnSeekBarChangeListener(this);
        bar.setMax(1000);
    }

    @Override
    public void onClick(View v) {
        String str = new String();
        switch (v.getId()){
            case R.id.button_yes:
                str = "\"예\"버튼을 눌렀습니다.";
                break;
            case R.id.button_no:
                str = "\"아니오\"버튼을 눌렀습니다.";
                break;
            case R.id. button_send:
                str = "\"전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전송 문자열");
                EditText editText = (EditText)findViewById(R.id.editText_send_string);
                String Dialogstr = String.valueOf(editText.getText());
                builder.setMessage(Dialogstr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK",null);
                builder.setNegativeButton("CANCEL",null);
                AlertDialog alter = builder.create();
                alter.show();
                break;

            case R.id.checkBox_always_on:
                CheckBox checkBox = (CheckBox)findViewById(R.id. checkBox_always_on);
                if(checkBox.isChecked())
                    checkBox.setText("항상 켜기");
                else
                    checkBox.setText("항상 켜지 않기");
                str = "체크박스를 눌렀습니다.";
                break;
        }
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(),"밝기가 변경 되었습니다.",Toast.LENGTH_SHORT).show();

        String str = String.valueOf(progress);
        EditText textField = (EditText)findViewById(R.id.editText_send_string);
        textField.setText(str);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
