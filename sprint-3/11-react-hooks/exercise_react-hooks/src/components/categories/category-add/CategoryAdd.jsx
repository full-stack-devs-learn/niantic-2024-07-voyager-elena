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
      <h2 className="mb-5">Add New Category</h2>

      <form onSubmit={addCategoryHandler} >
        <div className="row">
          <label htmlFor="category-name">Category Name:</label>
          <input type="text" className="form-control" name="category-name" id="category-name"
            onChange={(e) => setCategoryName(e.target.value)}
          />
        </div>

        <div className="row">
          <label htmlFor="description">Description:</label>
          <textarea className="form-control" name="description" id="description"
            onChange={(e) => setDescription(e.target.value)} />
        </div>

        <button className="btn btn-danger me-3" type="submit">Add Category</button>
        <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button>

      </form>
    </>
  )
}

export default CategoryAdd