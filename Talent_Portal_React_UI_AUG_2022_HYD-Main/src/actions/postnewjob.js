import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { BASE_URL_EMP } from '../utils/constant';

const addNewJob = createAsyncThunk(

    'addNewJob',

    async (newJob, { getState, rejectWithValue }) => {

        try {
            const { data } = await axios.post(

              `${BASE_URL_EMP}/job`,

              newJob,
              {
headers:{

                'Content-type': 'application/json; charset=UTF-8',

                'Access-Control-Allow-Origin': '*',
                
                'Authorization': `Bearer ${newJob.authToken}`
}
            }              

            );


            return data;

          } catch (error) {

            return rejectWithValue(error.response);

          }

    }

  )




export default addNewJob;