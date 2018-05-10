package io.naraplatform.share.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AttachedFile implements ValueObject {
    //
    private String attachmentId;
    private String fileName;
    private String contentType;
    private Long contentLength;

    public AttachedFile(String attachmentId, String fileName) {
        //
        this.attachmentId = attachmentId;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static AttachedFile getSample() {
        //
        String attachmentId = "1";
        String fileName = "Hello.zip";
        AttachedFile sample = new AttachedFile(attachmentId, fileName);

        return sample;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}