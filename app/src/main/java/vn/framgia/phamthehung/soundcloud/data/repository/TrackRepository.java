package vn.framgia.phamthehung.soundcloud.data.repository;

import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;
import vn.framgia.phamthehung.soundcloud.data.source.remote.TrackRemoteDataSource;

public class TrackRepository implements TrackDataSource.Remote {
    private static TrackRepository sInstance;
    private TrackDataSource.Remote mRemote;

    private TrackRepository(TrackDataSource.Remote remote) {
        mRemote = remote;
    }

    public static synchronized TrackRepository getsInstance(TrackRemoteDataSource remote) {
        if (sInstance == null) {
            sInstance = new TrackRepository(remote);
        }
        return sInstance;
    }

    @Override
    public void getTracks(String api, DataCallback<Track> callback) {
        mRemote.getTracks(api, callback);
    }
}
