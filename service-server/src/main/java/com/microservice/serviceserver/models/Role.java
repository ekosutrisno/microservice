package com.microservice.serviceserver.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Email ekosutrisno801@gmail.com
 * @Github https://github.com/ekosutrisno
 * @Gitlab https://gitlab.com/ekosutrisno1
 * @Create 06/09/2020 16:48
 */

@Entity
@Table(name = Role.TABLE_NAME)
public class Role implements Serializable {
   static final String TABLE_NAME = "tbl_role";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "name")
   private String name;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "permission_role", joinColumns = {
           @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
           @JoinColumn(name = "permission_id", referencedColumnName = "id")})
   private List<Permission> permissions;

   public Role() {
   }

   public Role(Long id, String name, List<Permission> permissions) {
      this.id = id;
      this.name = name;
      this.permissions = permissions;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Permission> getPermissions() {
      return permissions;
   }

   public void setPermissions(List<Permission> permissions) {
      this.permissions = permissions;
   }
}
