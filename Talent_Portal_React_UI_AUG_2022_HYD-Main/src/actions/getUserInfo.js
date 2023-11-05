import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_URL_USER } from '../utils/constant';

const getUserInfo = createAsyncThunk(
    'getUserInfo',
    async (authToken, { getState, rejectWithValue }) => {
     try {
            const { data } = await axios.get(
              `${BASE_URL_USER}/user`,
              {
                headers: {

                  'Content-type': 'application/json; charset=UTF-8',

                  'Access-Control-Allow-Origin': '*',

                  'Authorization':`Bearer ${authToken}`
                
                }  
              }         
            );
            return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  )

export default getUserInfo;
