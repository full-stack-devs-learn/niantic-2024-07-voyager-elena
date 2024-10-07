import { useState, useEffect } from 'react'
import { useParams, Link, useNavigate } from 'react-router-dom'
import Product from '../../../models/product'
import { useDispatch, useSelector } from 'react-redux'
import { AppDispatch, RootState } from '../../../store/store'
import { loadProducts, updateProduct } from '../../../store/features/products-slice'
import { loadCategories } from '../../../store/features/categories-slice'

const ProductEdit = () => {
  const { productId } = useParams()
  const [product, setProduct] = useState<Product>({ productId: 0, productName: '', unitPrice: 0 })
  const [categoryName, setCategoryName] = useState<string>('')

  const dispatch = useDispatch<AppDispatch>()
  const { products, loading, error } = useSelector((state: RootState) => state.products)
  const { categories } = useSelector((state: RootState) => state.categories)

  const navigate = useNavigate()

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
  }, [dispatch, productId, products, categories])

  const updateProductHandler = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault()
    console.log(product)
    dispatch(updateProduct(product))
    navigate('/products')
  }

  if (loading) return <p>Loading products...</p>
  if (error) return <p>Error: {error}</p>

  return (
    <>
      <h3 className="mb-3">Edit Product - Product Id: {productId}</h3>
      {(product.productId === 0)
        ? <h3 className="mb-5">Sorry, product with Id {productId} was not found</h3>
        :
        <form onSubmit={updateProductHandler} >

          <div className="row mb-3">
            <label htmlFor="product-name">Product Name:</label>
            <input type="text" className="form-control" name="product-name" id="product-name" value={product?.productName}
              onChange={(e) => setProduct({ ...product, productName: e.target.value })}
            />
          </div>

          <div className="row mb-3">
            <label htmlFor="category-name">Category:</label>
            <input type="text" className="form-control" name="category-name" id="category-name" value={categoryName}
              onChange={(e) => setCategoryName(e.target.value)}
            />
          </div>

          <div className="d-flex flex-row justify-content-center align-items-center gap-3">
            <button className="btn btn-info" type="submit">Update Product</button>
            <Link className="btn btn-secondary" to="/products">Cancel</Link>
          </div>

        </form>
      }
    </>
  )
}

export default ProductEdit