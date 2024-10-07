import { useState, useEffect } from 'react'
import { useParams, Link } from 'react-router-dom'
import Product from '../../../models/product'
import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { loadProducts } from '../../../store/features/products-slice'
import { loadCategories } from '../../../store/features/categories-slice'

const ProductDetails = () => {
  const { productId } = useParams()
  const [product, setProduct] = useState<Product | null>(null)
  const [categoryName, setCategoryName] = useState<string>('')

  const dispatch = useDispatch<AppDispatch>()
  const { products, loading, error } = useSelector((state: RootState) => state.products)
  // const { categories, loading, error } =  useSelector((state: RootState) => state.categories)
  const { categories } = useSelector((state: RootState) => state.categories)

  useEffect(() => {
    if (products.length === 0) {
      dispatch(loadProducts())
    }
    if (categories.length === 0) {
      dispatch(loadCategories())
    }
    const pId = productId ? +productId : 0
    const currentProduct = products.find(product => product.productId === pId)
    if (currentProduct) {
      setProduct(currentProduct)
      if (currentProduct.categoryId) {
        const productCategory = categories.find(category => category.categoryId === currentProduct.categoryId)
        if (productCategory) {
          setCategoryName(productCategory.categoryName)
        }
      }
    }
  }, [dispatch, product, productId, products, categories])

  if (loading) return <p>Loading products...</p>
  if (error) return <p>Error: {error}</p>

  return (
    <>
      <h3 className="mb-3">Product Details</h3>
      {(product == null)
        ? <h3 className="mb-5">Sorry, product with Id {productId} was not found</h3>
        :
        <div className="container mb-5">
          <div><span className="fw-bold me-2">Product Id:</span>{productId}</div>
          <div><span className="fw-bold me-2">Product Name:</span>{product.productName}</div>
          <div><span className="fw-bold me-2">Category Name:</span>{categoryName}</div>
          <div><span className="fw-bold me-2">Quantity Per Unit:</span>{product.quantityPerUnit}</div>
          <div><span className="fw-bold me-2">Unit Price:</span>${Number(product.unitPrice).toFixed(2)}</div>
          <div><span className="fw-bold me-2">Units In Stock:</span>{product.unitsInStock}</div>
          <div><span className="fw-bold me-2">Units On Order:</span>{product.unitsOnOrder}</div>
          <div><span className="fw-bold me-2">Reorder Level:</span>{product.reorderLevel}</div>
        </div>
      }

      <Link to="/products" className="btn btn-secondary">Back To Products Page</Link>
    </>
  )
}

export default ProductDetails