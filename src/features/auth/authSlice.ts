import { createSlice } from '@reduxjs/toolkit';
import { IUserData } from './types/authType';
import { getUserWithToken, loginUser } from './authAction';
import { stat } from 'fs';

interface IUserState{
    user: IUserData
    isloading: boolean
    error: string
}
const initialUser: IUserData = {
    id: 0,
    username: '',
    email: '',
    firstName: '',
    lastName: '',
    gender: '',
    image: '',
    token: '',
    refreshToken: ''
}
const initialState: IUserState = {
  user: initialUser,
  isloading: false,
  error: '',
};

export const authSlice = createSlice({
  name: 'authSlice',
  initialState,
  reducers: {
    logoutUser: (state) => {
      state.user = initialUser}
  },
  extraReducers: (builder) => {
    builder
      .addCase(loginUser.pending, (state) => {
        state.isloading = true;
      })
      .addCase(loginUser.fulfilled, (state, action) => {
        state.isloading = false
        state.user = action.payload;
      })
      .addCase(loginUser.rejected, (state, action) => {
        state.isloading = false
        state.user = initialUser
        state.error = action.payload as string
      })
      .addCase(getUserWithToken.fulfilled, (state, action)=>{
        state.isloading = false
        state.user = action.payload;
      })
      .addCase(getUserWithToken.pending, (state, action)=>{
        state.isloading = true
      })
  },
});

export default authSlice;
export const {logoutUser } = authSlice.actions