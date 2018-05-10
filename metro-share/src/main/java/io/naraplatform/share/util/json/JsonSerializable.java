package io.naraplatform.share.util.json;

public interface JsonSerializable {
    //
    default String toJson() {
        //
        return JsonUtil.toJson(this);
    }
}
