package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Car05MainActivity extends AppCompatActivity {

    private int total;

    private Button topleft;
    private Button topright ;
    private Button bottomleft;
    private Button bottomright;
    private Button navigate;
    private Button center;
    private TextView text;

    private TopLeftButtonClickListener topLeftButtonClickListener = new TopLeftButtonClickListener();
    private TopRightButtonClickListener topRightButtonClickListener = new TopRightButtonClickListener();

    private BottomLeftButtonClickListener bottomLeftButtonClickListener = new BottomLeftButtonClickListener();

    private BottomRightButtonClickListener bottomRightButtonClickListener = new BottomRightButtonClickListener();

    private CenterButtonClickListener centerButtonClickListener = new CenterButtonClickListener();

    private NavigateButtonClickListener navigateButtonClickListener = new NavigateButtonClickListener();

    private class NavigateButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(PracticalTest01Car05MainActivity.this, PracticalTest01Var05SecondaryActivity.class);
            myIntent.putExtra("key", String.valueOf(text.getText()));
            startActivity(myIntent);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        text.setText("");
        total = 0;
        if (resultCode == 1 || resultCode == 2) {
            String value = intent.getStringExtra("sablon");
            Toast.makeText(getApplicationContext(), String.valueOf(value), Toast.LENGTH_SHORT).show();
        }

    }

    private class CenterButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            total++;
            String curr = String.valueOf(center.getText());
            String text1 = String.valueOf(text.getText());
            String newText;
            if (text.getText().equals("")) {
                newText = text1 + curr;
            } else {
                newText = text1 + "," + curr;
            }

            text.setText(newText);
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }

    private class BottomRightButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            total++;
            String curr = String.valueOf(bottomright.getText());
            String text1 = String.valueOf(text.getText());
            String newText;
            if (text.getText().equals("")) {
                newText = text1 + curr;
            } else {
                newText = text1 + "," + curr;
            }

            text.setText(newText);
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }

    private class BottomLeftButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            total++;
            String curr = String.valueOf(bottomleft.getText());
            String text1 = String.valueOf(text.getText());
            String newText;
            if (text.getText().equals("")) {
                newText = text1 + curr;
            } else {
                newText = text1 + "," + curr;
            }

            text.setText(newText);
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }
    private class TopRightButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            total++;
            String curr = String.valueOf(topright.getText());
            String text1 = String.valueOf(text.getText());
            String newText;
            if (text.getText().equals("")) {
                newText = text1 + curr;
            } else {
                newText = text1 + "," + curr;
            }

            text.setText(newText);
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }
    private class TopLeftButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            total++;
            String curr = String.valueOf(topleft.getText());
            String text1 = String.valueOf(text.getText());
            String newText;
            if (text.getText().equals("")) {
                newText = text1 + curr;
            } else {
                newText = text1 + "," + curr;
            }

            text.setText(newText);
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("total", String.valueOf(total));
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getString("total") != null) {
           Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
        topleft = (Button) (findViewById(R.id.top_left));
        topright = (Button) (findViewById(R.id.top_right));
        bottomleft = (Button) (findViewById(R.id.bottom_left));
        bottomright = (Button) (findViewById(R.id.bottom_right));
        navigate = (Button) (findViewById(R.id.navigate));
        center = (Button) (findViewById(R.id.center));
        text = (TextView) (findViewById(R.id.text));

        topleft.setOnClickListener(topLeftButtonClickListener);
        topright.setOnClickListener(topRightButtonClickListener);
        bottomleft.setOnClickListener(bottomLeftButtonClickListener);
        bottomright.setOnClickListener(bottomRightButtonClickListener);
        center.setOnClickListener(centerButtonClickListener);

        if ((savedInstanceState != null) && (savedInstanceState.getString("total") != null)) {
            Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();
        }
        navigate.setOnClickListener(navigateButtonClickListener);
        //Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_SHORT).show();

    }
}