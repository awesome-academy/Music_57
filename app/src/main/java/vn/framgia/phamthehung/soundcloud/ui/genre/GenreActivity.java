package vn.framgia.phamthehung.soundcloud.ui.genre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;

public class GenreActivity extends AppCompatActivity {
    public static final String GENRE_KEY = "GENRE_KEY";
    private ImageView mImageView;
    private TextView mTextView;
    private Genre mGenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        initActionBar();
        initView();

    }

    public static Intent getIntent(Context context, Genre genre) {
        Intent intent = new Intent(context, GenreActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(GENRE_KEY, genre);
        intent.putExtras(bundle);
        return intent;
    }

    public void getDataIntent() {
        Bundle bundle = getIntent().getExtras();
        mGenre = bundle.getParcelable(GENRE_KEY);
        mTextView.setText(mGenre.getName());
        mImageView.setImageResource(mGenre.getImage());
    }

    public void initView() {
        mImageView = findViewById(R.id.image_genres);
        mTextView = findViewById(R.id.text_shuffle_play);
        getDataIntent();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_genre, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.null_string);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
