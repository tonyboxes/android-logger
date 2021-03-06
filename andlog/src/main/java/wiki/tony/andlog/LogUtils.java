package wiki.tony.andlog;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * log util
 *
 * Created by Tony on 4/12/16.
 */
public class LogUtils {
    public final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String nowTime() {
        return DATE_FORMATTER.format(Calendar.getInstance().getTime());
    }

    public static boolean deleteFiles(File file) {
        // check
        if (file == null) {
            return false;
        } else if (!file.exists()) {
            return true;
        }
        // delete all
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                if (child.isFile()) {
                    child.delete();
                } else if (child.isDirectory()) {
                    deleteFiles(child);
                }
            }
        }
        return file.delete();
    }
}
