import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Link } from 'react-router-dom'

import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { loadCategories } from '../../../store/features/categories-slice'

const CategoryDetails = () => {
  const { categoryId } = useParams()
  const [categoryName, setCategoryName] = useState<string>('')
  const [description, setDescription] = useState<string>('')

  const dispatch = useDispatch<AppDispatch>()
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

  return (
    <>
      <h3 className="mb-3">Category Details</h3>
      <div className="container mb-5">
        <div><span className="fw-bold me-2">Category Id:</span>{categoryId}</div>
        <div><span className="fw-bold me-2">Category Name:</span>{categoryName}</div>
        <div><span className="fw-bold me-2">Category Description:</span>{description}</div>
      </div>
      <Link to="/categories" className="btn btn-secondary">Back To Categories Page</Link>
    </>
  )
}

export default CategoryDetails