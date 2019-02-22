package vn.framgia.phamthehung.soundcloud.util;

import vn.framgia.phamthehung.soundcloud.BuildConfig;

public class StringUtil {
    public static String initGenreApi(String keyGenre) {
        return String.format(Constants.BASE_URL_GENRE
                , keyGenre
                , BuildConfig.ApiKey
                , Constants.LIMIT
                , Constants.OFFSET);
    }
}
