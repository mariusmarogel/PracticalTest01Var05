package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private Button verify, cancel;
    String value;
    TextView textPrimit;

    private VerifyButtonListener verifyButtonListener = new VerifyButtonListener();
    private CancelButtonListener cancelButtonListener = new CancelButtonListener();

    private class CancelButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(getApplicationContext(), PracticalTest01Car05MainActivity.class);
            myIntent.putExtra("sablon",  String.valueOf(textPrimit.getText()));
            setResult(2, myIntent);
            finish();
        }
    }

    private class VerifyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(getApplicationContext(), PracticalTest01Car05MainActivity.class);
            myIntent.putExtra("sablon", String.valueOf(textPrimit.getText()));
            setResult(1, myIntent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");


        textPrimit = (TextView) (findViewById(R.id.text_primit));
        verify = (Button) (findViewById(R.id.verify));
        cancel = (Button) (findViewById(R.id.cancel));

        textPrimit.setText(value);

        verify.setOnClickListener(verifyButtonListener);
        cancel.setOnClickListener(cancelButtonListener);
    }
}