import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_URL_JOB } from '../utils/constant';

const updateStatus = createAsyncThunk(
    'updateStatus',
    async (update, { getState, rejectWithValue }) => {
        try {
            const { data } = await axios.put(
              `${BASE_URL_JOB}/updateuserStatus`,
              update,
              {
                headers: {

                  'Content-type': 'application/json; charset=UTF-8',

                  'Access-Control-Allow-Origin': '*',

                 'Authorization': `Bearer ${update.authToken}`
          
                }  
              }         
            );
            return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  )

export default updateStatus;
