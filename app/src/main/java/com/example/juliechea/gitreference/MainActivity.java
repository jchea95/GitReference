package com.example.juliechea.gitreference;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);

        InputStream is = null;
        String x="";


        try{
            // getting asset file
            is = getApplicationContext().getAssets().open("gitReference.json");
            x = JsonUtils.parseJsonToString(is);
            System.out.println(x);

            // pass in an input stream and get back a string

        }

        catch(Exception e){


        }

        // populate gitReference with the json strings in x
        ArrayList<GitReference> references = JsonUtils.populateGitReferences(x);



        Log.i("JSON ", x);



        GitReferenceAdapter adapter = new GitReferenceAdapter(this, references);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Command", Toast.LENGTH_SHORT).show();
            }
        });

    }






}
