import { Link } from "react-router-dom"

function Home()
{
    return(
        <>
           <h1>wellcome to Home page</h1>
           <Link to="/reg">click here to register</Link><br/>
            <Link to="/log">click here to Login</Link>
        </>
    )
}
export default Home