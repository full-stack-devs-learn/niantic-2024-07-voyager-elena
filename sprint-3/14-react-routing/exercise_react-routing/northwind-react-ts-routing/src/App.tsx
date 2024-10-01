import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Header from './components/shared/header/Header'
import Home from './components/home/Home'
import CategoriesPage from './components/categories/categories-page/CategoriesPage'
import CategoriesList from './components/categories/categories-list/CategoriesList'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'

const App = () => {

  return (
    <BrowserRouter>
      <Header />
      <main className="container p-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/categories" element={<CategoriesPage />}>
            <Route path='' element={<CategoriesList />} />
            <Route path=':categoryId' element={<CategoryDetails />} />
            <Route path='add' element={<CategoryAdd />} />
            <Route path=':categoryId/edit' element={<CategoryEdit />} />
          </Route>
          {/* <Route path='/products' element={<ProductsPage />}>
            <Route path='' element={<ProductSearch />} />
            <Route path=':productId' element={<ProductDetails />} />
            <Route path='add' element={<ProductAdd />} />
            <Route path=':productId/edit' element={<ProductAdd />} />
          </Route> */}
        </Routes>
      </main>
    </BrowserRouter>
  )
}

export default App
