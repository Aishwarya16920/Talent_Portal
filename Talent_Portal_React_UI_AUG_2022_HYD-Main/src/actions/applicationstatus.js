import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_URL_JOB } from '../utils/constant';

const applnstatus = createAsyncThunk(
    'applnStatus',
    async (object, { getState, rejectWithValue }) => {
        try {
            const { data } = await axios.get(
                `${BASE_URL_JOB}/userStatus`,
              {
                headers: {

                  'Content-type': 'application/json; charset=UTF-8',

                  'Access-Control-Allow-Origin': '*',

                 'Authorization': `Bearer ${object.authToken}`
          
                }  
              }         
            );
            return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  )

export default applnstatus;
