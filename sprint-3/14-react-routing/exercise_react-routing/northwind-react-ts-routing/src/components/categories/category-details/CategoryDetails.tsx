import { useParams } from 'react-router-dom'


const CategoryDetails = () => {
  const { categoryId } = useParams()

  return (
    <>
      <h3 className="mb-3">Category Details</h3>
      <div>Category Id: {categoryId}</div>
    </>
  )
}

export default CategoryDetails