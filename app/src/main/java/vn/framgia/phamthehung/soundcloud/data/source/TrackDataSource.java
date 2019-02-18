package vn.framgia.phamthehung.soundcloud.data.source;

import java.util.List;

import vn.framgia.phamthehung.soundcloud.data.model.Track;

public interface TrackDataSource {

    interface DataCallback<T> {
        void onSuccess(List<T> data);

        void onFail(String message);
    }

    interface Local {
        void getOfflineTracks(DataCallback<Track> callback);
    }

    interface Remote extends TrackDataSource {
        void getTracks(String api, DataCallback<Track> callback);
    }
}
