import axios from 'axios';
import { BASE_URL_EMP } from '../utils/constant';
import { createAsyncThunk } from '@reduxjs/toolkit';



const deleteJob = createAsyncThunk(
    'deleteJob',

    async (storeid, { getState, rejectWithValue }) => {
      console.log(storeid.id);
        try {
           const { data } = await axios.delete(
            `${BASE_URL_EMP}/deletejob/`+ storeid.id,
              {
              headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*',
                'Authorization': `Bearer ${storeid.authToken}`

            }  

        }          
           );
             return data;
          } catch (error) {
           return rejectWithValue(error.response);
          }
    }

  )




export default deleteJob;