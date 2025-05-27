package com.example.projectk.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.projectk.model.Books;
import com.example.projectk.repository.BookRepository;
import java.util.List;

@Service
public class BookService 
{
     @Autowired
     BookRepository br;

     @Cacheable("hii")
    public List<Books> getBooks(String name)
    {
         try
         { 
            Thread.sleep(20000);
            List<Books> result=this.br.findByAuthor(name);
            return result;
         }  
        catch(InterruptedException i)
       {
           Thread.currentThread().interrupt(); // Restore interrupted status
        throw new RuntimeException("Thread was interrupted", i); // Handle gracefully
       }
         }
    }

