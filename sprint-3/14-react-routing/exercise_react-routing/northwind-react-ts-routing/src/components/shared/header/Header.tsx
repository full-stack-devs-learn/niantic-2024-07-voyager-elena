import { Link, NavLink } from 'react-router-dom'
import logoImage from '/images/logo.png'
import './Header.css'

const Header = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-light" data-bs-theme="light">
      <div className="container-fluid">
        <Link className="navbar-brand d-flex flex-row gap-3 align-items-center" to="/">
          <img src={logoImage} className="logo-img" alt="Northwind Logo" />
          <h4 className="mb-0">Northwind</h4>
        </Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbar">
          <ul className="navbar-nav me-auto">
            <li className="nav-item">
              <NavLink className="nav-link" to="/">Home</NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/categories">Categories</NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/products">Products</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default Header