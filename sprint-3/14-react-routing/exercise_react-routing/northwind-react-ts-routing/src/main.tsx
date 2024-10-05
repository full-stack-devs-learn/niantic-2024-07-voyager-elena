import { createRoot } from 'react-dom/client'
import App from './App.tsx'

import 'bootstrap/dist/js/bootstrap.min.js'
import 'bootswatch/dist/united/bootstrap.min.css'

import { Provider } from 'react-redux'
import store from './store/store.ts'

import './index.css'

createRoot(document.getElementById('root')!).render(
  <Provider store={store}>
    <App />
  </Provider>
)
