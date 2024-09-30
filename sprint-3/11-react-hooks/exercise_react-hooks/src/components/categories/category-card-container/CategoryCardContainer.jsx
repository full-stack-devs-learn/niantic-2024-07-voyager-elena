import { useState, useEffect } from 'react'
import CategoryCard from '../category-card/CategoryCard'
import ProductsList from '../../products/products-list/ProductsList'
import categoryService from '../../../services/category-service'
import './CategoryCardContainer.css'


const CategoryCardContainer = () => {
  const [selectedCategory, setSelectedCategory] = useState('None Selected')
  const [selectedCategoryId, setSelectedCategoryId] = useState(0)
  const [categories, setCategories] = useState([])

  useEffect(() => {
    categoryService.getAllCategories().then(data => {
      setCategories(data);
    })
  }, [])

  const categorySelected = (name) => {
    setSelectedCategory(name)
    const categoryId = categories.find(cat => cat.categoryName === name).categoryId
    setSelectedCategoryId(categoryId)
  }

  const categoryDeleted = (categoryId) => {
    const newList = categories.filter(category => category.categoryId !== categoryId);
    setCategories(newList)
  }

  return (
    <>
      <h5 className="container">Selected Category: {selectedCategory}</h5>
      <main className="container categories-container p-4 mb-5">
        {
          categories.map((category) => (
            <CategoryCard key={category.categoryId}
              category={category.categoryName}
              id={category.categoryId}
              onCategorySelected={categorySelected}
              onCategoryDeleted={categoryDeleted}
            ></CategoryCard>
          ))
        }
      </main>
      {selectedCategoryId > 0 && <ProductsList categoryId={selectedCategoryId} />}
    </>
  )
}

export default CategoryCardContainer