package vn.framgia.phamthehung.soundcloud.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import vn.framgia.phamthehung.soundcloud.R;
import vn.framgia.phamthehung.soundcloud.ui.playmusic.PlayMusicActivity;

public class PlayMusicService extends Service {
    private static final String NAME_CHANNEL = "NAME_CHANNEL";
    private static final String ID_CHANNEL = "ID_CHANNEL";
    public static boolean sIsPlaying;
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION = 1000;
    private static final int CODE_PLAY = 1001;
    private static final int CODE_PAUSE = 1002;
    private static final int CODE_NEXT = 1003;
    private static final int CODE_PREVIOUS = 1004;
    private static final String ACTION_PREVIOUS = "vn.framgia.phamthehung.soundcloud.ACTION_PREVIOUS";
    private static final String ACTION_PLAY = "vn.framgia.phamthehung.soundcloud.ACTION_PLAY";
    private static final String ACTION_PAUSE = "vn.framgia.phamthehung.soundcloud.ACTION_PAUSE";
    private static final String ACTION_STOP = "vn.framgia.phamthehung.soundcloud.ACTION_STOP";
    private static final String ACTION_NEXT = "vn.framgia.phamthehung.soundcloud.ACTION_NEXT";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(NOTIFICATION, buidNotification());
        return START_STICKY;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Notification buidNotification() {
        createNotificationChannel();
        int actionPlayPauseImage;
        PendingIntent playPauseAction;
        if (sIsPlaying) {
            actionPlayPauseImage = R.drawable.ic_pause;
            playPauseAction = getPlayBackAction(CODE_PAUSE);
        } else {
            actionPlayPauseImage = R.drawable.ic_play;
            playPauseAction = getPlayBackAction(CODE_PLAY);
        }
        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent
                        , PendingIntent.FLAG_UPDATE_CURRENT);
//        Bitmap image = (Bitmap) BitmapFactory.decodeFile(String.valueOf(R.drawable.genre));
        Bitmap image = (Bitmap) BitmapFactory.decodeResource(getResources(), R.drawable.genre);
        Notification.Builder builder = new Notification.Builder(this)
                .setShowWhen(false)
                .setStyle(new Notification.MediaStyle())
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setLargeIcon(image)
                .setContentTitle(getString(R.string.title_all_music))
                .setContentText(getString(R.string.title_all_music))
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_previous
                        , getString(R.string.title_previous), getPlayBackAction(CODE_PREVIOUS))
                .addAction(actionPlayPauseImage
                        , getString(R.string.title_play_pause), playPauseAction)
                .addAction(R.drawable.ic_next
                        , getString(R.string.title_next), getPlayBackAction(CODE_NEXT));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(ID_CHANNEL);
        }
        return builder.build();
    }

    private void createNotificationChannel() {
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel channel = new NotificationChannel(ID_CHANNEL, NAME_CHANNEL, importance);
            mNotificationManager.createNotificationChannel(channel);
        }
    }

    private PendingIntent getPlayBackAction(int actionNumber) {
        Intent playBackAction = new Intent(this, PlayMusicActivity.class);
        switch (actionNumber) {
            case CODE_PLAY:
                playBackAction.setAction(ACTION_PLAY);
                return PendingIntent.getService(this, actionNumber, playBackAction, 0);
            case CODE_PAUSE:
                playBackAction.setAction(ACTION_PAUSE);
                return PendingIntent.getService(this, actionNumber, playBackAction, 0);
            case CODE_NEXT:
                playBackAction.setAction(ACTION_NEXT);
                return PendingIntent.getService(this, actionNumber, playBackAction, 0);
            case CODE_PREVIOUS:
                playBackAction.setAction(ACTION_PREVIOUS);
                return PendingIntent.getService(this, actionNumber, playBackAction, 0);
            default:
                break;
        }
        return null;
    }
}
