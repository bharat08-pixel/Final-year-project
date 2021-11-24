package my.edu.utar.finalyear1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import static com.google.android.material.navigation.NavigationView.*;

public class MainActivity extends AppCompatActivity {

    ImageButton infobtn ,bmibtn, remindbtn, schedulebtn;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences username1 = getSharedPreferences("userName", Context.MODE_PRIVATE);
        String email = username1.getString("Username", "");

        infobtn = findViewById(R.id.information);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiabetesInfo.class);
                startActivity(intent);
            }
        });

        bmibtn = findViewById(R.id.bmicalculator);
        bmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bmi.class);
                startActivity(intent);
            }
        });

        remindbtn = findViewById(R.id.reminder);
        remindbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MedReminder.class);
                startActivity(intent);
            }
        });

        schedulebtn = findViewById(R.id.scheduler);
        schedulebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Scheduler.class);
                startActivity(intent);
            }
        });


    }




}