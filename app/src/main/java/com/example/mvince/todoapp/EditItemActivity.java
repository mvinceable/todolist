package com.example.mvince.todoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {
    private EditText etItemValue;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String value = getIntent().getStringExtra("value");
        position = getIntent().getIntExtra("position", 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItemValue = (EditText) findViewById(R.id.etItemValue);
        etItemValue.setText(value);
        // Place cursor at end of text
        etItemValue.setSelection(etItemValue.getText().length());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onSave(View view) {
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("value", etItemValue.getText().toString());
        data.putExtra("position", position);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        finish(); // closes the activity, pass data to parent
    }
}
