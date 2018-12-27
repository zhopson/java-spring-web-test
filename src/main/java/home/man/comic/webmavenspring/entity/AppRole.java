/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.entity;

/**
 *
 * @author andrey-man
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "app_role",
        uniqueConstraints = {
            @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "role_name")})
public class AppRole implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name
            = "role_name", length = 30, nullable = false)
    private String roleName;

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
}
