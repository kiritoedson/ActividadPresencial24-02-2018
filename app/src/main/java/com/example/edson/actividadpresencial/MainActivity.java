package com.example.edson.actividadpresencial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button bt1;
    Spinner spin;
    String escuela[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txt1=findViewById(R.id.editText);
        txt2=findViewById(R.id.editText2);
        spin=findViewById(R.id.spinner);
        bt1=findViewById(R.id.button);

        escuela= new String[]{"CU","FES ARAGON","FES ZARAGOZA","FES IZTACALA"};
        addEscuelas(escuela);
        startActivity2();
    }

    private void addEscuelas (String[] escuela){
        ArrayAdapter<String> spinarray= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, escuela);
        spinarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(spinarray);
    }

    private void startActivity2(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Main2Activity.class);
                String nom= txt1.getText().toString();
                String pass= txt2.getText().toString();
                String escu= spin.getSelectedItem().toString();
                intent.putExtra("mensaje",nom);
                intent.putExtra("mensage",pass);
                intent.putExtra("escul",escu);
                startActivity(intent);

            }
        });
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
}
