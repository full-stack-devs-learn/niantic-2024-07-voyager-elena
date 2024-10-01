import { useParams } from 'react-router-dom'

const ProductDetails = () => {
  const { productId } = useParams()

  return (
    <>
      <h3 className="mb-3">Product Details</h3>
      <div>Product Id: {productId}</div>
    </>
  )
}

export default ProductDetails