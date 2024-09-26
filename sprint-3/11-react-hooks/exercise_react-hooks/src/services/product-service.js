import axios from 'axios'

class CategoryService {
  baseUrl = 'http://localhost:8080/api/products'

  async getProducts(categoryId) {
    const response = await axios.get(`${this.baseUrl}?catId=${categoryId}`)
    return response.data
  }

  async addProduct(product) {
    const response = await axios.post(this.baseUrl, product)
    return response.data
  }

  async deleteProduct(productId) {
    await axios.delete(`${this.baseUrl}/${productId}`)
  }
}

export default new CategoryService()