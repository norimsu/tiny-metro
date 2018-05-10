package io.naraplatform.share.domain.drama;

import java.util.UUID;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class TenantHeader implements JsonSerializable {
    //
    private String subscriptionId;
    private String organizationId;            // square/pavilion/cineroom
    private AccessScope scope;

    public TenantHeader() {
        //
    }

    public TenantHeader(String subscriptionId, String organizationId, AccessScope scope) {
        //
        this.subscriptionId = subscriptionId;
        this.organizationId = organizationId;
        this.scope = scope;
    }

    public String toString() {
        //
        return toJson();
    }

    public static TenantHeader fromJson(String json) {
        //
        return JsonUtil.fromJson(json, TenantHeader.class);
    }

    public static TenantHeader getSample() {
        //
        String subscriptionId = UUID.randomUUID().toString();
        String organizationId = "M1S1P1C1";

        TenantHeader sample = new TenantHeader(subscriptionId, organizationId, AccessScope.Cineroom);

        return sample;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public AccessScope getScope() {
        return scope;
    }

    public void setScope(AccessScope scope) {
        this.scope = scope;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
