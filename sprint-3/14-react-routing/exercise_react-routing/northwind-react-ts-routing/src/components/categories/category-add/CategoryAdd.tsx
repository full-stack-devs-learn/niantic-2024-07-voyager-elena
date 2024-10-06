import { useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import { AppDispatch } from '../../../store/store'
import { addCategory } from '../../../store/features/categories-slice'


const CategoryAdd = () => {
  const [categoryName, setCategoryName] = useState<string>('')
  const [description, setDescription] = useState<string>('')

  const dispatch = useDispatch<AppDispatch>()
  const navigate = useNavigate()

  const handleAddCategory = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    const newCategory = {
      categoryId: 0,
      categoryName: categoryName,
      description: description
    }
    dispatch(addCategory(newCategory))
    navigate('/categories')
  }


  return (
    <>
      <h3 className="mb-3">Add New Category</h3>

      <form onSubmit={handleAddCategory} >

        <div className="row mb-3">
          <label htmlFor="category-name">Category Name:</label>
          <input type="text" className="form-control" name="category-name" id="category-name"
            onChange={(e) => setCategoryName(e.target.value)}
          />
        </div>

        <div className="row mb-3">
          <label htmlFor="description">Description:</label>
          <textarea className="form-control" name="description" id="description"
            onChange={(e) => setDescription(e.target.value)} />
        </div>

        <div className="d-flex flex-row justify-content-center align-items-center gap-3">
          <button className="btn btn-info" type="submit">Add Category</button>
          <Link className="btn btn-secondary" to="/categories">Cancel</Link>
        </div>

      </form>
    </>
  )
}

export default CategoryAdd