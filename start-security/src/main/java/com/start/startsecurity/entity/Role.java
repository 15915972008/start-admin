package com.start.startsecurity.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统角色
 *
 * @author bojiangzhou 2018/09/04
 */
@Table(name = "iam_role")
public class Role {


    @Id
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编码(唯一)
     */
    private String roleCode;
    /**
     * 是否启用
     */
    private Boolean enabled;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
