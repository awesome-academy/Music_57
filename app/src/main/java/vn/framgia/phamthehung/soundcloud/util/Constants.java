package vn.framgia.phamthehung.soundcloud.util;

public class Constants {
    public static final String BASE_URL_GENRE
            = "https://api-v2.soundcloud.com/charts?kind=top&genre=%s&client_id=%s&limit=%d&offset=%d";
    public static final int LIMIT = 50;
    public static final int OFFSET = 0;
    public static final String PARAMETER_ID = "?client_id=";
    public static final String STRING_FORMAT = "%s%s";
}
