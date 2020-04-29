package com.example.travelog01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView mTitle, mContent, mLocDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView)findViewById(R.id.title);
        mContent = (TextView)findViewById(R.id.content);
        mLocDate = (TextView)findViewById(R.id.loc_date);

        initView();

        //mTitle.setText(getIntent().getExtras().getString("title"));
        //mContent.setText(getIntent().getExtras().getString("content"));
        //mLocDate.setText(getIntent().getExtras().getString("location") + ", " + getIntent().getExtras().getString("date"));
    }
    private void initView() {
        //diaryDao = new DiaryDao(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        //String image = intent.getStringExtra("image");
        String date = intent.getStringExtra("date");
        //String week = intent.getStringExtra("week");
        //String weather = intent.getStringExtra("weather");
        Long id = intent.getLongExtra("id", 0);

        //detailEtTitle.setText(title);
        mTitle.setText(title);
        //detailEtContent.setText(content);
        mContent.setText(content);
        mLocDate.setText(date);
        //detailTvTite.setText(String.format(Constants.FORMAT, date, week, weather));
        //if (image != null || !image.equals("n") || !TextUtils.isEmpty(image)) {
        // File file = new File(image);
        // if (file.exists()) {
        //   detailIvShow.setVisibility(View.VISIBLE);
        // Bitmap bitmap = BitmapFactory.decodeFile(image);
        //detailIvShow.setImageBitmap(bitmap);
        //} else {
        //    detailIvShow.setVisibility(View.GONE);
        //}
        //}
    }
}
