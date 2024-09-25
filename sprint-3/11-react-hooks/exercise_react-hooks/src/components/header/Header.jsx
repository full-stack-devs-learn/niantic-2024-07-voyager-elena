import './Header.css'

export default function Header({ onPageChanged }) {
  return (
    <div id="navigation" className="d-flex flex-row align-items-center gap-3">
      <img src="images/logo.png" alt="Northwind Logo" />
      <h2 className="me-3 mb-0">Northwind Traders</h2>

      <h5 className="link mb-0" onClick={() => onPageChanged("categories")}>Categories</h5>
      <h5 className="link mb-0" onClick={() => onPageChanged("products")}>Products</h5>
    </div>
  )
}
