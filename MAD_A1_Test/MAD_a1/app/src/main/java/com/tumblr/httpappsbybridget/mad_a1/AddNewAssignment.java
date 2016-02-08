package com.tumblr.httpappsbybridget.mad_a1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNewAssignment extends AppCompatActivity {
    Button saveButton = null;
    Button cancelButton = null;
    EditText etTitle = null;
    EditText etDueDate = null;
    Spinner prioritySpinner = null;
    EditText etDetails = null;
    EditText etTasks = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_assignment);

        saveButton = (Button)findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAssignment();
            }
        });
    }

    private void saveAssignment() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("assignment", MainActivity.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();

        etTitle = (EditText) findViewById(R.id.editTextTitle);
        editor.putString("title", etTitle.getText().toString());
        etDueDate = (EditText) findViewById(R.id.editTextDueDate);
        editor.putString("datetime", etDueDate.getText().toString());
        prioritySpinner = (Spinner) findViewById(R.id.spinnerPriority);
        editor.putString("priority", prioritySpinner.getSelectedItem().toString());
        etDetails = (EditText) findViewById(R.id.editTextDetails);
        editor.putString("details", etDetails.getText().toString());
        etTasks = (EditText) findViewById(R.id.editTextTasks);
        editor.putString("tasks", etTasks.getText().toString());

        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_assignment, menu);
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
