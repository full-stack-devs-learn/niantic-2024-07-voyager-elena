import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { loadCategories, updateCategory } from '../../../store/features/categories-slice'

const CategoryEdit = () => {
  const { categoryId } = useParams()
  const [categoryName, setCategoryName] = useState<string>('')
  const [description, setDescription] = useState<string>('')

  const dispatch = useDispatch<AppDispatch>()
  const navigate = useNavigate()

  const { categories, loading, error } = useSelector((state: RootState) => state.categories)

  useEffect(() => {
    if (categories.length === 0) {
      dispatch(loadCategories())
    }
    const catId = categoryId ? +categoryId : 0
    const currentCategory = categories.find(category => category.categoryId == catId)
    if (currentCategory) {
      setCategoryName(currentCategory.categoryName)
      setDescription(currentCategory.description)
    }
  }, [categories, categoryId, dispatch])


  if (loading) return <p>Loading categories...</p>
  if (error) return <p>Error: {error}</p>

  const updateCategoryHandler = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    const updatedCategory = {
      categoryId: categoryId ? +categoryId : 0,
      categoryName: categoryName,
      description: description
    }

    dispatch(updateCategory(updatedCategory))
    navigate('/categories')
  }

  return (
    <>
      <h3 className="mb-3">Edit Category - Category Id: {categoryId}</h3>
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
          <button className="btn btn-info" type="submit">Update Category</button>
          <Link className="btn btn-secondary" to="/categories">Cancel</Link>
        </div>

      </form>
    </>
  )
}

export default CategoryEdit