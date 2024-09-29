import axios from 'axios'

/*
* I used my Northwind API server from day 06 exercise
* https://github.com/full-stack-devs-learn/niantic-2024-07-voyager-elena/tree/main/sprint-3/06-rest-api/exercise_rest-api
*/

class CategoryService {
  baseUrl = 'http://localhost:8080/api/categories'

  async getAllCategories() {
    const response = await axios.get(this.baseUrl);
    return response.data;
  }

  async addCategory(category) {
    const response = await axios.post(this.baseUrl, category);
    return response.data;
  }

  async deleteCategory(categoryId) {
    await axios.delete(`${this.baseUrl}/${categoryId}`)
  }
}

const categoryService = new CategoryService()
export default categoryService;