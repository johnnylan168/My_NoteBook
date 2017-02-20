package tw.lan.my_notebook;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView item_list;
    private TextView show_app_name;
    ArrayList<String> data = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processView();
        processController();

        data.add("關於Android Tutorial的事情");
        data.add("一隻非常可愛的小狗狗!");
        data.add("一首非常好聽的音樂！");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        item_list.setAdapter(adapter);
    }

    private void processView() {
        item_list = (ListView) findViewById(R.id.item_list);
        show_app_name = (TextView) findViewById(R.id.show_app_name);
    }

    private void processController() {
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent("tw.lan.my_notebook.EDIT_ITEM");
                intent.putExtra("position", position);
                intent.putExtra("titleText", data.get(position));

                startActivityForResult(intent, 1);
            }
        };

        AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Long: " + data.get(position), Toast.LENGTH_LONG).show();
                return true;
            }
        };

        item_list.setOnItemClickListener(itemListener);
        item_list.setOnItemLongClickListener(itemLongListener);

        View.OnLongClickListener listener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder d =
                        new AlertDialog.Builder(MainActivity.this);
                d.setTitle(R.string.app_name)
                        .setMessage(R.string.about)
                        .show();
                return false;
            }
        };

        show_app_name.setOnLongClickListener(listener);
    }

    public void aboutApp(View v)
    {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void clickMenuItem(MenuItem item)
    {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case R.id.search_item:
                break;
            case R.id.add_item:
                Intent intent = new Intent("tw.lan.my_notebook.ADD_ITEM");
                startActivityForResult(intent, 0);
                break;
            case R.id.revert_item:
                break;
            case R.id.delete_item:
                break;
            case R.id.googleplus_item:
                break;
            case R.id.facebook_item:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
        String titleText = data.getStringExtra("titleText");
        if (requestCode == 0) {
                this.data.add(titleText);
                adapter.notifyDataSetChanged();
        }else if (requestCode == 1) {
                int position = data.getIntExtra("position", -1);
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                if (position != -1) {
                    this.data.set(position, titleText);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

}
