import { useState } from 'react'
import productService from '../../../services/product-service'
import './ProductAdd.css'

const ProductAdd = ({ onCancel, onProductAdded }) => {

  const [categoryId, setCategoryId] = useState(null)
  const [productName, setProductName] = useState('')
  const [quantityPerUnit, setQuantityPerUnit] = useState(0)
  const [unitPrice, setUnitPrice] = useState(0)
  const [unitsInStock, setUnitsInStock] = useState(0)
  const [unitsOnOrder, setUnitsOnOrder] = useState(0)
  const [reorderLevel, setReorderLevel] = useState(0)

  const addProductHandler = async (event) => {
    event.preventDefault()

    const newProduct = {
      productName: productName
    }

    if (categoryId) {
      newProduct.categoryId = categoryId
    }
    if (quantityPerUnit) {
      newProduct.quantityPerUnit = quantityPerUnit
    }
    if (unitPrice) {
      newProduct.unitPrice = unitPrice
    }
    if (unitsInStock) {
      newProduct.unitsInStock = unitsInStock
    }
    if (unitsOnOrder) {
      newProduct.unitsOnOrder = unitsOnOrder
    }
    if (reorderLevel) {
      newProduct.reorderLevel = reorderLevel
    }

    await productService.addProduct(newProduct)
    onProductAdded()
  }

  return (
    <>
      <h2 className="mb-3">Add New Product</h2>

      <form onSubmit={addProductHandler} >

        <div className="row">
          <label htmlFor="product-name">Product Name:</label>
          <input type="text" className="form-control" name="product-name" id="product-name"
            onChange={(e) => setProductName(e.target.value)}
          />
        </div>

        <div className="row mb-3">
          <label htmlFor="price">Unit Price:</label>
          <input type="text" className="form-control" name="price" id="price"
            onChange={(e) => setUnitPrice(e.target.value)} />
        </div>

        <div className="d-flex flex-row justify-content-center align-items-center gap-3">
          <button className="btn btn-danger" type="submit">Add Product</button>
          <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button>
        </div>

      </form>
    </>
  )
}

export default ProductAdd