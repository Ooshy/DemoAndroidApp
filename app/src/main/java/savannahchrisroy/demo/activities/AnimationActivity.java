package savannahchrisroy.demo.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import savannahchrisroy.demo.R;


public class AnimationActivity extends android.support.v7.app.AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        ImageView spaceshipImage = (ImageView) findViewById(R.id.imageView);
        spaceshipImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hyperspace_jump);
                v.startAnimation(hyperspaceJumpAnimation);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animation, menu);
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
