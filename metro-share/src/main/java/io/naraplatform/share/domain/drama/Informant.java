package io.naraplatform.share.domain.drama;

import java.util.UUID;

import io.naraplatform.share.domain.IdName;
import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;

public class Informant implements ValueObject {
    //
    private String cineroomId;
    private String playerId;
    private IdName sourceEntity;

    public Informant() {
        //
    }

    public Informant(String cineroomId, String playerId, IdName sourceEntity) {
        //
        this.cineroomId = cineroomId;
        this.playerId = playerId;
        this.sourceEntity = sourceEntity;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static Informant getSample() {
        //
        String cineroomId = "M1S1P1C1";
        String playerId = "2@M1S1P1C1";
        IdName sourceEntity = new IdName("nara.drama.Board", UUID.randomUUID().toString());

        Informant sample = new Informant(cineroomId, playerId, sourceEntity);

        return sample;
    }

    public static Informant fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Informant.class);
    }

    public String getCineroomId() {
        return cineroomId;
    }

    public void setCineroomId(String cineroomId) {
        this.cineroomId = cineroomId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public IdName getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(IdName sourceEntity) {
        this.sourceEntity = sourceEntity;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
