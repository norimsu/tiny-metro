package io.naraplatform.share.domain.file;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class NaraFile implements JsonSerializable {
    //
    private String diskFileId;
    private String name;
    private String contentType;
    private Long size;
    private Long time;

    public NaraFile() {
        //
    }

    public NaraFile(String name, String contentType, Long size) {
        //
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.time = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static NaraFile getSample() {
        //
        String name = "Hello.java";
        String contentType = "text/plain";
        Long size = 120L;

        NaraFile sample = new NaraFile(name, contentType, size);

        return sample;
    }

    public String toJson() {
        //
        return JsonUtil.toJson(this);
    }

    public static NaraFile fromJson(String json) {
        //
        return JsonUtil.fromJson(json, NaraFile.class);
    }

    public String getDiskFileId() {
        return diskFileId;
    }

    public void setDiskFileId(String diskFileId) {
        this.diskFileId = diskFileId;
    }

    @Deprecated
    public String getDepotId() {
        return diskFileId;
    }

    @Deprecated
    public void setDepotId(String depotId) {
        this.diskFileId = depotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
