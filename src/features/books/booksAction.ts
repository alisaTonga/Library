import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const getBooks = createAsyncThunk(
  'getBooks',
  async (_, thunkAPI) => {
    try {
      const response = await axios.get('http://localhost:8080/my-Library/books');
      return response.data;
    } catch (error: any) {
      return thunkAPI.rejectWithValue(error.message);
    }
  }
);

export const addBook = createAsyncThunk(
  'addBook',
  async (book: { title: string; author: string; year: number; isbn13: string }, thunkAPI) => {
    try {
      const response = await axios.post('http://localhost:8080/my-Library/books', book);
      return response.data;
    } catch (error: any) {
      return thunkAPI.rejectWithValue(error.message);
    }
  }
);