package vn.framgia.phamthehung.soundcloud.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;
import vn.framgia.phamthehung.soundcloud.ui.genre.GenreActivity;

public class PlayMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, PlayMusicActivity.class);
        return intent;
    }
}
