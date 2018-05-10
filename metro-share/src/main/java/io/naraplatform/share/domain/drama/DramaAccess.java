package io.naraplatform.share.domain.drama;

import io.naraplatform.share.domain.IdName;
import io.naraplatform.share.domain.IdNameList;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class DramaAccess implements JsonSerializable {
    //
    private AccessScope scope;
    private IdNameList deniedWorkspaces;
    private IdNameList allowedWorkspaces;

    public DramaAccess() {
        //
    }

    public DramaAccess(AccessScope scope) {
        //
        this.scope = scope;
        this.deniedWorkspaces = new IdNameList();
        this.allowedWorkspaces = new IdNameList();
    }

    public static DramaAccess pavilionScope() {
        //
        return new DramaAccess(AccessScope.Pavilion);
    }

    public static DramaAccess cineroomScope() {
        return new DramaAccess(AccessScope.Cineroom);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static DramaAccess getSample() {
        //
        return new DramaAccess(AccessScope.Cineroom);
    }

    public boolean hasAccessList() {
        //
        if (deniedWorkspaces.size() > 0 || allowedWorkspaces.size() > 0) {
            return true;
        }

        return false;
    }

    public boolean hasDeniedList() {
        //
        if (deniedWorkspaces.size() > 0) {
            return true;
        }

        return false;
    }

    public boolean hasAllowedList() {
        //
        if (allowedWorkspaces.size() > 0) {
            return true;
        }

        return false;
    }

    public boolean isAllowed(String workspaceId) {
        // workspace id == cineroom id
        if(hasAllowedList()) {
            // allow list first
            for(IdName workspace : allowedWorkspaces.getList()) {
                if(workspace.getId().equals(workspaceId)) {
                    return true;
                }
            }
            return false;
        } else if (hasDeniedList()) {
            for(IdName workspace : deniedWorkspaces.getList()) {
                if(workspace.getId().equals(workspaceId)) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static DramaAccess fromJson(String json) {
        //
        return JsonUtil.fromJson(json, DramaAccess.class);
    }

    public AccessScope getScope() {
        return scope;
    }

    public void setScope(AccessScope scope) {
        this.scope = scope;
    }

    public IdNameList getDeniedWorkspaces() {
        return deniedWorkspaces;
    }

    public void setDeniedWorkspaces(IdNameList deniedWorkspaces) {
        this.deniedWorkspaces = deniedWorkspaces;
    }

    public IdNameList getAllowedWorkspaces() {
        return allowedWorkspaces;
    }

    public void setAllowedWorkspaces(IdNameList allowedWorkspaces) {
        this.allowedWorkspaces = allowedWorkspaces;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
