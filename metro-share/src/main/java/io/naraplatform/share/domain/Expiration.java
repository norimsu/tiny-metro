package io.naraplatform.share.domain;

import io.naraplatform.share.util.json.JsonUtil;

public class Expiration implements ValueObject {
    //
    private boolean expired;
    private Long time;
    private String reason;

    public Expiration() {
        //
        this.expired = false;
    }

    private Expiration(boolean expired) {
        //
        this.expired = expired;
        if (expired) {
            this.time = System.currentTimeMillis();
            this.reason = null;
        } else {
            this.time = null;
            this.reason = null;
        }
    }

    private Expiration(boolean expired, String reason) {
        //
        this.expired = expired;
        if (expired) {
            this.time = System.currentTimeMillis();
            this.reason = reason;
        } else {
            this.time = null;
            this.reason = reason;
        }
    }

    public static Expiration newNonExpired() {
        //
        return new Expiration(false);
    }

    public static Expiration newExpired(String reason) {
        //
        return new Expiration(true, reason);
    }

    public String toString() {
        //
        return toJson();
    }

    public static Expiration fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Expiration.class);
    }

    public static Expiration getSample() {
        //
        boolean expired = true;
        String reason = "Data has passed.";

        return new Expiration(expired, reason);
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
