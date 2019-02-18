package vn.framgia.phamthehung.soundcloud.data.source.local;

import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;

public class TrackLocalDataSoucre implements TrackDataSource.Local {
    private static TrackLocalDataSoucre sInstance;

    private TrackLocalDataSoucre() {
    }

    public static synchronized TrackLocalDataSoucre getInstance() {
        if (sInstance == null) {
            sInstance = new TrackLocalDataSoucre();
        }
        return sInstance;
    }

    @Override
    public void getOfflineTracks(TrackDataSource.DataCallback<Track> callback) {

    }
}
