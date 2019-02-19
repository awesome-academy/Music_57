package vn.framgia.phamthehung.soundcloud.ui.discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;
import vn.framgia.phamthehung.soundcloud.ui.setting.SettingFragment;

public class DiscoverFragment extends Fragment {
    List<Genre> mGenres = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        mGenres.add(new Genre(getString(R.string.title_all_music),R.drawable.genre));
        mGenres.add(new Genre(getString(R.string.title_all_audio),R.drawable.genre_1));
        mGenres.add(new Genre(getString(R.string.title_alternativerock),R.drawable.genre_2));
        mGenres.add(new Genre(getString(R.string.title_ambient),R.drawable.genre_4));
        mGenres.add(new Genre(getString(R.string.title_classical),R.drawable.genre_5));
        mGenres.add(new Genre(getString(R.string.title_country),R.drawable.genre_3));
        DiscoverAdapter discoverAdapter = new DiscoverAdapter(getActivity(),mGenres);
        recyclerView.setAdapter(discoverAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    public static Fragment newInstance() {
        Fragment fragment = new DiscoverFragment();
        return fragment;
    }
}
