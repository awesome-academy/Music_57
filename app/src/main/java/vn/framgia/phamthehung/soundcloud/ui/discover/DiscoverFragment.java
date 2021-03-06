package vn.framgia.phamthehung.soundcloud.ui.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;
import vn.framgia.phamthehung.soundcloud.ui.genre.GenreActivity;

public class DiscoverFragment extends Fragment implements DiscoverAdapter.OnItemClickListener {
    private List<Genre> mGenres;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        mGenres = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        mGenres.add(new Genre(getString(R.string.key_all_music)
                ,getString(R.string.title_all_music),R.drawable.genre));
        mGenres.add(new Genre(getString(R.string.key_all_audio)
                ,getString(R.string.title_all_audio),R.drawable.genre_1));
        mGenres.add(new Genre(getString(R.string.key_alternativerock)
                ,getString(R.string.title_alternativerock),R.drawable.genre_2));
        mGenres.add(new Genre(getString(R.string.key_ambient)
                ,getString(R.string.title_ambient),R.drawable.genre_4));
        mGenres.add(new Genre(getString(R.string.key_classical)
                ,getString(R.string.title_classical),R.drawable.genre_5));
        mGenres.add(new Genre(getString(R.string.key_country)
                ,getString(R.string.title_country),R.drawable.genre_3));
        DiscoverAdapter discoverAdapter = new DiscoverAdapter(getActivity(), mGenres, this);
        recyclerView.setAdapter(discoverAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    public static Fragment newInstance() {
        Fragment fragment = new DiscoverFragment();
        return fragment;
    }

    @Override
    public void onDataGenre(Genre genre) {
        Intent intent = GenreActivity.getIntent(getActivity(), genre);
        startActivity(intent);
    }

}
