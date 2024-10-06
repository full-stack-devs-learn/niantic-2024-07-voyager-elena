import { useNavigate } from 'react-router-dom'
import Category from '../../../models/category'
import { useDispatch } from 'react-redux'
import { AppDispatch } from '../../../store/store'
import { deleteCategory } from '../../../store/features/categories-slice'
import { Trash3, Pen } from 'react-bootstrap-icons'
import './CategoryCard.css'

interface CategoryCardProps {
  category: Category;
}
const CategoryCard: React.FC<CategoryCardProps> = ({ category }) => {

  const dispatch = useDispatch<AppDispatch>()
  const navigate = useNavigate()

  let imageUrl
  if (category.categoryId >= 1 && category.categoryId <= 9) {
    imageUrl = `images/categories/${category.categoryId}.webp`
  }

  const categoryClicked = () => {
    console.log('Category Details:', category)
  }

  const handleDeleteCategory = async (event: React.MouseEvent<SVGElement, MouseEvent>) => {
    event.stopPropagation()
    console.log('Delete Category:', category)
    dispatch(deleteCategory(category.categoryId))
  }

  const handleEditCategory = (event: React.MouseEvent<SVGElement, MouseEvent>) => {
    event.stopPropagation();
    console.log('Edit category with id:', category.categoryId)
    navigate(`${category.categoryId}/edit`)
  }


  return (
    <div className="card category-card" onClick={categoryClicked}>
      <div id="category-header" className="card-header">{category.categoryName}</div>
      <div id="category-body" className="card-body">
        <div className="bg-image hover-zoom">
          {imageUrl && <img className="category-image w-100" src={imageUrl} />}
        </div>
      </div>
      <div className="card-footer d-flex flex-row justify-content-between align-items-center h4 mb-0">
        <Pen onClick={handleEditCategory} className="icon hover-info " />
        <Trash3 onClick={handleDeleteCategory} className="icon hover-danger" />
      </div>
    </div>
  )
}

export default CategoryCard