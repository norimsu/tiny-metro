package io.naraplatform.share.util.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// CSV : Comma Separated Value
public class CsvUtil {
    //
    private static final char CSV_SPERATOR = ',';

    public static String toCsv(List<String> list) {
        //
        if (list == null || list.size() <= 0) return null;
        return StringUtil.join(list, CSV_SPERATOR);
    }

    public static List<String> toList(String commaSperatedValues) {
        //
        List<String> results = new ArrayList<>();
        if (commaSperatedValues != null && !commaSperatedValues.isEmpty()) {
            results.addAll(Arrays.asList(StringUtil.split(commaSperatedValues, CSV_SPERATOR)));
        }
        return results;
    }
}
