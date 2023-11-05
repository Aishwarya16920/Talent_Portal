import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { BASE_URL_USER } from '../utils/constant';
const logout = createAsyncThunk(
    'logout',
    async (authToken, { getState, rejectWithValue }) => {
        try {
           const { data } = await axios.delete(
            `${BASE_URL_USER}/user/logout`,
              {
              headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*',
                'Authorization': `Bearer ${authToken}`
            }  
        }          
           );
             return data;
          } catch (error) {
           return rejectWithValue(error.response);

          }

    }
  )






export default logout;