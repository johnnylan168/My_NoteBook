package tw.lan.my_notebook;

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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] data = {
                "關於Android Tutorial的事情",
                "一隻非常可愛的小狗狗!",
                "一首非常好聽的音樂！"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView item_list = (ListView) findViewById(R.id.item_list);
        item_list.setAdapter(adapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        data[position], Toast.LENGTH_LONG).show();
            }
        };

        AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Long: " + data[position], Toast.LENGTH_LONG).show();
                return true;
            }
        };

        item_list.setOnItemClickListener(itemListener);
        item_list.setOnItemLongClickListener(itemLongListener);
        TextView show_app_name = (TextView) findViewById(R.id.show_app_name);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d =
                        new AlertDialog.Builder(MainActivity.this);
                d.setTitle(R.string.app_name)
                        .setMessage(R.string.about)
                        .show();
            }
        };

        show_app_name.setOnClickListener(listener);
    }

    // 有宣告onClickListener監聽物件時，layout onclick則失去作用
    // ex:TextView的aboutApp OnClick 和 OnClickListener
    public void aboutApp(View v)
    {
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();
    }

    public void clickMenuItem(MenuItem item)
    {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case R.id.search_item:
                break;
            case R.id.add_item:
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
        new AlertDialog.Builder(this)
                .setTitle("MenuItem Test")
                .setMessage(item.getTitle())
                .setIcon(item.getIcon())
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
