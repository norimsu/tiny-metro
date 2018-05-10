package io.naraplatform.share.domain.drama;

import io.naraplatform.share.domain.NaraAggregate;
import io.naraplatform.share.domain.NaraEntity;

public abstract class DramaAggregate extends NaraEntity implements NaraAggregate {
    //
    private TenantHeader tenantHeader;

    protected DramaAggregate() {
        //
    }

    protected DramaAggregate(String id, TenantHeader tenantHeader) {
        //
        super(id);
        this.tenantHeader = tenantHeader;
    }

    protected DramaAggregate(TenantHeader tenantHeader) {
        //
        super();
        this.tenantHeader = tenantHeader;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public TenantHeader getTenant() {
        return tenantHeader;
    }

    public void setTenant(TenantHeader tenantHeader) {
        this.tenantHeader = tenantHeader;
    }
}
