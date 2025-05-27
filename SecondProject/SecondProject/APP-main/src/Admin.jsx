import { Link } from "react-router-dom"

function Admin()
{
    return(
        <>
           <h1>you are at Admin page</h1>
           <Link to="/library">click here to visit Library</Link><br/>
           <Link to="/cacheable">click here for cacheable experiance</Link>
        </>
    )
}
export default Admin