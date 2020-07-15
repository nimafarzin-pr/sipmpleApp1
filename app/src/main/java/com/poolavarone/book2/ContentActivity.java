package com.poolavarone.book2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.poolavarone.book2.Database.DataBase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView back,sircle;
    CircleImageView image;
    TextView name, field;
    TextViewEx disc;
    com.getbase.floatingactionbutton.FloatingActionButton fab;
    DataBase db;
    int id, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setupViews();
        getandsetData();
        favCondition();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);
    }


    private void setupViews() {
        back = (ImageView) findViewById(R.id.id_back_contentactivity);
        name = (TextView) findViewById(R.id.profesorName_ID);
        field = (TextView) findViewById(R.id.field);
        disc = (TextViewEx) findViewById(R.id.disc_ID_content);


        fab = (FloatingActionButton) findViewById(R.id.float_actionbutton_like);

    }

    private void getandsetData() {
        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("NAME"));
        field.setText(intent.getExtras().getString("FIELD"));
        disc.setText(intent.getExtras().getString("DISC"),true);
        //disc.setText((Html.fromHtml(intent.getExtras().getString("DISC")));
        id = intent.getExtras().getInt("ID");

    }

    @Override
    public void onClick(View v) {

        int viewID = v.getId();
        switch (viewID) {
            case R.id.id_back_contentactivity:
                onBackPressed();
                break;

            case R.id.float_actionbutton_like:

                addorRemovefav();
                break;
        }
    }

    private void favCondition() {
        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);
        if (value == 0) {
            //not favorite
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        } else if (value == 1) {
            //favorite
            fab.setImageResource(R.drawable.ic_favorite_black_24dp);
        }
    }

    private void addorRemovefav() {
        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);
        if (value == 0) {

            db.fav(1,id);
            fab.setImageResource(R.drawable.ic_favorite_black_24dp);
            Toast.makeText(ContentActivity.this, "به لیست علاقه مندی ها اضافه شد.", Toast.LENGTH_SHORT).show();
        } else {
            db.fav(0,id);
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            Toast.makeText(ContentActivity.this, "از لیست علاقه مندی ها حذف شد.", Toast.LENGTH_SHORT).show();
        }

    }
}
