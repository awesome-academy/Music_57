package vn.framgia.phamthehung.soundcloud.ui.genre;

import java.util.List;

import vn.framgia.phamthehung.soundcloud.data.model.Genre;
import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.data.repository.TrackRepository;
import vn.framgia.phamthehung.soundcloud.data.source.TrackDataSource;
import vn.framgia.phamthehung.soundcloud.util.StringUtil;

public class GenrePresenter implements GenreContract.Presenter {
    private TrackRepository mTrackRepository;
    private GenreContract.View mView;

    public GenrePresenter(TrackRepository trackRepository, GenreContract.View view) {
        mTrackRepository = trackRepository;
        mView = view;
    }

    @Override
    public void getTracks(Genre genre) {
        String api = StringUtil.initGenreApi(genre.getKey());
        mTrackRepository.getTracks(api, new TrackDataSource.DataCallback<Track>() {
            @Override
            public void onSuccess(List<Track> data) {
                mView.loadTracksSuccess(data);
            }

            @Override
            public void onFail(String message) {
                mView.loadTrackFailure(message);
            }
        });
    }
}
