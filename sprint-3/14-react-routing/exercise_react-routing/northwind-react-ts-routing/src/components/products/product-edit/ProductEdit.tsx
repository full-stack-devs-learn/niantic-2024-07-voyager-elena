import { useParams } from 'react-router-dom'

const ProductEdit = () => {
  const { productId } = useParams()

  return (
    <>
      <h3 className="mb-3">Edit Product - Product Id: {productId}</h3>
    </>
  )
}

export default ProductEdit