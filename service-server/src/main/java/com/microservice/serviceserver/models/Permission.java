package com.microservice.serviceserver.models;

import java.util.UUID;

/**
 * @Author Eko Sutrisno
 * @Create 23/08/2020 0:09
 */
public class Permission {
   static final String TABLE_NAME="tbl_permission";

   private String permissionId = UUID.randomUUID().toString();
   private String name;

   public Permission() {
   }

   public Permission(String permissionId, String name) {
      this.permissionId = permissionId;
      this.name = name;
   }

   public String getPermissionId() {
      return permissionId;
   }

   public void setPermissionId(String permissionId) {
      this.permissionId = permissionId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
