package com.microservice.serviceserver.models;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Eko Sutrisno
 * @Create 23/08/2020 0:09
 */
@Entity
@Table(name = Permission.TABLE_NAME)
public class Permission implements Serializable {
   static final String TABLE_NAME = "tbl_permission";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "name")
   private String name;

   public Permission() {
   }

   public Permission(Long id, String name) {
      this.id = id;
      this.name = name;
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

}
