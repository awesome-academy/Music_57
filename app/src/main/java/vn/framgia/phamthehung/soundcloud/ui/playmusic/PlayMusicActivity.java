package vn.framgia.phamthehung.soundcloud.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

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
        Intent intent = new Intent(this, PlayMusicService.class);
        startService(intent);
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
