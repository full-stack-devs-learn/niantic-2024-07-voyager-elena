import { Trash3, Pen } from 'react-bootstrap-icons'
import productService from '../../../services/product-service'
import './ProductCard.css'


const ProductCard = ({ product, onProductDeleted }) => {

  const deleteProduct = async (event) => {
    event.stopPropagation()
    await productService.deleteProduct(product.productId)
    onProductDeleted(product.productId)
  }

  const editProduct = (event) => {
    event.stopPropagation()
    console.log('Edit product: ', product)
    //TODO: show edit product form
  }

  return (
    <div className="card product-card d-flex flex-row justify-content-between align-items-center p-3">
      <div className="d-flex flex-row align-items-center gap-3">
        <h4>{product.productId}</h4>
        <h4>{product.productName}</h4>
      </div>
      <div className="d-flex flex-row align-items-center gap-5 h4 mb-0">
        <Pen onClick={editProduct} className="icon hover-info " />
        <Trash3 onClick={deleteProduct} className="icon hover-danger" />
      </div>
    </div>
  )
}

export default ProductCard