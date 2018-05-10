package io.naraplatform.share.domain.drama;

public enum AccessScope {
    //
    Square("S"),
    Pavilion("P"),
    Cineroom("C");

    private String initial;

    private AccessScope(String initial) {
        //
        this.initial = initial;
    }

    public String initial() {
        //
        return initial;
    }

    public boolean isSquareScope() {
        //
        return this == Square;
    }

    public boolean isPavilionScope() {
        //
        return this == Pavilion;
    }

    public boolean isCineroomScope() {
        //
        return this == Cineroom;
    }
}
