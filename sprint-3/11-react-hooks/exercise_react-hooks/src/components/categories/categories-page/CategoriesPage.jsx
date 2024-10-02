import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryEdit from '../category-edit/CategoryEdit'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import { PlusSquare } from 'react-bootstrap-icons'
import './CategoriesPage.css'

const CategoriesPage = () => {
  const [action, setAction] = useState('list')
  const [categoryId, setCategoryId] = useState(0)

  const editCategory = (categoryId) => {
    setCategoryId(categoryId)
    setAction('edit')
  }

  return (
    <div className="container p-4">

      <h1 className="mb-3">Categories</h1>

      {action === "list" &&
        <>
          <button
            className="btn btn-info d-flex flex-row justify-content-between align-items-center gap-2 mb-5"
            onClick={() => setAction("add")}
          >
            <PlusSquare /><span>Add New Category</span>
          </button>

          <CategoryCardContainer onCategoryEdit={editCategory} />
        </>}
      {action === "add" &&
        <CategoryAdd
          onCancel={() => setAction("list")}
          onCategoryAdded={() => setAction("list")}
        />
      }
      {action === "edit" &&
        <CategoryEdit
          onCancel={() => setAction("list")}
          onCategoryUpdate={() => setAction("list")}
          categoryId={categoryId}
        />
      }

    </div>
  )
}

export default CategoriesPage