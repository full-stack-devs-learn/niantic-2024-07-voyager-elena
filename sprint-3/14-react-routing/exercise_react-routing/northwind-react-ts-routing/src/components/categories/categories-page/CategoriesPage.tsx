import { Outlet } from 'react-router-dom'
import './CategoriesPage.css'

const CategoriesPage = () => {

  return (
    <>
      <h1 className="mb-5 text-info">Categories</h1>
      <Outlet />
    </>
  )
}

export default CategoriesPage