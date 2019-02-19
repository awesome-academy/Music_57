package vn.framgia.phamthehung.soundcloud;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import vn.framgia.phamthehung.soundcloud.ui.discover.DiscoverAdapter;
import vn.framgia.phamthehung.soundcloud.ui.discover.DiscoverFragment;
import vn.framgia.phamthehung.soundcloud.ui.personal.PersonalFragment;
import vn.framgia.phamthehung.soundcloud.ui.setting.SettingFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new DiscoverFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.discover:
                fragment = DiscoverFragment.newInstance();
                break;
            case R.id.personal:
                fragment = new PersonalFragment();
                break;
            case R.id.setting:
                fragment = new SettingFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
        return true;
    }

}
