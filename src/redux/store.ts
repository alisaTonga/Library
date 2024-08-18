import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit"
import authSlice from "../features/auth/authSlice"
import booksSlice from "../features/books/booksSlice"


export const store = configureStore({
  reducer: {
    books: booksSlice.reducer,
    user: authSlice.reducer
  },
})

export type AppDispatch = typeof store.dispatch
export type RootState = ReturnType<typeof store.getState>
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>
