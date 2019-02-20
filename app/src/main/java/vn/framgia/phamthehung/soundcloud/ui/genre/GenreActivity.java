package vn.framgia.phamthehung.soundcloud.ui.genre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;

public class GenreActivity extends AppCompatActivity {
    public static final String GENRE_KEY = "GENRE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_genre);
    }

    public static Intent getIntent(Context context, Genre genre) {
        Intent intent = new Intent(context, GenreActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(GENRE_KEY, genre);
        intent.putExtras(bundle);
        return intent;
    }

}
