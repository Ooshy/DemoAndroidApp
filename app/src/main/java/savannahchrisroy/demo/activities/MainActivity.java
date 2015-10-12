package savannahchrisroy.demo.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import savannahchrisroy.demo.R;
import savannahchrisroy.demo.pojo.Topic;

public class MainActivity extends android.support.v7.app.AppCompatActivity {

    ListView DemoSelectionListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDemoListView();

    }

    private void setupDemoListView() {
        final ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Animations", AnimationActivity.class));
        topics.add(new Topic("Camera", CameraActivity.class));
        topics.add(new Topic("Information Passing", InformationPassingActivity.class));
        topics.add(new Topic("Music", MusicActivity.class));
        topics.add(new Topic("Web", WebActivity.class));

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, topics);

        final ListView demoSelectionListView = (ListView) findViewById(R.id.listView);
        demoSelectionListView.setAdapter(adapter);

        demoSelectionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final Topic topic = (Topic) parent.getItemAtPosition(position);
                final Intent intent = new Intent(getApplicationContext(), topic.getActivity());
                startActivity(intent);
            }
        });

    }
    private static class ViewHolder {
        private TextView itemView;
    }
    private class StableArrayAdapter extends ArrayAdapter<Topic> {
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.itemView = (TextView) convertView.findViewById(android.R.id.text1);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Topic item = getItem(position);
            if (item!= null) {
                viewHolder.itemView.setText(String.format("%s", item.getName()));
            }

            return convertView;
        }

        HashMap<Topic, Integer> mIdMap;
        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<Topic> topics) {
            super(context, textViewResourceId, topics);
            mIdMap = new HashMap<>();
            for (int i = 0; i < topics.size(); ++i) {
                mIdMap.put(topics.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            Topic topic = getItem(position);
            return mIdMap.get(topic);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
