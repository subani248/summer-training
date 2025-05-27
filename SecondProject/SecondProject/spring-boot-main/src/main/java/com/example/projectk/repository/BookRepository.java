package com.example.projectk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectk.model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer>
{
  List<Books> findByAuthor(String author);
  Books findByTitle(String title);
}
