import { useState, useEffect } from 'react'
import ProductAdd from '../product-add/ProductAdd'
import ProductsList from '../products-list/ProductsList'
import { PlusSquare } from 'react-bootstrap-icons'
import categoryService from '../../../services/category-service'
import './ProductsPage.css'

export default function ProductsPage() {
  const [action, setAction] = useState("list")
  const [categories, setCategories] = useState([])

  useEffect(() => {
    categoryService.getAllCategories().then(data => {
      setCategories(data);
    })
  }, [])

  return (
    <div className="container p-4">
      <h1>Products</h1>

      <button
        className="btn btn-info d-flex flex-row justify-content-between align-items-center gap-2 mb-3"
        onClick={() => setAction("add")}
      >
        <PlusSquare /><span>Add New Product</span>
      </button>

      {action === "list" && <ProductsList categoryId={0} />}
      {action === "add" &&
        <ProductAdd
          onCancel={() => setAction("list")}
          onProductAdded={() => setAction("list")}
          categories={categories}
        />}
    </div>
  )
}