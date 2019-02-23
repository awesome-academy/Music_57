package vn.framgia.phamthehung.soundcloud.ui.detailtrack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.data.model.Track;
import vn.framgia.phamthehung.soundcloud.util.StringUtil;

public class DetailTrackFragment extends BottomSheetDialogFragment {
    public static final String ARGUMENT_TRACK = "ARGUMENT_TRACK";
    public static final int NUMBER_1 = 1000;
    public static final int NUMBER_2 = 1000000;
    private Track mTrack;
    private TextView mTextTrack;
    private TextView mTextArtist;
    private ImageView mImageTrack;
    private TextView mTextCountFavorite;
    private TextView mPlayMore;
    private TextView mTextComment;
    private TextView mTextDownload;
    private ImageView mImageDownload;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_track, container, false);
        initView(view);
        getData(view);
        return view;
    }

    private void getData(View view) {
        Bundle bundle = getArguments();
        mTrack = bundle.getParcelable(ARGUMENT_TRACK);
        mTextTrack.setText(mTrack.getTitle());
        mTextArtist.setText(mTrack.getArtist());
        Glide.with(view).load(mTrack.getArtworkUrl()).into(mImageTrack);
        mTextCountFavorite.setText(StringUtil.initString(
                String.valueOf(mTrack.getLikesCount() / NUMBER_1),
                getString(R.string.msg_k)));
        mPlayMore.setText(StringUtil.initString(
                String.valueOf(mTrack.getPlaybackCount() / NUMBER_2),
                getString(R.string.msg_tr)));
        mTextComment.setText(StringUtil.initString(
                String.valueOf(mTrack.getCommentCount() / NUMBER_1),
                getString(R.string.msg_k)));
        if (!mTrack.isDownloadable()) {
            mTextDownload.setVisibility(View.GONE);
            mImageDownload.setVisibility(View.GONE);
        }
    }

    private void initView(View view) {
        mTextTrack = view.findViewById(R.id.text_track_more);
        mTextArtist = view.findViewById(R.id.text_artist_more);
        mImageTrack = view.findViewById(R.id.image_artwork_more);
        mTextCountFavorite = view.findViewById(R.id.text_count_favorite);
        mPlayMore = view.findViewById(R.id.text_play_more);
        mTextComment = view.findViewById(R.id.text_comment);
        mTextDownload = view.findViewById(R.id.text_download);
        mImageDownload = view.findViewById(R.id.image_download);
    }

    public static DetailTrackFragment newInstance(Track track) {
        DetailTrackFragment fragment = new DetailTrackFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_TRACK, track);
        fragment.setArguments(bundle);
        return fragment;
    }
}
