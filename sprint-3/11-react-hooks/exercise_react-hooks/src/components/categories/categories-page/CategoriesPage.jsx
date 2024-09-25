import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'
import { PlusSquare } from 'react-bootstrap-icons'

export default function CategoriesPage() {
  const [action, setAction] = useState("list");

  return (
    <div className='container'>
      <header className="mt-4">
        <h1>Categories</h1>
      </header>
      <button
        className="btn btn-info d-flex flex-row justify-content-between align-items-center gap-2 mb-3"
        onClick={() => setAction("add")}
      >
        <PlusSquare /><span>Add New Category</span>
      </button>

      {action === "list" && <CategoryCardContainer></CategoryCardContainer>}
      {action === "add" && <CategoryAdd onCancel={() => setAction("list")}
        onCategoryAdded={() => setAction("list")}
      ></CategoryAdd>}

    </div>
  )
}