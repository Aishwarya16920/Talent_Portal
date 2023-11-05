import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { BASE_URL_JOB } from '../utils/constant';

const GetListofjobs = createAsyncThunk(
    'GetListofjobs',
    async (authToken, { getState, rejectWithValue }) => {
        try {
          
            const { data } = await axios.get(
              `${BASE_URL_JOB}/userjobStatus`,
              {
                  headers:{

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
  );


export default GetListofjobs;