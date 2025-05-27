import React, { useEffect, useState } from 'react';
import axios from 'axios';
function ViewAll()
{
   const [books, setBooks] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const fetchBooks = async (pageNumber) => {
    try {
      const response = await axios.get(`http://localhost:8080/book?page=${pageNumber}&size=5`);
      setBooks(response.data.content);
      setTotalPages(response.data.totalPages);
      setPage(response.data.number);
    } catch (error) {
      console.error('Error fetching books', error);
    }
  };

  useEffect(() => {
    fetchBooks(page);
  }, []);

  const handleNext = () => {
    if (page + 1 < totalPages) {
      fetchBooks(page + 1);
    }
  };

  const handleBack = () => {
    if (page > 0) {
      fetchBooks(page - 1);
    }
  };

  return (
    <div>
      <h2>Book List (Page {page + 1})</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>{book.title} - {book.author}</li>
        ))}
      </ul>
      <button onClick={handleBack} disabled={page === 0}>Back</button>
      <button onClick={handleNext} disabled={page + 1 >= totalPages}>Next</button>
    </div>
  );
};

export default ViewAll