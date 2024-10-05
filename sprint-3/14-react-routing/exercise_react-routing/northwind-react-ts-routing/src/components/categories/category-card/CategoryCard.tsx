import Category from '../../../models/category'
import './CategoryCard.css'

interface CategoryCardProps {
  category: Category;
}
const CategoryCard: React.FC<CategoryCardProps> = ({ category }) => {

  let imageUrl
  if (category.categoryId >= 1 && category.categoryId <= 9) {
    imageUrl = `images/categories/${category.categoryId}.webp`
  }


  const categoryClicked = () => {
    console.log(category)
  }

  // const deleteCategory = async (event) => {
  //   event.stopPropagation()
  //   await categoryService.deleteCategory(id)
  //   onCategoryDeleted(id)
  // }

  // const editCategory = (event) => {
  //   event.stopPropagation();
  //   console.log('Edit category with id:', id)
  //   onCategoryEdit(id);
  // }


  return (
    <div className="card category-card" onClick={categoryClicked}>
      <div id="category-header" className="card-header">{category.categoryName}</div>
      <div id="category-body" className="card-body">
        <div className="bg-image hover-zoom">
          {imageUrl && <img className="category-image w-100" src={imageUrl} />}
        </div>
      </div>
      {/* <div className="card-footer d-flex flex-row justify-content-between align-items-center h4 mb-0">
        <Pen onClick={editCategory} className="icon hover-info " />
        <Trash3 onClick={deleteCategory} className="icon hover-danger" />
      </div> */}
    </div>
  )
}

export default CategoryCard