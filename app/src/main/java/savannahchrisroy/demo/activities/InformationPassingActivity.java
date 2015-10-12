package savannahchrisroy.demo.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import savannahchrisroy.demo.R;

public class InformationPassingActivity extends android.support.v7.app.AppCompatActivity {
    public static final int INFORMATION_FOR_RESULT = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_passing);

        Button passingInformation = (Button) findViewById(R.id.enterInformationButton);
        passingInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent getInformation = new Intent(getApplicationContext(), ResultActivity.class);
                startActivityForResult(getInformation, INFORMATION_FOR_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INFORMATION_FOR_RESULT && resultCode == RESULT_OK) {
            if (data.hasExtra("RESULT_TEXT")) {
                String resultText = data.getStringExtra("RESULT_TEXT");
                TextView informationReceivedText = (TextView) findViewById(R.id.informationReceivedText);
                informationReceivedText.setText("Data Received:\n" + resultText);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information_passing, menu);
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
}
