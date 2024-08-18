import { createSlice } from "@reduxjs/toolkit";
import { getBooks } from "./booksAction";
import { IBook } from "../../components/library/MyLibrary";

interface IBookState{
    books: IBook[];
    isLoading: boolean;
    error: string;
}

const initialState: IBookState = {
  books: [],
  isLoading: false,
  error: '',
};

export const booksSlice = createSlice({
  name: "booksSlice",
  initialState,
  reducers: {
    clearBooks: (state) => {
      state.books = []}
  },
  extraReducers: (builder) => {
    builder
      .addCase(getBooks.pending, (state) => {
        state.isLoading = true;
      })
      .addCase(getBooks.fulfilled, (state, action) => {
        state.isLoading = false;
        state.books = action.payload;
      })
      .addCase(getBooks.rejected, (state, action) => {
        state.isLoading = false;
        state.books = [];
        state.error = action.payload as string;
      });
  },
});

export default booksSlice;
export const {clearBooks} = booksSlice.actions