import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit'
import { AdminHomePage } from '../components/admin/adminhomepage';
import { BASE_URL_EMP } from '../utils/constant';

const editPostedJob = createAsyncThunk(
    'editPostedJob',
    async (editJob, { getState, rejectWithValue }) => {
        try {
            const { data } = await axios.put(
              `${BASE_URL_EMP}/updatejob/${editJob.id}`,
              editJob,
              {
                headers : {
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*',
                'Authorization': `Bearer ${editJob.authToken}`
          }   
        }                
            );
             return data;
          } catch (error) {
            return rejectWithValue(error.response.data);
          }
    }
  )


export default editPostedJob;