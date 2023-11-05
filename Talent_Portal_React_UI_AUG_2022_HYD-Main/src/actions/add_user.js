import axios from 'axios';
import { createAsyncThunk } from '@reduxjs/toolkit';
import { BASE_URL_USER } from '../utils/constant';

const addNewUser = createAsyncThunk(
    'addNewUser',
    async (newUser, { getState, rejectWithValue }) => {
        try {
            const { data } = await axios.post(
              `${BASE_URL_USER}/users/`,
              newUser,
              {
              headers: {

                'Content-type': 'application/json; charset=UTF-8',

                 'Access-Control-Allow-Origin': '*',
              'Access-Control-Allow-Methods': 'post',
            }  
        }         
            );
            return data;
          } catch (error) {
            return rejectWithValue(error.response.data);
          }
    }
  )


export default addNewUser;