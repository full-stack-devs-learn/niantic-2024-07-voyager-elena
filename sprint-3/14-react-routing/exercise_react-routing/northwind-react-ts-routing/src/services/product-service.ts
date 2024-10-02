import axios from 'axios'
import Product from '../models/product'

/*
* I used my Northwind API server from day 06 exercise
* https://github.com/full-stack-devs-learn/niantic-2024-07-voyager-elena/tree/main/sprint-3/06-rest-api/exercise_rest-api
*/

class ProductService {
  baseUrl = 'http://localhost:8080/api/products'

  async getProducts(categoryId: number) {
    const response = await axios.get(`${this.baseUrl}?catId=${categoryId}`)
    return response.data
  }

  async addProduct(product: Product) {
    const response = await axios.post(this.baseUrl, product)
    return response.data
  }

  async updateProduct(product: Product) {
    const response = await axios.put(`${this.baseUrl}/${product.productId}`, product)
    return response.data
  }

  async deleteProduct(productId: number) {
    await axios.delete(`${this.baseUrl}/${productId}`)
  }
}

export default new ProductService()