package kr.hs.emirim.sinyh104.shraredpreferencetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName,editAge;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        String name=sp.getString("name","");
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }

    protected void onStop(){
        super.onStop();
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("name",editName.getText().toString());
        edit.putString("age",editAge.getText().toString());
        edit.commit();
    }
}
