
// import { Link } from 'react-router-dom'

// import Category from '../../../models/category'
import { useDispatch } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { useSelector } from 'react-redux'
import { useEffect } from 'react'
import { loadCategories } from '../../../store/features/categories-slice'
import CategoryCard from '../category-card/CategoryCard'

import './CategoriesList.css'

const CategoriesList = () => {
  const dispatch = useDispatch<AppDispatch>()
  const { categories, loading, error } = useSelector((state: RootState) => state.categories)

  useEffect(() => {
    if (categories.length === 0) {
      dispatch(loadCategories())
    }
  }, [dispatch])


  if (loading) return <p>Loading categories...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <>
      <h3 className="mb-3">Categories List</h3>

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