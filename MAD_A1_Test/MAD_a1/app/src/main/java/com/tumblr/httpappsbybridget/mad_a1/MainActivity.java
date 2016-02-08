package com.tumblr.httpappsbybridget.mad_a1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Spinner spinnerAssignmentList = null;
    public TextView tvTitleField = null;
    public TextView tvDueDateField = null;
    public TextView tvPriorityField = null;
    public TextView tvDetailsField = null;
    public TextView tvTasksField = null;
    public Button nAButton = null;
    public Button delButton = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nAButton = (Button)findViewById(R.id.addAssignment);
        nAButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // move to new screen
                Intent intent = new Intent(MainActivity.this, AddNewAssignment.class);
                startActivity(intent);
           }
        });

        loadAssignment();
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

            Intent intent = new Intent(MainActivity.this, settings_page.class);
            startActivity(intent);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadAssignment()
    {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("assignment", MainActivity.MODE_PRIVATE);
        if(preferences.contains("title")){
            tvTitleField.setText(preferences.getString("title", "null"));
        }
        if(preferences.contains("datetime")){
            tvDueDateField.setText(preferences.getString("datetime", "null"));
        }
        if(preferences.contains("priority")){
            tvPriorityField.setText(preferences.getString("priority", "null"));
        }
        if(preferences.contains("details")){
            tvDetailsField.setText(preferences.getString("details", "null"));
        }
        if(preferences.contains("tasks")){
            tvTasksField.setText(preferences.getString("tasks", "null"));
        }
    }
}
