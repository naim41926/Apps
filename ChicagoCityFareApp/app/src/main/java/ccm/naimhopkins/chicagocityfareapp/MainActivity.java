package ccm.naimhopkins.chicagocityfareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double distInMiles;
    double milesRate = 3.25;
    double initialFee = 3.00;
    double totalCost;
    String groupChoice;
    String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText distance=(EditText)findViewById(R.id.txtDistance);
        final Spinner group=(Spinner)findViewById(R.id.txtGroup);
        Button Calculate =(Button)findViewById(R.id.btnCalcFare);
        Calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result =((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                distInMiles = Double.parseDouble(distance.getText().toString());
                totalCost = (milesRate * distInMiles) + initialFee;
                DecimalFormat distancef = new DecimalFormat("##.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Your fare for a "+groupChoice+ "miles is estimated to cost around" + distancef.format(totalCost));

            }
        });

    }
}
