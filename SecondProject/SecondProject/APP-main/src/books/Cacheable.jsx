import axios from "axios"
import { useState } from "react"

function Cacheable()
{
    const [author,setauthor] = useState("")
  
    const submitform = async (e) =>
    {
         e.preventDefault();
        try{
             const response = await axios.get(`http://localhost:8080/book/getauthordata?author=${author}`)
             console.log(response)
        }
        catch(error)
        {
            console.log(error)
        }
         
    }

    const changename = (e) =>
    {
         setauthor(e.target.value)
    }

    return(
        <>
           <h1>wellcome to see cacheable experiance</h1>

           <input onChange={changename} type="text" name="author" placeholder="enter author name"/>
           <button onClick={submitform}>get books</button>
        </>
    )
}
export default Cacheable