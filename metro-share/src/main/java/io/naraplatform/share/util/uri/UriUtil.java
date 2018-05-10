package io.naraplatform.share.util.uri;


public class UriUtil {
    //
    // TODO RegExpression
    public static boolean match(String uri, String pattern) {
        //
        if (pattern == null || uri == null) return false;
        if (uri.startsWith("/")) uri = uri.substring(1);
        if (uri.endsWith("/")) uri = uri.substring(0, uri.length() - 1);
        if (pattern.startsWith("/")) pattern = pattern.substring(1);
        if (pattern.endsWith("/")) pattern = pattern.substring(0, pattern.length() - 1);

        String[] uriSplit = uri.split("/");
        String[] patternSplit = pattern.split("/");

        if (uriSplit.length != patternSplit.length) return false;
        for(int i = 0 ; i < uriSplit.length ; i++) {
            if (patternSplit[i].equals("%s")) continue;
            if (patternSplit[i].startsWith("{") && patternSplit[i].endsWith("}")) continue;
            if (!uriSplit[i].equals(patternSplit[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean startsWith(String uri, String pattern) {
        //
        if (pattern == null || uri == null) return false;
        if (uri.startsWith("/")) uri = uri.substring(1);
        if (uri.endsWith("/")) uri = uri.substring(0, uri.length() - 1);
        if (pattern.startsWith("/")) pattern = pattern.substring(1);
        if (pattern.endsWith("/")) pattern = pattern.substring(0, pattern.length() - 1);

        String[] uriSplit = uri.split("/");
        String[] patternSplit = pattern.split("/");

        for(int i = 0 ; i < patternSplit.length ; i++) {
            if (patternSplit[i].equals("%s")) continue;
            if (patternSplit[i].startsWith("{") && patternSplit[i].endsWith("}")) continue;
            if (!uriSplit[i].equals(patternSplit[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String uri = "board-api/boards/17-0001-001/postings/17-0001-001-0002/replies/";
        String pattern = "/board-api/boards/{boardId}/postings/{postingId}/replies";
        String pattern2 = "/board-api/boards/%s/postings/%s/replies";

        System.out.println(UriUtil.match(uri, pattern));
        System.out.println(UriUtil.match(uri, pattern2));

        String pattern3 = "/board-api/boards/{boardId}/";
        String pattern4 = "/board-api/boards/%s/";

        System.out.println(UriUtil.startsWith(uri, pattern3));
        System.out.println(UriUtil.startsWith(uri, pattern4));
    }
}
