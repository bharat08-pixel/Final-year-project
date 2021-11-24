package my.edu.utar.finalyear1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Bmi extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrentheight;
    TextView mcurrentage,mcurrentweight;
    ImageView mincreaseage,mincreaseweight,mdecreaseage,mdecreaseweight;
    SeekBar mseekbarforheight;
    RelativeLayout mamale,mfemale;

    int intweight=55;
    int intage=22;
    int cuurrentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);
        getSupportActionBar().hide();

        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincreaseage=findViewById(R.id.increaseage);
        mincreaseweight=findViewById(R.id.increaseweight);
        mdecreaseage=findViewById(R.id.decreaseage);
        mdecreaseweight=findViewById(R.id.decreaseweight);
        mseekbarforheight=findViewById(R.id.seekbarheight);
        mamale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);

        mamale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mamale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernotfocus));
                typeofuser="Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
                mamale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernotfocus));
                typeofuser="Female";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cuurrentprogress=progress;
                mintprogress=String.valueOf(cuurrentprogress);
                mcurrentheight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincreaseage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


        mincreaseweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });


        mdecreaseage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


        mdecreaseweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });






        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "select Your Gender First", Toast.LENGTH_SHORT).show();

                }
                if (mintprogress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "select Your Height First", Toast.LENGTH_SHORT).show();

                } else if (intage == 0 || intage < 0) {
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (intweight == 0 || intweight < 0) {
                    Toast.makeText(getApplicationContext(), "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(Bmi.this, bmiactivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }
            }
        });
        //for changing status bar icon colors


    }
}
