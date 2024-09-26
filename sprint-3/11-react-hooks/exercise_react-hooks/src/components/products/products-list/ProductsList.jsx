import { useState, useEffect } from 'react'
import ProductCard from '../product-card/ProductCard'
import productService from '../../../services/product-service'
import './ProductsList.css'

export default function ProductsList({ categoryId }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    productService.getProducts(categoryId).then(data => {
      setProducts(data);
    })
  }, [categoryId])

  const productDeleted = (productId) => {
    const newList = products.filter(product => product.productId !== productId)
    setProducts(newList)
  }

  return (
    <>
      {categoryId !== 0 && <h3>Products for category: {categoryId}</h3>}
      <main className="d-flex flex-column gap-3 p-4 mb-5">
        {
          products.map((product) =>
            <ProductCard key={product.productId}
              product={product}
              onProductDeleted={productDeleted}
            />
          )
        }
      </main>
    </>
  )
}