package vn.framgia.phamthehung.soundcloud.ui.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.ui.discover.DiscoverFragment;
import vn.framgia.phamthehung.soundcloud.ui.personal.PersonalFragment;
import vn.framgia.phamthehung.soundcloud.ui.setting.SettingFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new DiscoverFragment()).commit();
        checkInternetConnection();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.discover:
                fragment = DiscoverFragment.newInstance();
                break;
            case R.id.personal:
                fragment = PersonalFragment.newInstance();
                break;
            case R.id.setting:
                fragment = SettingFragment.newInstance();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
        return true;
    }
    private boolean checkInternetConnection() {
        ConnectivityManager connManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(this, getString(R.string.msg_no_network), Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isConnected()) {
            Toast.makeText(this, getString(R.string.msg_not_connected), Toast.LENGTH_LONG).show();
            return false;
        }

        if (!networkInfo.isAvailable()) {
            Toast.makeText(this, getString(R.string.msg_not_available), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
