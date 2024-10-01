import { useParams } from 'react-router-dom'

const CategoryEdit = () => {
  const { categoryId } = useParams()

  return (
    <>
      <h3 className="mb-3">Edit Category - Category Id: {categoryId}</h3>
    </>
  )
}

export default CategoryEdit