import { createAsyncThunk } from '@reduxjs/toolkit';
import axios, { Axios, AxiosResponse } from 'axios';
import { ILoginValues } from '../../components/login/Login';
import { IUserData } from './types/authType';

export const loginUser = createAsyncThunk(
    'loginUser',
    async (data: ILoginValues, thunkAPI) => {

        console.log('Data:', data);
        
        try {
        const response: AxiosResponse<IUserData> = await axios.post('https://dummyjson.com/auth/login', data);
        localStorage.setItem("userToken", response.data.token)
        return response.data;
        } catch (error: any) {
        return thunkAPI.rejectWithValue(error.message);
        }
    }
);

export const getUserWithToken = createAsyncThunk(
    'getUserWithToken',
    async (token: string, thunkAPI) => {        
        try {
        const response: AxiosResponse<IUserData> = await axios.get('https://dummyjson.com/auth/me', 
            {  headers: {
            'Authorization': `Bearer ${token}`, 
            }, });
        return response.data;
        } catch (error: any) {
        return thunkAPI.rejectWithValue(error.message);
        }
    }
);