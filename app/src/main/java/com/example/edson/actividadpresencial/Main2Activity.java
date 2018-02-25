package com.example.edson.actividadpresencial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView tview1;
    String Nombres[],Passwords[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        tview1=findViewById(R.id.textView1);
        Nombres= new String[]{"Luis", "Juan"};
        Passwords= new String[]{"Luis","Juan"};


        Intent intent=getIntent();
        String name= intent.getStringExtra("mensaje");
        String pasw= intent.getStringExtra("mensage");
        String escuela= intent.getStringExtra("escul");

        for (int a=0; a<Nombres.length; a++){
            String z= Nombres[a];
            if (name.equalsIgnoreCase(z)){
                for (int y=0;y<Passwords.length;y++){
                    String m=Passwords[y];
                    if (pasw.equals(m)){
                        tview1.setText("Hola "+name+" \nBienvenido a: \n"+escuela);
                    }

                }

            }
        }

        if (Nombres.equals(name)){
            tview1.setText("Hola "+name+" \nBienvenido a: \n"+escuela);
        }

        /*tview1.append("ultimo"+name+escuela);*/


    }

}
