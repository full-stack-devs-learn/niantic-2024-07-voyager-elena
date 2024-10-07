import { useNavigate } from 'react-router-dom'
import Product from '../../../models/product'
import { useDispatch } from 'react-redux'
import { AppDispatch } from '../../../store/store'
import { deleteProduct } from '../../../store/features/products-slice'
import { Trash3, Pen } from 'react-bootstrap-icons'
import './ProductCard.css'

interface ProductCardProps {
  product: Product
}
const ProductCard: React.FC<ProductCardProps> = ({ product }) => {

  const dispatch = useDispatch<AppDispatch>()
  const navigate = useNavigate()

  const productClicked = () => {
    console.log('Product Details:', product)
    navigate(`${product.productId}`)
  }

  const handleDeleteProduct = async (event: React.MouseEvent<SVGElement, MouseEvent>) => {
    event.stopPropagation()
    console.log('Delete Product:', product)
    dispatch(deleteProduct(product.productId))
  }

  const handleEditProduct = (event: React.MouseEvent<SVGElement, MouseEvent>) => {
    event.stopPropagation();
    console.log('Edit product:', product)
    navigate(`${product.productId}/edit`)
  }

  return (
    <div className="card product-card d-flex flex-row justify-content-between align-items-center p-3" onClick={productClicked}>
      <div className="d-flex flex-row align-items-center justify-content-between w-75">
        <div className="d-flex flex-row align-items-center gap-3">
          <h4 className="product-id">{product.productId}</h4>
          <h4 className="product-name">{product.productName}</h4>
        </div>
        <h4 className="product-price">${Number(product.unitPrice).toFixed(2)}</h4>
      </div>
      <div className="d-flex flex-row justify-content-between align-items-center gap-5 h4 mb-0 ms-5">
        <Pen onClick={handleEditProduct} className="icon hover-info " />
        <Trash3 onClick={handleDeleteProduct} className="icon hover-danger" />
      </div>
    </div>
  )
}

export default ProductCard