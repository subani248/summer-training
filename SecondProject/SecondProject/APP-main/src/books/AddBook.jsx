import axios from "axios"
import { useState } from "react"

function AddBook()
{
  const [form,setform] =useState(
    {
      title:"",
      author:"",
      description:""
    }
  )

    const submitform = async (e) =>
    {
         e.preventDefault()
         try
         {
          const response=await axios.post("http://localhost:8080/book/addbook",form)
         console.log(response)
         alert(response.data)
         }
         catch(error)
         {
          console.log("hiii")
              console.log(error.response)
              if(error.response && error.response.status === 409)
              {
                alert(error.response.data)
              }
              else
              {
                alert("something went wrong please try again")
              }
         }

    }
    const changedata = (e) =>
    {
          setform({...form,[e.target.name]:e.target.value})
    }
    return(
        <>
          <h1>add a book</h1>
         <form onSubmit={submitform}>
                 <input onChange={changedata} type="text" name="title" placeholder="enter title"/>
                <input onChange={changedata} type="text" name="author" placeholder="enter author name"/>
                <input onChange={changedata} type="text" name="description" placeholder="write about book..."/>
                <button type="submit">add book</button>
         </form>
        </>
    )
}
export default AddBook