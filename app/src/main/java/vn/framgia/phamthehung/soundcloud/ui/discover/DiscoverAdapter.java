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
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDataGenre(Genre genre);
    }

    public DiscoverAdapter(Context context, List<Genre> genres, OnItemClickListener listener) {
        mLayoutInflater = LayoutInflater.from(context);
        mGenres = genres;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_genre, viewGroup, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mGenres.get(i));
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameGenre;
        private ImageView mImageGenre;
        private Genre mGenre;
        private OnItemClickListener mOnItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mOnItemClickListener = listener;
            mNameGenre = itemView.findViewById(R.id.text_genre);
            mImageGenre = itemView.findViewById(R.id.image_genre);
        }

        public void bindData(final Genre genre) {
            mGenre = genre;
            mNameGenre.setText(genre.getName());
            Glide.with(itemView).load(genre.getImage()).into(mImageGenre);
            mImageGenre.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_genre:
                    mOnItemClickListener.onDataGenre(mGenre);
                    break;
                default:
                    break;
            }
        }

    }

}
