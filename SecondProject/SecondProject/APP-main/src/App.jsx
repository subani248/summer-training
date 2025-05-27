import { BrowserRouter, Route, Routes } from "react-router-dom"
import Home from "./Home"
import Register from "./Register"
import Login from "./Login"
import Admin from "./admin"
import Library from "./Library"
import AddBook from "./books/AddBook"
import AuthorBook from "./books/AuthorBook"
import BookList from "./books/BookList"
import Bookdata from "./books/Bookdata"
import Cacheable from "./books/Cacheable"
import ViewAll from "./books/ViewAll"

function App()
{
  return(
    <>
      <BrowserRouter>
         <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/reg" element={<Register/>}/>
              <Route path="/log" element={<Login/>}/>
              <Route path="/admin" element={<Admin/>}/>
              <Route path="/library" element={<Library/>}/>
              <Route path="/abook" element={<AddBook/>}/>
              <Route path="/vauthorbooks" element={<AuthorBook/>}/>
              <Route path="/booklist" element={<BookList/>}/>
              <Route path="/bookdata" element={<Bookdata/>}/>
              <Route path="/cacheable" element={<Cacheable/>}/>
              <Route path="/viewall" element={<ViewAll/>}/>
         </Routes>
      </BrowserRouter>
    </>
  )
}
export default App