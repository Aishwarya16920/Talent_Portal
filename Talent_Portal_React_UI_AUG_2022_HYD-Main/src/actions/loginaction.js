import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_URL_USER } from '../utils/constant';

const loginUser = createAsyncThunk(
    'loginUser',
    async (loginDetail, { getState, rejectWithValue }) => {
        try {
            const { data } = await axios.post(
              `${BASE_URL_USER}/authenticate`,
              loginDetail,
              {
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*',
            }              
            );
             return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  )


export default loginUser;