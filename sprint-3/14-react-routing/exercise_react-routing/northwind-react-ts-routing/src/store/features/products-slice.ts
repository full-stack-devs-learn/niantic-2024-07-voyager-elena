import { createSlice, PayloadAction, createAsyncThunk } from '@reduxjs/toolkit'
import Product from '../../models/product'
import productService from '../../services/product-service'

interface ProductsState {
  products: Product[]
  loading: boolean
  error: string | null
}

const initialState: ProductsState = {
  products: [],
  loading: false,
  error: null
}


export const loadProducts = createAsyncThunk('products/getProducts', async (categoryId: number) => {
  const products = await productService.getProducts(categoryId)
  return products
})

export const addProduct = createAsyncThunk('/updateProduct', async (product: Product) => {
  const newProduct = await productService.addProduct(product)
  return newProduct
})

export const updateProduct = createAsyncThunk('products/updateProduct', async (product: Product) => {
  await productService.updateProduct(product)
  return product
})

export const deleteProduct = createAsyncThunk('products/deleteProduct', async (productId: number) => {
  await productService.deleteProduct(productId)
  return productId
})


const productsSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {

  },
  extraReducers: (builder) => {
    // Fetch Products
    builder.addCase(loadProducts.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(loadProducts.fulfilled, (state, action: PayloadAction<Product[]>) => {
      state.loading = false;
      state.products = action.payload;
    })
    builder.addCase(loadProducts.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to fetch products';
    })

    // Add Product
    builder.addCase(addProduct.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(addProduct.fulfilled, (state, action: PayloadAction<Product>) => {
      state.loading = false;
      state.products.push(action.payload);
    })
    builder.addCase(addProduct.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to add product';
    })

    // Update Product
    builder.addCase(updateProduct.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(updateProduct.fulfilled, (state, action: PayloadAction<Product>) => {
      state.loading = false;
      const index = state.products.findIndex(product => product.productId === action.payload.productId);
      if (index !== -1) {
        state.products[index] = action.payload;
      }
    })
    builder.addCase(updateProduct.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to update product';
    })

    // Delete Product
    builder.addCase(deleteProduct.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(deleteProduct.fulfilled, (state, action: PayloadAction<number>) => {
      state.loading = false;
      state.products = state.products.filter(product => product.productId !== action.payload);
    })
    builder.addCase(deleteProduct.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to delete product';
    })
  }
})

const productsReducer = productsSlice.reducer
export default productsReducer