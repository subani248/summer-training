import axios from "axios";
import { useState } from "react";
import { Link } from "react-router-dom";

function Library()
{

    const [result,setResult]=useState([]);

    const viewallbooks = async (e) =>
    {
       e.preventDefault();
       const response = await axios.post("http://localhost:8080/book")
       setResult(response.data)

    }
    return(
        <>
          <h1>You are in Library...</h1>
          <Link to="/abook">add book</Link><br/>
          <button onClick={viewallbooks}>view all books</button>
          <Link to="/vauthorbooks">view books by author name</Link><br/>
          <Link to="/booklist">view all books with pages</Link><br/>
           
          {
             result.map(x =>(
               <li >
                    {x.title}   {x.author} {x.description}
               </li>
           )
           )
          }

        </>
    )
}
export default Library