import axios from 'axios';
import {createAsyncThunk} from '@reduxjs/toolkit'
import { BASE_URL_JOB } from '../utils/constant';

const getAllbyskill = createAsyncThunk(
    'getAllbyskill',
    async (searchskill, { getState, rejectWithValue }) => {

        try {
            const { data } = await axios.get(
              `${BASE_URL_JOB}/search/${searchskill.skills}`,
              {

                headers:{
                'Content-type': 'application/json; charset=UTF-8',
                'Access-Control-Allow-Origin': '*'
                }
            }              
            );
            return data;
          } catch (error) {
            rejectWithValue(error.response);
          }
    }
  )


export default getAllbyskill;