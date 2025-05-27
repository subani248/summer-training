import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

function Login()
{
  const navigate=useNavigate()
  const [form,setform] =useState(
    {
      username:"",
      password:""
    }
  )

    const submitform = async (e) =>
    {
         e.preventDefault()
        try
        {
           const response=await axios.post("http://localhost:8080/login",form)
         alert(response.data)
         navigate("/admin")
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
          <h1>wellcome to Login</h1>
         <form onSubmit={submitform}>
                <input onChange={changedata} type="text" name="username" placeholder="enter username"/>
                <input onChange={changedata} type="password" name="password" placeholder="enter password"/>
                <button type="submit">login</button>
         </form>
        </>
    )
}
export default Login