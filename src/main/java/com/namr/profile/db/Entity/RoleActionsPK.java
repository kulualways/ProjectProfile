/*
 * Copyright (C) 2017 Kuldeep S Chauhan | kuldeep.schauhan@yahoo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.namr.profile.db.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Kuldeep S Chauhan | Date:2 Apr, 2017
 */
@Embeddable
public class RoleActionsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private int roleId;
    @Basic(optional = false)
    @Column(name = "ACTION_ID")
    private int actionId;

    public RoleActionsPK() {
    }

    public RoleActionsPK(int roleId, int actionId) {
        this.roleId = roleId;
        this.actionId = actionId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) actionId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleActionsPK)) {
            return false;
        }
        RoleActionsPK other = (RoleActionsPK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.actionId != other.actionId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.namr.profile.db.Entity.RoleActionsPK[ roleId=" + roleId + ", actionId=" + actionId + " ]";
    }

}
