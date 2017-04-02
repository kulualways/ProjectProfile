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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kuldeep S Chauhan | Date:2 Apr, 2017
 */
@Entity
@Table(name = "role_actions")
@NamedQueries({
    @NamedQuery(name = "RoleActions.findAll", query = "SELECT r FROM RoleActions r"),
    @NamedQuery(name = "RoleActions.findByRoleId", query = "SELECT r FROM RoleActions r WHERE r.roleActionsPK.roleId = :roleId"),
    @NamedQuery(name = "RoleActions.findByActionId", query = "SELECT r FROM RoleActions r WHERE r.roleActionsPK.actionId = :actionId"),
    @NamedQuery(name = "RoleActions.findByActive", query = "SELECT r FROM RoleActions r WHERE r.active = :active"),
    @NamedQuery(name = "RoleActions.findByDco", query = "SELECT r FROM RoleActions r WHERE r.dco = :dco"),
    @NamedQuery(name = "RoleActions.findByDluo", query = "SELECT r FROM RoleActions r WHERE r.dluo = :dluo")})
public class RoleActions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleActionsPK roleActionsPK;
    @Column(name = "ACTIVE")
    private Integer active;
    @Column(name = "DCO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dco;
    @Column(name = "DLUO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dluo;
    @JoinColumn(name = "ACTION_ID", referencedColumnName = "ACTION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actions actions;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;

    public RoleActions() {
    }

    public RoleActions(RoleActionsPK roleActionsPK) {
        this.roleActionsPK = roleActionsPK;
    }

    public RoleActions(int roleId, int actionId) {
        this.roleActionsPK = new RoleActionsPK(roleId, actionId);
    }

    public RoleActionsPK getRoleActionsPK() {
        return roleActionsPK;
    }

    public void setRoleActionsPK(RoleActionsPK roleActionsPK) {
        this.roleActionsPK = roleActionsPK;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getDco() {
        return dco;
    }

    public void setDco(Date dco) {
        this.dco = dco;
    }

    public Date getDluo() {
        return dluo;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleActionsPK != null ? roleActionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleActions)) {
            return false;
        }
        RoleActions other = (RoleActions) object;
        if ((this.roleActionsPK == null && other.roleActionsPK != null) || (this.roleActionsPK != null && !this.roleActionsPK.equals(other.roleActionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.namr.profile.db.Entity.RoleActions[ roleActionsPK=" + roleActionsPK + " ]";
    }

}
