package vn.framgia.phamthehung.soundcloud.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.service.PlayMusicService;

public class PlayMusicActivity extends AppCompatActivity {
    public static final String ARGUMENT_LIST_TRACK = " ARGUMENT_LIST_TRACK";
    public List<Track> mTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initToolBar();
        Intent intent = new Intent(this, PlayMusicService.class);
        startService(intent);

    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.null_string);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public static Intent getIntent(Context context, List<Track> track) {
        Intent intent = new Intent(context, PlayMusicActivity.class);
        intent.putParcelableArrayListExtra(ARGUMENT_LIST_TRACK, (ArrayList<? extends Parcelable>) track);
        return intent;
    }

    public void  getDataIntent() {
        Intent intent = getIntent();
        mTracks = intent.getParcelableArrayListExtra(ARGUMENT_LIST_TRACK);
    }
}
