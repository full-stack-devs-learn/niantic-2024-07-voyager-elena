import categoryService from '../../../services/category-service'
import './CategoryCard.css'
import { Trash3, Pen } from 'react-bootstrap-icons'

export default function CategoryCard({ id, category, onCategorySelected, onCategoryDeleted }) {
  const imageUrl = `images/categories/${id}.webp`

  const categoryClicked = () => {
    onCategorySelected(category)
  }

  async function deleteCategory(event) {
    event.stopPropagation();

    await categoryService.delete(id);

    onCategoryDeleted(id);
  }

  async function editCategory(event) {
    event.stopPropagation();
    console.log('Update category with id:', id)
    // TODO: update category
  }


  return (
    <div className="card category-card" onClick={categoryClicked}>
      <div id="category-header" className="card-header">{category}</div>
      <div id="category-body" className="card-body">
        <div className="bg-image hover-zoom">
          <img className="category-image w-100" src={imageUrl} />
        </div>
      </div>
      <div className="card-footer d-flex flex-row justify-content-between align-items-center h4 mb-0">
        <Pen onClick={editCategory} className="icon hover-info " />
        <Trash3 onClick={deleteCategory} className="icon hover-danger" />
      </div>
    </div>
  )
}