import { useState } from 'react'
import categoryService from '../../../services/category-service'

const CategoryAdd = ({ onCancel, onCategoryAdded }) => {
  const [categoryName, setCategoryName] = useState('')
  const [description, setDescription] = useState('')

  const addCategoryHandler = async (event) => {
    event.preventDefault()
    const newCategory = {
      categoryName: categoryName,
      description: description
    }
    await categoryService.addCategory(newCategory)
    onCategoryAdded()
  }

  return (
    <>
      <h2 className="mb-3">Add New Category</h2>

      <form onSubmit={addCategoryHandler} >

        <div className="row mb-3">
          <label htmlFor="category-name">Category Name:</label>
          <input type="text" className="form-control" name="category-name" id="category-name"
            onChange={(e) => setCategoryName(e.target.value)}
          />
        </div>

        <div className="row mb-3">
          <label htmlFor="description">Description:</label>
          <textarea className="form-control" name="description" id="description"
            onChange={(e) => setDescription(e.target.value)} />
        </div>

        <div className="d-flex flex-row justify-content-center align-items-center gap-3">
          <button className="btn btn-danger" type="submit">Add Category</button>
          <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button>
        </div>

      </form>
    </>
  )
}

export default CategoryAdd