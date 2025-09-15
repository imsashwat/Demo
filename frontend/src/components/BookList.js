import React, { useEffect, useState } from "react";

const BookList = () => {
  const [books, setBooks] = useState([]);

  const fetchBooks = async () => {
    const res = await fetch("http://localhost:8080/api/books");
    const data = await res.json();
    setBooks(data);
  };

  useEffect(() => {
    fetchBooks(); // Fetch books when the component mounts
  }, []);

  return (
    <div>
      <h2>Books</h2>
      <table border="1">
        <thead>
          <tr><th>Title</th><th>Author</th><th>Price</th></tr>
        </thead>
        <tbody>
          {books.map((book, idx) => (
            <tr key={idx}>
              <td>{book.title}</td>
              <td>{book.author}</td>
              <td>{book.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BookList;
