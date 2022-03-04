package com.example.test_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewDetailActivity extends AppCompatActivity {
    String title,desc, imageUrl,url,content;
    private TextView titleTV, subDescriptionTV, contentTV;
    private ImageView newsIV;
    private Button readFullDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_detail);
        Intent i = getIntent();Log.d("abc","24 new detail activity");
        title = i.getStringExtra("title");
        desc = i.getStringExtra("desc");
        Log.d("abc",desc);
        imageUrl = i.getStringExtra("image");
        url = i.getStringExtra("url");
        content = i.getStringExtra("content");
        Log.d("abc","30 new detail activity");
        titleTV =findViewById(R.id.TVDetail);
        subDescriptionTV =findViewById(R.id.TVSubDetail);
        contentTV =findViewById(R.id.TVContentDetail);
        readFullDetail = findViewById(R.id.ButtonFullDetail);
        newsIV = findViewById(R.id.IVDetail);
        Log.d("abc","36 new detail activity");
        titleTV.setText(title);
        Log.d("abc","38 new detail activity");
        //
        subDescriptionTV.setText(desc);
        Log.d("abc","40 new detail activity");

        contentTV.setText(content);
        Log.d("abc","42 new detail activity");
        Picasso.get().load(imageUrl).into(newsIV);
        Log.d("abc","44 new detail activity");
        readFullDetail.setOnClickListener(view -> {
          Intent intent =new Intent(Intent.ACTION_VIEW);
          intent.setData(Uri.parse(url));
          startActivity(intent);
        });
    }
}