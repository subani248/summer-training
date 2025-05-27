package com.example.projectk;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.projectk.model.Books;
import com.example.projectk.repository.BookRepository;


@Service
public class BookServices 
{

    @Autowired
    BookRepository br;

   @Cacheable("jii")
public
   List<Books> getBooks(String n)
   {
       try
       {
        Thread.sleep(20000);
          return this.br.findByAuthor(n);
       }
       catch(InterruptedException i)
       {
           Thread.currentThread().interrupt(); // Restore interrupted status
        throw new RuntimeException("Thread was interrupted", i); // Handle gracefully
       }
   }
}
