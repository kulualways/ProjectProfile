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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kuldeep S Chauhan | Date:2 Apr, 2017
 */
@Entity
@Table(name = "actions")
@NamedQueries({
    @NamedQuery(name = "Actions.findAll", query = "SELECT a FROM Actions a"),
    @NamedQuery(name = "Actions.findByActionId", query = "SELECT a FROM Actions a WHERE a.actionId = :actionId"),
    @NamedQuery(name = "Actions.findByActionName", query = "SELECT a FROM Actions a WHERE a.actionName = :actionName"),
    @NamedQuery(name = "Actions.findByActionDesc", query = "SELECT a FROM Actions a WHERE a.actionDesc = :actionDesc"),
    @NamedQuery(name = "Actions.findByActionUrl", query = "SELECT a FROM Actions a WHERE a.actionUrl = :actionUrl"),
    @NamedQuery(name = "Actions.findByActive", query = "SELECT a FROM Actions a WHERE a.active = :active"),
    @NamedQuery(name = "Actions.findByDco", query = "SELECT a FROM Actions a WHERE a.dco = :dco"),
    @NamedQuery(name = "Actions.findByDluo", query = "SELECT a FROM Actions a WHERE a.dluo = :dluo")})
public class Actions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTION_ID")
    private Integer actionId;
    @Column(name = "ACTION_NAME")
    private String actionName;
    @Column(name = "ACTION_DESC")
    private String actionDesc;
    @Column(name = "ACTION_URL")
    private String actionUrl;
    @Column(name = "ACTIVE")
    private Integer active;
    @Column(name = "DCO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dco;
    @Column(name = "DLUO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dluo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actions")
    private Collection<RoleActions> roleActionsCollection;

    public Actions() {
    }

    public Actions(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
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

    public Collection<RoleActions> getRoleActionsCollection() {
        return roleActionsCollection;
    }

    public void setRoleActionsCollection(Collection<RoleActions> roleActionsCollection) {
        this.roleActionsCollection = roleActionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionId != null ? actionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actions)) {
            return false;
        }
        Actions other = (Actions) object;
        if ((this.actionId == null && other.actionId != null) || (this.actionId != null && !this.actionId.equals(other.actionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.namr.profile.db.Entity.Actions[ actionId=" + actionId + " ]";
    }

}
