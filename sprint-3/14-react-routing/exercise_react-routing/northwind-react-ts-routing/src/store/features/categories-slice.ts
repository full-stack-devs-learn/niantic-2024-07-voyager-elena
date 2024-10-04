import { createSlice, PayloadAction, createAsyncThunk } from '@reduxjs/toolkit'
import Category from '../../models/category'
import categoryService from '../../services/category-service'

interface CategoriesState {
  categories: Category[]
  loading: boolean
  error: string | null
}

const initialState: CategoriesState = {
  categories: [],
  loading: false,
  error: null
}


export const loadCategories = createAsyncThunk('categories/getCategories', async () => {
  const categories = await categoryService.getAllCategories()
  return categories
})

export const addCategory = createAsyncThunk('/updateCategory', async (category: Category) => {
  const newCategory = await categoryService.addCategory(category)
  return newCategory
})

export const updateCategory = createAsyncThunk('categories/updateCategory', async (category: Category) => {
  await categoryService.updateCategory(category)
  return category
})

export const deleteCategory = createAsyncThunk('categories/deleteCategory', async (categoryId: number) => {
  await categoryService.deleteCategory(categoryId)
  return categoryId
})


const categoriesSlice = createSlice({
  name: 'categories',
  initialState,
  reducers: {

  },
  extraReducers: (builder) => {
    // Fetch Categories
    builder.addCase(loadCategories.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(loadCategories.fulfilled, (state, action: PayloadAction<Category[]>) => {
      state.loading = false;
      state.categories = action.payload;
    })
    builder.addCase(loadCategories.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to fetch categories';
    })

    // Add Category
    builder.addCase(addCategory.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(addCategory.fulfilled, (state, action: PayloadAction<Category>) => {
      state.loading = false;
      state.categories.push(action.payload);
    })
    builder.addCase(addCategory.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to add category';
    })

    // Update Category
    builder.addCase(updateCategory.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(updateCategory.fulfilled, (state, action: PayloadAction<Category>) => {
      state.loading = false;
      const index = state.categories.findIndex(category => category.categoryId === action.payload.categoryId);
      if (index !== -1) {
        state.categories[index] = action.payload;
      }
    })
    builder.addCase(updateCategory.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to update category';
    })

    // Delete Category
    builder.addCase(deleteCategory.pending, (state) => {
      state.loading = true;
      state.error = null;
    })
    builder.addCase(deleteCategory.fulfilled, (state, action: PayloadAction<number>) => {
      state.loading = false;
      state.categories = state.categories.filter(category => category.categoryId !== action.payload);
    })
    builder.addCase(deleteCategory.rejected, (state, action) => {
      state.loading = false;
      state.error = action.error.message || 'Failed to delete category';
    })
    
  }
})

const categoriesReducer = categoriesSlice.reducer
export default categoriesReducer