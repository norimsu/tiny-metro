package io.naraplatform.share.domain.drama;

import io.naraplatform.share.domain.NaraEntity;

public abstract class DramaEntity extends NaraEntity {
	//
	private TenantHeader tenantHeader;

	public DramaEntity() {
		//
	}

	public DramaEntity(TenantHeader tenantHeader) {
	    //
        super();
        this.tenantHeader = tenantHeader;
    }

    public DramaEntity(String id, TenantHeader tenantHeader) {
        //
        super(id);
        this.tenantHeader = tenantHeader;
    }

    public TenantHeader getTenantHeader() {
        return tenantHeader;
    }

    public void setTenantHeader(TenantHeader tenantHeader) {
        this.tenantHeader = tenantHeader;
    }
}
