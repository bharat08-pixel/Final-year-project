package my.edu.utar.finalyear1;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
public class DiabetesInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        setContentView(R.layout.activity_diabetes_info);
    }
    public void dtype(View view){
        Intent typeIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/diabetes/basics/diabetes.html"));
        startActivity(typeIntent);
    }
    public void stype(View view){
        Intent stypeIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/diabetes/basics/symptoms.html"));
        startActivity(stypeIntent);
    }
    public void diettype(View view){
        Intent dtypeIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.webmd.com/diabetes/ss/slideshow-best-diabetes-diets"));
        startActivity(dtypeIntent);
    }
    public void reversetype(View view){
        Intent rtypeIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.diabetes.co.uk/reversing-diabetes.html"));
        startActivity(rtypeIntent);
    }
}