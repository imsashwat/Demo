import React, { useState } from "react";

const AddBookForm = ({ onBookAdded }) => {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
const [price, setPrice] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await fetch("http://localhost:8080/api/books", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, author, price }),
    });

    if (res.ok) {
      setTitle("");
      setAuthor("");
      setPrice("");
      onBookAdded();
    } else {
      alert("Failed to add book.");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <input
        placeholder="Author"
        value={author}
        onChange={(e) => setAuthor(e.target.value)}
      />
      <input
        placeholder="PriceLadle"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />
      <button type="submit">Add Book</button>
    </form>
  );
};

export default AddBookForm;
