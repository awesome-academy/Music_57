package vn.framgia.phamthehung.soundcloud.ui.genre;

import java.util.List;

import vn.framgia.phamthehung.soundcloud.data.model.Genre;
import vn.framgia.phamthehung.soundcloud.data.model.Track;

public class GenreContract {
    interface View {
        void loadTracksSuccess(List<Track> track);
        void loadTrackFailure(String message);
    }

    interface Presenter {
        void getTracks(Genre genre);
    }
}
