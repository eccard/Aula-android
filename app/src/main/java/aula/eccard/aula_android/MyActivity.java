package aula.eccard.aula_android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity implements View.OnClickListener{
    String mat;
    EditText editmatricula;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        editmatricula = (EditText) findViewById(R.id.editTextMatricula);
        ok = (Button) findViewById(R.id.button);

        SharedPreferences sharedPreferences = this.getSharedPreferences("aula.eccard.prefs", Context.MODE_PRIVATE);
        mat = sharedPreferences.getString("matricula", "");

        // se a matricula tiver sido iniciada anteriormente setar esta matricula
        if(!mat.equals("")){
            Log.i("entrou","entrour");
            editmatricula.setText(mat);
        }
        ok.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                SharedPreferences sharedPreferences = this.getSharedPreferences("aula.eccard.prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("matricula",editmatricula.getText().toString());
                editor.commit();
                break;
            default:
                break;
        }
    }
}
