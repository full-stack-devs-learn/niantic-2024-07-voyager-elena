import axios from 'axios'

/*
* I used my Northwind API server from day 06 exercise
* https://github.com/full-stack-devs-learn/niantic-2024-07-voyager-elena/tree/main/sprint-3/06-rest-api/exercise_rest-api
*/

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