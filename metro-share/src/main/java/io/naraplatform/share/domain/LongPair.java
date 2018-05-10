package io.naraplatform.share.domain;

import io.naraplatform.share.util.json.JsonUtil;

import java.util.StringTokenizer;

public class LongPair implements ValueObject {
    //
    private static final String PAIR_TOKEN = ":";
    private long left;
    private long right;

    public LongPair() {

    }

    public LongPair(long left, long right) {
        //
        this.left = left;
        this.right = right;
    }

    public LongPair(String pairString) {
        //
        StringTokenizer tokenizer = new StringTokenizer(pairString, PAIR_TOKEN);
        this.left = Long.valueOf(tokenizer.nextToken());
        this.right = Long.valueOf(tokenizer.nextToken());
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static LongPair getSample() {
        //
        return new LongPair("3:5");
    }

    public static LongPair fromJson(String json) {
        //
        return JsonUtil.fromJson(json, LongPair.class);
    }

    public String toPairString() {
        //
        return String.format("%d:%d", left, right);
    }

    public void increaseLeft() {
        //
        left++;
    }

    public void increaseRight() {
        //
        right++;
    }

    public void decreaseLeft() {
        //
        left--;
    }

    public void decreaseRight() {
        //
        right--;
    }

    public long getLeft() {
        return left;
    }

    public void setLeft(long left) {
        this.left = left;
    }

    public long getRight() {
        return right;
    }

    public void setRight(long right) {
        this.right = right;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
