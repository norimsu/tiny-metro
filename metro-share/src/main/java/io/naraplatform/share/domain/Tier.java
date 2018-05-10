package io.naraplatform.share.domain;

public enum Tier {
    //
    Primary,
    Secondary,
    Third;

    public boolean isPrimary() {
        //
        if (this.equals(Primary)) {
            return true;
        }

        return false;
    }

    public boolean isSecondary() {
        //
        if (this.equals(Secondary)) {
            return true;
        }

        return false;
    }


    public boolean isThird() {
        //
        if (this.equals(Third)) {
            return true;
        }

        return false;
    }
}