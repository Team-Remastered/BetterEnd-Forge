package ru.betterend.bclib.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModUtil {

    public static int convertModVersion(String version) {
        if (version.isEmpty()) {
            return 0;
        }
        try {
            int res = 0;
            final String semanticVersionPattern = "(\\d+)\\.(\\d+)(\\.(\\d+))?\\D*";
            final Matcher matcher = Pattern.compile(semanticVersionPattern)
                    .matcher(version);
            if (matcher.find()) {
                if (matcher.groupCount() > 0)
                    res = matcher.group(1) == null ? 0 : ((Integer.parseInt(matcher.group(1)) & 0xFF) << 22);
                if (matcher.groupCount() > 1)
                    res |= matcher.group(2) == null ? 0 : ((Integer.parseInt(matcher.group(2)) & 0xFF) << 14);
                if (matcher.groupCount() > 3)
                    res |= matcher.group(4) == null ? 0 : Integer.parseInt(matcher.group(4)) & 0x3FFF;
            }

            return res;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String convertModVersion(int version) {
        int a = (version >> 22) & 0xFF;
        int b = (version >> 14) & 0xFF;
        int c = version & 0x3FFF;
        return String.format(Locale.ROOT, "%d.%d.%d", a, b, c);
    }

}
