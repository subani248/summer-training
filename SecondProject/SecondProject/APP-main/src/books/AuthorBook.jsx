import axios from "axios"
import { useState } from "react"

function AuthorBook()
{
  const [form,setform] =useState("")
  const [result,setResult]=useState([])
    const submitform = async (e) =>
    {
         e.preventDefault()
         const response=await axios.post(`http://localhost:8080/book/authorform/${form}`)
         setResult(response.data)
         console.log(response)
    }
    const changedata = (e) =>
    {
          setform(e.target.value)
    }
    return(
        <>
          <h1>add a book</h1>
         <form onSubmit={submitform}>
                <input onChange={changedata} type="text" name="author" placeholder="enter author name"/>
                <button type="submit">get books</button>
         </form>

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
export default AuthorBook