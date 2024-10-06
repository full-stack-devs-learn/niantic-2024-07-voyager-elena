import axios from 'axios'
import Category from '../models/category'

/*
* I used my Northwind API server from day 06 exercise
* https://github.com/full-stack-devs-learn/niantic-2024-07-voyager-elena/tree/main/sprint-3/06-rest-api/exercise_rest-api
*/

class CategoryService {
  baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

  async getAllCategories() {
    const response = await axios.get(this.baseUrl)
    return response.data
  }

  async getCategoryById(categoryId: number) {
    const response = await axios.get(`${this.baseUrl}/${categoryId}`)
    return response.data
  }

  async addCategory(category: Category) {
    const response = await axios.post(this.baseUrl, category)
    return response.data
  }

  async updateCategory(category: Category) {
    const response = await axios.put(`${this.baseUrl}/${category.categoryId}`, category)
    return response.data
  }

  async deleteCategory(categoryId: number) {
    await axios.delete(`${this.baseUrl}/${categoryId}`)
  }
}

const categoryService = new CategoryService()
export default categoryService