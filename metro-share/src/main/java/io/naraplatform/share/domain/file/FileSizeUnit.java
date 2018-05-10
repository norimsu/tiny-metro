package io.naraplatform.share.domain.file;

public enum FileSizeUnit {
    //
    GB("GigaByte"),
    MB("MegaByte"),
    KB("KiloByte"),
    Byte("Byte");

    private String fullName;

    private FileSizeUnit(String fullName) {
        //
        this.fullName = fullName;
    }

    public String fullName() {
        //
        return fullName;
    }
}
