import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { useEffect } from 'react'
import { loadCategories } from '../../../store/features/categories-slice'
import { Link } from 'react-router-dom'
import CategoryCard from '../category-card/CategoryCard'
import { PlusSquare } from 'react-bootstrap-icons'
import './CategoriesList.css'

const CategoriesList = () => {
  const dispatch = useDispatch<AppDispatch>()
  const { categories, loading, error } = useSelector((state: RootState) => state.categories)

  useEffect(() => {
    if (categories.length === 0) {
      dispatch(loadCategories())
    }
  }, [dispatch])


  if (loading) return <p>Loading categories...</p>
  if (error) return <p>Error: {error}</p>

  return (
    <>
      <h3 className="mb-3">Categories List</h3>
      <Link to="add" className="btn btn-info d-inline-flex flex-row align-items-center gap-2 mb-5">
        <PlusSquare /><span>Add New Category</span>
      </Link>

      <div className="container categories-container p-4 mb-5">
        {
          categories.map((category) => (
            <CategoryCard
              key={category.categoryId}
              category={category}
            ></CategoryCard>
          ))
        }
      </div>
    </>
  )
}

export default CategoriesList