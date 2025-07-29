import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import BookList from "./components/BookList";
import AddBookForm from "./components/AddBookForm";

function App() {
  const [reload, setReload] = useState(false);

  const triggerReload = () => setReload(!reload);

  return (
    <div>
      <h1>Book Manager (REST)</h1>
      <AddBookForm onBookAdded={triggerReload} />
      <BookList key={reload} />
    </div>
  );
}

export default App;
