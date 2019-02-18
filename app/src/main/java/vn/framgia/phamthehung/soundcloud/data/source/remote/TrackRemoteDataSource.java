package vn.framgia.phamthehung.soundcloud.data.source.remote;

import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;

public class TrackRemoteDataSource implements TrackDataSource.Remote {
    private static TrackRemoteDataSource sInstance;

    private TrackRemoteDataSource() {
    }

    public static synchronized TrackRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new TrackRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getTracks(String api, DataCallback<Track> callback) {
        new TrackAsyncTask(callback).execute(api);
    }
}
