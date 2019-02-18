package vn.framgia.phamthehung.soundcloud.data.source.remote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;

public class TrackAsyncTask extends BaseAsyncTask {
    private static final String ARTWORK_URL = "artwork_url";
    private static final String COLLECTION = "collection";
    public static final String ID = "id";
    private static final String KEY_USER = "user";
    private static final String KEY_USER_NAME = "username";
    private static final String TITLE = "title";
    private static final String TRACK = "track";
    private static final String DOWNLOADABLE = "downloadable";
    private static final String DOWNLOAD_URL = "download_url";

    public TrackAsyncTask(TrackDataSource.DataCallback<Track> callback) {
        super(callback);
    }

    @Override
    public List convertJson(String jsonString) {
        List<Track> tracks = new ArrayList<>();
        try {
            JSONObject result = new JSONObject(jsonString);
            JSONArray collection = result.getJSONArray(COLLECTION);
            for (int i = 0; i < collection.length(); i++) {
                JSONObject trackInfo = collection.getJSONObject(i);
                JSONObject track = trackInfo.getJSONObject(TRACK);
                int id = track.getInt(ID);
                String title = track.getString(TITLE);
                String artworkUrl = track.getString(ARTWORK_URL);
                String artist = track.getJSONObject(KEY_USER)
                        .getString(KEY_USER_NAME);
                boolean isDownloadable = track.getBoolean(DOWNLOADABLE);
                String downloadUrl = track.getString(DOWNLOAD_URL);
                Track trackObject = new Track(id, title, artist);
                tracks.add(trackObject);
            }
        } catch (JSONException e) {
            mException = e;
        }
        return tracks;
    }
}
