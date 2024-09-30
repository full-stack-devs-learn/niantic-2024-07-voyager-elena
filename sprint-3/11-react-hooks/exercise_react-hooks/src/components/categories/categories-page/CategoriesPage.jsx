import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import { PlusSquare } from 'react-bootstrap-icons'
import './CategoriesPage.css'

const CategoriesPage = () => {
  const [action, setAction] = useState("list")

  return (
    <div className="container p-4">

      <h1>Categories</h1>

      <button
        className="btn btn-info d-flex flex-row justify-content-between align-items-center gap-2 mb-5"
        onClick={() => setAction("add")}
      >
        <PlusSquare /><span>Add New Category</span>
      </button>

      {action === "list" && <CategoryCardContainer />}
      {action === "add" &&
        <CategoryAdd
          onCancel={() => setAction("list")}
          onCategoryAdded={() => setAction("list")}
        />
      }

    </div>
  )
}

export default CategoriesPage