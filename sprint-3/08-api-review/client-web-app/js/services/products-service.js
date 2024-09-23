class ProductsService {

  baseUrl = `${config.baseUrl}/products`;

  getAllProducts() {
    return axios.get(this.baseUrl)
      .then(response => {
        return response.data;
      });
  }

  getProductsByCategory(categoryId) {
    return axios.get(`this.baseUrl?catId=${categoryId}`)
      .then(response => {
        return response.data;
      });
  }

  getProductById(productId) {
    return axios.get(`${this.baseUrl}/${productId}`)
      .then(response => {
        return response.data;
      });
  }

  addProduct(product) {
    return axios.post(this.baseUrl, product)
      .then(response => {
        return response.data;
      });
  }

  updateProduct(productId, product) {
    return axios.put(`${this.baseUrl}/${productId}`, product);
  }

  deleteCategory(productId) {
    return axios.delete(`${this.baseUrl}/${productId}`);
  }
}