import { useState, useEffect } from 'react'
import categoryService from '../../../services/category-service'

const CategoryEdit = ({ onCancel, onCategoryUpdate, categoryId }) => {
  const [categoryName, setCategoryName] = useState('')
  const [description, setDescription] = useState('')

  const updateCategoryHandler = async (event) => {
    event.preventDefault()
    const updatedCategory = {
      categoryId: categoryId,
      categoryName: categoryName,
      description: description
    }
    await categoryService.updateCategory(updatedCategory)
    onCategoryUpdate()
  }

  useEffect(() => {
    categoryService.getCategoryById(categoryId).then(data => {
      console.log('data:', data)
      setCategoryName(data.categoryName)
      setDescription(data.description)
    })
  }, [categoryId])


  return (
    <>
      <h2 className="mb-3">Edit Category - categoryId: {categoryId}</h2>

      <form onSubmit={updateCategoryHandler} >

        <div className="row mb-3">
          <label htmlFor="category-name">Category Name:</label>
          <input type="text" className="form-control" name="category-name" id="category-name" defaultValue={categoryName}
            onChange={(e) => setCategoryName(e.target.value)}
          />
        </div>

        <div className="row mb-3">
          <label htmlFor="description">Description:</label>
          <textarea className="form-control" name="description" id="description" defaultValue={description}
            onChange={(e) => setDescription(e.target.value)} />
        </div>

        <div className="d-flex flex-row justify-content-center align-items-center gap-3">
          <button className="btn btn-danger" type="submit">Update Category</button>
          <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button>
        </div>

      </form>
    </>
  )
}

export default CategoryEdit