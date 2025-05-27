import axios from 'axios';
import React, { useEffect, useState } from 'react';
function Bookdata()
{
    const [n,setn]=useState(0)
   
    const getdata = async (pagen) =>
    {
        try
        {
           const response = await axios.get(`http://localhost:8080/book/getdata?page=${n}&list=5`)
            console.log(response)


        }
        catch(error)
        {
           console.log(error)
        }
    }

     useEffect(() => 
     {
             getdata(0)
     },[]);
     
     const back = (e) =>
     {
        setn(n-1)
     }

      const next = (e) =>
     {
         setn(n+1)
     }
   

    return(
        <>
            <h1>view all data --- {n}</h1>

              {/* {
             result.map(x =>(
               <li >
                    {x.title}   {x.author} {x.description}
               </li>
           )
           )
          } */}



            <button onClick={back}>back</button><br/>
            <button onClick={next}>next</button><br/>
        </>
    )
}
export default Bookdata