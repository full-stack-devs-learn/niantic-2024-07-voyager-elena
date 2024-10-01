import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Header from './components/shared/header/Header'

const App = () => {

  return (
    <BrowserRouter>
      <Header />
      <h1> Northwind React TS App</h1 >
    </BrowserRouter>
  )
}

export default App
