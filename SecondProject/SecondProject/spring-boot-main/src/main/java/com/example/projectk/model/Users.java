package com.example.projectk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;

   @Column
   String username;
   @Column
   String email;

   @Column
   String password;

  public void setUsername(String name)
   {
      this.username=name;
   }

   public  void setEmail(String mail)
   {
      this.email=mail;
   }

  public  void setPassword(String psw)
   {
      this.password=psw;
   }
  public  String getUsername()
   {
      return this.username;
   }
  public  String getEmail()
   {
      return this.email;
   }
   public  String getPassword()
   {
      return this.password;
   }
}
