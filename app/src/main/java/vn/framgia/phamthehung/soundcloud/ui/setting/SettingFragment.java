package vn.framgia.phamthehung.soundcloud.ui.setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.framgia.phamthehung.soundcloud.R;

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstaneState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    public static Fragment newInstance() {
        Fragment fragment = new SettingFragment();
        return fragment;
    }

}
