package vn.framgia.phamthehung.soundcloud.ui.genre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Track;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {
    private List<Track> mTracks;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListenerTracks mListener;

    public interface OnItemClickListenerTracks {
        void onTrackClick(Track track);

        void onMoreClick(Track track);
    }

    public GenreAdapter(Context context, List<Track> tracks, OnItemClickListenerTracks listener) {
        mLayoutInflater = LayoutInflater.from(context);
        mTracks = tracks;
        mListener = listener;
    }

    @NonNull
    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_track, viewGroup, false);
        return new GenreAdapter.ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(mTracks.get(i), ++i);
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextCount;
        private TextView mTextName;
        private TextView mArtist;
        private ImageView mImage;
        private Track mTrack;
        private OnItemClickListenerTracks mListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListenerTracks listener) {
            super(itemView);
            mListener = listener;
            mTextCount = itemView.findViewById(R.id.text_count);
            mTextName = itemView.findViewById(R.id.text_name_track);
            mArtist = itemView.findViewById(R.id.text_artist_track);
            mImage = itemView.findViewById(R.id.image_more);
            itemView.setOnClickListener(this);
        }

        public void bindData(final Track track, int i) {
            mTrack = track;
            mTextCount.setText(String.valueOf(i));
            mTextName.setText(track.getTitle());
            mArtist.setText(track.getArtist());
            mImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_more:
                    mListener.onMoreClick(mTrack);
                    break;
                default:
                    mListener.onTrackClick(mTrack);
            }
        }
    }

}
