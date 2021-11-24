package my.edu.utar.finalyear1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;


    String height,weight;
    float intheight,intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("font color=\"white\"><\font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        mbmidisplay=findViewById(R.id.BMIdisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentLayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);
        mbmi=Float.toString(intbmi);

        if(intbmi<16) {
            mbmicategory.setText("extremely thin");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cross);
        }

        else if(intbmi<16.9 && intbmi>16) {
            mbmicategory.setText("moderately thin");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cross);
        }

        else if(intbmi<18.4 && intbmi>17) {
            mbmicategory.setText("mildly thin");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cross);
        }


        else if(intbmi<25 && intbmi>18.4) {
            mbmicategory.setText("normal");
            mimageview.setImageResource(R.drawable.correct);
        }

        else if(intbmi<29.4 && intbmi>25) {
            mbmicategory.setText("overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warninge);
        }
      else
          {
            mbmicategory.setText("obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warninge);
        }

      mgender.setText(intent.getStringExtra("gender"));
      mbmidisplay.setText(mbmi);

        getSupportActionBar().hide();
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,Bmi.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
