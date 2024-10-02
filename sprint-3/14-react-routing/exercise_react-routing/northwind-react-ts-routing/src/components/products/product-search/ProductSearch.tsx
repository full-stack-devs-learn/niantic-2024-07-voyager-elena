import { useLocation } from 'react-router-dom'
import './ProductSearch.css'

const ProductSearch = () => {

  const location = useLocation()
  const params = new URLSearchParams(location.search)
  const minPrice = params.get('minPrice')
  const maxPrice = params.get('maxPrice')
  const name = params.get('name')
  const catId = params.get('catId')

  return (
    <>
      <h3 className="mb-3">Search Product</h3>
      <div>Search parameters:</div>
      <div>minPrice: {minPrice}</div>
      <div>maxPrice: {maxPrice}</div>
      <div>name: {name}</div>
      <div>catId: {catId}</div>
    </>
  )
}

export default ProductSearch