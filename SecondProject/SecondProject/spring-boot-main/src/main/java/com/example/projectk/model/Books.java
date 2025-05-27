package com.example.projectk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

     @Column
     String title;

     @Column
     String author;

     @Column
     String description;

     public void setTitle(String title)
     {
        this.title=title;
     }

    public  void setAuthor(String author)
     {
        this.author=author;
     }
    public  void setDescription(String description)
     {
        this.description=description;
     }

    public  String getTitle()
     {
        return this.title;
     }
    public  String getAuthor()
     {
        return this.author;
     }
    public  String getDescription()
     {
        return this.description;
     }
}
