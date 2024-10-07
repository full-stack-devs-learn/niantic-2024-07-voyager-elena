import { useLocation, Link } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { useState, useEffect } from 'react'
import { loadProducts } from '../../../store/features/products-slice'
import Product from '../../../models/product'
import ProductCard from '../product-card/ProductCard'
import { PlusSquare } from 'react-bootstrap-icons'
import './ProductSearch.css'


const ProductSearch = () => {
  const location = useLocation()
  const params = new URLSearchParams(location.search)
  const minPrice = params.get('minPrice')
  const maxPrice = params.get('maxPrice')
  const name = params.get('name')
  const catId = params.get('catId')

  const [searchResult, setSearchResult] = useState<Product[]>([])


  const dispatch = useDispatch<AppDispatch>()
  const { products, loading, error } = useSelector((state: RootState) => state.products)

  useEffect(() => {
    if (products.length === 0) {
      dispatch(loadProducts())
    }
    let result = [...products]
    if (catId !== null) {
      result = result.filter(product => product.categoryId == +catId)
    }
    if (minPrice !== null) {
      result = result.filter(product => product.unitPrice >= +minPrice)
    }
    if (maxPrice !== null) {
      result = result.filter(product => product.unitPrice <= +maxPrice)
    }
    if (name !== null) {
      result = result.filter(product => product.productName.toLowerCase() == name.toLowerCase())
    }

    setSearchResult(result)

  }, [dispatch, products, catId, minPrice, maxPrice, name])

  if (loading) return <p>Loading categories...</p>
  if (error) return <p>Error: {error}</p>

  return (
    <>
      <Link to="add" className="btn btn-info d-inline-flex flex-row align-items-center gap-2 mb-5">
        <PlusSquare /><span>Add New Product</span>
      </Link>

      <h3 className="mb-3">Search Product</h3>
      <div>Search parameters:</div>
      <div>minPrice: {minPrice}</div>
      <div>maxPrice: {maxPrice}</div>
      <div>name: {name}</div>
      <div>catId: {catId}</div>
      <br></br>
      <br></br>
      <div className="d-flex flex-column gap-3 p-4 mb-5">
        {
          searchResult.map((product) => (
            <ProductCard
              key={product.productId}
              product={product}
            />
          ))
        }
      </div>
    </>
  )
}

export default ProductSearch