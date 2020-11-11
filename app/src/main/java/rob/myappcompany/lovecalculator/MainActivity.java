package rob.myappcompany.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText yourNameText,yourPartnerName;
    private Button calculateBtn;
    private TextView messege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yourNameText = findViewById(R.id.YourNameText);
        yourPartnerName = findViewById(R.id.PertnerNameText);
        calculateBtn = findViewById(R.id.CalculateBtn);
        messege = findViewById(R.id.textView);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String yourName = yourNameText.getText().toString();
                String partnerName = yourPartnerName.getText().toString();

                String sum = yourName+partnerName;
                sum = sum.toLowerCase();
                int value = sum.hashCode();

                Random random = new Random(value);
                int result = random.nextInt(100+1);

                if (yourName.equals("") || partnerName.equals("")){

                    Toast.makeText(MainActivity.this,"Enter names correctly",Toast.LENGTH_SHORT).show();
                }else {
                    calculateBtn.setText(result+" %");
                    messege.setText("Best Wishes For "+yourName+" & "+partnerName+"\n"+"Yours love score is "+result+" % ");
                }

            }
        });



    }
}