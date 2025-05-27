import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

function Register()
{
  const navigate=useNavigate();
  const [form,setform] =useState(
    {
      username:"",
      email:"",
      password:""
    }
  )

    const submitform = async (e) =>
    {
         e.preventDefault()
        
         try
         {
           const response=await axios.post("http://localhost:8080/register",form)
          alert(response.data)
          navigate("/log")
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
          <h1>wellcome to registration</h1>
         <form onSubmit={submitform}>
                 <input onChange={changedata} type="text" name="username" placeholder="create username"/>
                <input onChange={changedata} type="email" name="email" placeholder="enter email"/>
                <input onChange={changedata} type="password" name="password" placeholder="create password"/>
                <button type="submit">register</button>
         </form>
        </>
    )
}
export default Register