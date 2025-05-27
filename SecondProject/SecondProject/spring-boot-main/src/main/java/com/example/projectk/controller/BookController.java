package com.example.projectk.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.projectk.BookServices;
import com.example.projectk.model.Books;
import com.example.projectk.repository.BookRepository;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController 
{
    @Autowired
    BookRepository br;

    @Autowired
    BookServices b;

   @PostMapping("/addbook")
   ResponseEntity<?> addbook(@RequestBody Books b)
   {
        Books result=this.br.findByTitle(b.getTitle());
        if(result != null)
        {
            // return "the book is exist";
           
        }
         this.br.save(b);
        //  return "book successfully added";
        return ResponseEntity.status(HttpStatus.CREATED).body("book successfully added");
   }  
   
   @PostMapping
   List<Books> viewAll()
   {
      List<Books> result= this.br.findAll();
      return result;
   }

   @GetMapping("/getdata")
    ResponseEntity<Page<Books>> getdata(@RequestParam int page,@RequestParam int list)
   {
         Pageable p=PageRequest.of(page,list);
         Page<Books> l=this.br.findAll(p);
         return ResponseEntity.ok(l);
   }



   @PostMapping("/authorform/{name}")
   List<Books> viewByAuthor(@PathVariable String name)
   {
         List<Books> result=this.b.getBooks(name);
         return result;
   }

    @GetMapping
    public ResponseEntity<Page<Books>> getBooks(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size) 
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<Books> booksPage = this.br.findAll(pageable);
        return ResponseEntity.ok(booksPage);
    }
}

//    @GetMapping("/getauthordata")
// public List<Books> authorbooks(@RequestParam String author) {
//     return this.service.getBooks(author);
// }

// }



// ✅ Informational (1xx) — Rarely used in APIs
// HttpStatus.CONTINUE (100)

// HttpStatus.SWITCHING_PROTOCOLS (101)

// 🟢 Successful (2xx)
// HttpStatus.OK (200) → Request succeeded

// HttpStatus.CREATED (201) → Resource created (used after POST)

// HttpStatus.ACCEPTED (202) → Request accepted for processing

// HttpStatus.NO_CONTENT (204) → Success, but no response body

// 🟡 Redirection (3xx) — Used for redirects, less common in APIs
// HttpStatus.MOVED_PERMANENTLY (301)

// HttpStatus.FOUND (302)

// 🔴 Client Errors (4xx) — Very common in APIs
// HttpStatus.BAD_REQUEST (400) → Invalid input or request

// HttpStatus.UNAUTHORIZED (401) → Authentication required (invalid or missing credentials)

// HttpStatus.FORBIDDEN (403) → Authenticated but not allowed (no permission)

// HttpStatus.NOT_FOUND (404) → Resource not found

// HttpStatus.CONFLICT (409) → Conflict (e.g., duplicate data)

// HttpStatus.UNPROCESSABLE_ENTITY (422) → Validation errors

// 🔴 Server Errors (5xx)
// HttpStatus.INTERNAL_SERVER_ERROR (500) → Generic server error

// HttpStatus.NOT_IMPLEMENTED (501)

// HttpStatus.BAD_GATEWAY (502)

// HttpStatus.SERVICE_UNAVAILABLE (503)

// ✅ Example Usage in Spring Boot
// java
// Copy
// Edit
// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data");
// return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
// return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");