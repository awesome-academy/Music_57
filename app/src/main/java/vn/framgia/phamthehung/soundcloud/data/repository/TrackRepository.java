package vn.framgia.phamthehung.soundcloud.data.repository;

import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;

public class TrackRepository implements TrackDataSource.Remote {
    private static TrackRepository sInstance;
    private TrackDataSource.Remote mRemote;

    private TrackRepository(TrackDataSource.Remote remote) {
        mRemote = remote;
    }

    public static synchronized TrackRepository getsInstance() {
        if (sInstance == null) {
            sInstance = new TrackRepository(sInstance);
        }
        return sInstance;
    }

    @Override
    public void getTracks(String api, DataCallback<Track> callback) {
        mRemote.getTracks(api, callback);
    }
}
