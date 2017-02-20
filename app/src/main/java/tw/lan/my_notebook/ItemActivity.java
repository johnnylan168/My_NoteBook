package tw.lan.my_notebook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    private EditText title_text;
    private EditText content_text;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        processView();

        Intent intent = getIntent();
        String action = intent.getAction();

        if (action.equals("tw.lan.my_notebook.EDIT_ITEM")) {
            String titleText = intent.getStringExtra("titleText");
            position = intent.getIntExtra("position", -1);
            title_text.setText(titleText);
        }
    }

    private void processView() {
        title_text = (EditText)findViewById(R.id.title_text);
        content_text = (EditText)findViewById(R.id.content_text);
    }

    public void onSubmit(View v)
    {
        if (v.getId() == R.id.ok_teim) {
            String titleText = title_text.getText().toString();
            String contentText = content_text.getText().toString();

            Intent result = new Intent();
            result.putExtra("titleText", titleText);
            result.putExtra("contentText", contentText);
            result.putExtra("position", position);

            setResult(RESULT_OK, result);
        }

        finish();
    }

    public void clickFunction(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.take_picture:
                break;
            case R.id.record_sound:
                break;
            case R.id.set_location:
                break;
            case R.id.set_alarm:
                break;
            case R.id.select_color:
                break;
        }
    }
}
