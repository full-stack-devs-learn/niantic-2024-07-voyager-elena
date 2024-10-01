import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'

import 'bootstrap/dist/js/bootstrap.min.js'
import 'bootswatch/dist/united/bootstrap.min.css'

import './index.css'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>
)
