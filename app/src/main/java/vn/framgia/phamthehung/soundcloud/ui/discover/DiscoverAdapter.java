package vn.framgia.phamthehung.soundcloud.ui.discover;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Genre;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {
    private List<Genre> mGenres;
    private LayoutInflater mLayoutInflater;

    public DiscoverAdapter(Context context, List<Genre> genres) {
        mLayoutInflater = LayoutInflater.from(context);
        mGenres = genres;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_genre, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mGenres.get(i));
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameGenre;
        private ImageView mImageGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameGenre = itemView.findViewById(R.id.text_genre);
            mImageGenre = itemView.findViewById(R.id.image_genre);
        }

        public void bindData(Genre genre) {
            mNameGenre.setText(genre.getName());
            Glide.with(itemView).load(genre.getImage()).into(mImageGenre);
        }
    }
}
