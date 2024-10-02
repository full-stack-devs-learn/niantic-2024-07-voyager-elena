import { Link } from 'react-router-dom'
import notFoundImg from '/images/page-not-found.png'
import './NotFound.css'

const NotFound = () => {
  return (
    <div className="d-flex flex-column gap-3 align-items-center">
      <span className="display-2 fw-bold">404</span>
      <h1>Page not found</h1>
      <img src={notFoundImg} alt="Error 404" className="not-found-img" />
      <Link to="/" className="text-info">Go to Home page</Link>
    </div>
  )
}

export default NotFound;
