import { Outlet } from 'react-router-dom'
import './ProductsPage.css'

const ProductsPage = () => {

  return (
    <>
      <h1 className="mb-3 text-info">Products</h1>
      <Outlet />
    </>
  )
}

export default ProductsPage