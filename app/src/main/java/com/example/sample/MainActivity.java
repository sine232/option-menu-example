package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView = findViewById(R.id.my_image_view);

        registerForContextMenu(myImageView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_image_as:
                Toast.makeText(MainActivity.this, "Image saved in gallary", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copy_image:
                Toast.makeText(MainActivity.this, "Image Copied", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copy_link_address:
                Toast.makeText(MainActivity.this, "Image Link Address is copied", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_link_as:
                Toast.makeText(MainActivity.this, "Image Link Address is Saved", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
        public boolean onLongClick(View a) {
            if (a.getId() == R.id.my_image_view) {
                a.showContextMenu();
                return true;
            }
            return false;
        }
}
