import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Header from './components/shared/header/Header'
import HomePage from './components/home-page/HomePage'
import CategoriesPage from './components/categories/categories-page/CategoriesPage'
import CategoriesList from './components/categories/categories-list/CategoriesList'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'
import ProductsPage from './components/products/products-page/ProductsPage'
import ProductSearch from './components/products/product-search/ProductSearch'
import ProductDetails from './components/products/product-details/ProductDetails'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductEdit from './components/products/product-edit/ProductEdit'

const App = () => {

  return (
    <BrowserRouter>
      <Header />
      <main className="container p-4">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/categories" element={<CategoriesPage />}>
            <Route path='' element={<CategoriesList />} />
            <Route path=':categoryId' element={<CategoryDetails />} />
            <Route path='add' element={<CategoryAdd />} />
            <Route path=':categoryId/edit' element={<CategoryEdit />} />
          </Route>
          <Route path='/products' element={<ProductsPage />}>
            <Route path='' element={<ProductSearch />} />
            <Route path=':productId' element={<ProductDetails />} />
            <Route path='add' element={<ProductAdd />} />
            <Route path=':productId/edit' element={<ProductEdit />} />
          </Route>
        </Routes>
      </main>
    </BrowserRouter>
  )
}

export default App
