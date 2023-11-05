import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { BASE_URL_JOB } from '../utils/constant';

const applyJob = createAsyncThunk(
    'postJob',
    async (postJob, { getState, rejectWithValue }) => {

        try {
            const { data } = await axios.post(
              `${BASE_URL_JOB}/jobid`,
              postJob,
              {
                headers:{
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*',
                }
                

            }              
        );
            return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  );


export default applyJob;