import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import addNewUser from '../actions/add_user';
import logout from "../actions/logoutaction";
import loginUser from "../actions/loginaction";
import findJob from "../actions/find_job";
import applyJob from "../actions/apply_job";
import addNewJob from "../actions/postnewjob";
import getUserInfo from "../actions/getUserInfo";
import editPostedJob from "../actions/editpostedjob";
import GetListofjobs from "../actions/listofjobs";
import userpage from "../actions/userpage";
import getAllbyskill from "../actions/jobsearchbyskill";
import applnstatus from "../actions/applicationstatus";
import readAllJobs from "../actions/read_all_jobs";
import deleteJob from "../actions/delete_job";

const talentPortal = createSlice({
    name: 'postJobPortal',
    initialState: {
      jobs: [],  
      userprofile:[], 
      joblist:[],
      jobappliedintheprotal:[],  
      userjoblist:[],
      appdetails:[],
      Searchjobs:[],
      loading: false,
      authToken:"",
      jobli:"",
      erroruseralreadyexist:"",
      adminlist: []
  },
  reducers: {
  },
  extraReducers: {
    [loginUser.fulfilled]: (state, { payload }) => {
      state.loading = false;
      if(payload){
          state.authToken = payload.token;
          localStorage.setItem('authToken', payload.token);
          localStorage.setItem('username',payload.username);
      }
      else{
          state.authToken = null;
      }
      state.isSuccess = true;
      
    },
    [loginUser.rejected]: (state, { payload }) => {
      state.loading = false;
      state.isSuccess = false;
      state.message = "failed";
    },

      [addNewUser.pending]: (state, action) => {
        state.loading = true;
      },

      [addNewUser.fulfilled]: (state, { payload }) => {
        if(!(payload.username === "Username is already exits")){
        state.loading = false;
        state.jobs.push(payload);
        state.isSuccess = true;
        }

    },

      [addNewUser.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
        state.erroruseralreadyexist=payload;
      },

      [addNewJob.pending]: (state, action) => {

        state.loading = true;

      },

      [addNewJob.fulfilled]: (state, { payload }) => {

        state.loading = false;

        state.adminlist.push(payload);

        state.adminlist = [...state.adminlist];

        state.isSuccess = true;

      },

      [addNewJob.rejected]: (state, { payload }) => {

        state.loading = false;

        state.isSuccess = false;

        state.message = "failed";

      },

      [logout.pending]: (state, action) => {
        state.loading = true;
      },
      [logout.fulfilled]: (state, { payload }) => {
        state.loading = false;
        state.authToken = undefined;
        state.isSuccess = true;
        localStorage.setItem("authToken",null);
        localStorage.setItem('username',null);
        localStorage.setItem("jobli",null);
        
      },
      [logout.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      }, 
      [findJob.pending]: (state, action) => {
        state.loading = true;
      },
      [findJob.fulfilled]: (state, { payload }) => {
        state.loading = false;
         state.joblist =payload;
        state.isSuccess = true;
      },
      [findJob.rejected]: (state, { payload }) => {
       state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      }, 
      [userpage.pending]: (state, action) => {
        state.loading = true;
      },
      [userpage.fulfilled]: (state, { payload }) => {
        state.loading = false;
         state.userjoblist =payload;
        state.isSuccess = true;
      },
      [userpage.rejected]: (state, { payload }) => {
       state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      }, 
    [applyJob.pending]: (state, action) => {
      state.loading = true;
    },
    [applyJob.fulfilled]: (state, { payload }) => {
      state.loading = false;
      state.data=payload;
      let authToken = localStorage.getItem("authToken");
      
    },
    [applyJob.rejected]: (state, { payload }) => {
      state.loading = false;
      state.isSuccess = false;
      state.message = "failed";
    },   
   

      [getUserInfo.pending]: (state, action) => {
        state.loading = true;
      },
      [getUserInfo.fulfilled]: (state, { payload }) => {
        state.loading = false;
        state.userprofile = payload;
        state.isSuccess = true;
      },
      [getUserInfo.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      },
      [GetListofjobs.pending]: (state, action) => {
        state.loading = true;
      },
      [GetListofjobs.fulfilled]: (state, { payload }) => {
        state.loading = false;
        state.jobappliedintheprotal = payload;
        state.isSuccess = true;
      },
      [GetListofjobs.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      },
      [getAllbyskill.pending]: (state, action) => {
  
        state.loading = true;
      },

      [getAllbyskill.fulfilled]: (state, { payload }) => {

        state.loading = false;
        state.data = payload;
        state.Searchjobs=payload;
        state.Searchjobs=[...state.Searchjobs];
        state.isSuccess = true;
      },

      [getAllbyskill.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      },  
       
      
      [readAllJobs.pending]: (state, action) => {
        state.loading = true;
      },
      [readAllJobs.fulfilled]: (state, { payload }) => {
        state.loading = false;
        state.adminlist = payload;
        state.isSuccess = true;
      },
      [readAllJobs.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      },    
      [deleteJob.pending]: (state, action) => {
        state.loading = true;
      },
      
      [deleteJob.fulfilled]: (state, { payload }) => {
        let jobIndex=-1;
        state.adminlist.map((job, index)=>{
        if(job.id===payload.id){
             jobIndex=index;
        }
        })
        if(jobIndex!=-1){
          state.adminlist.splice(jobIndex,1);
        }
        state.adminlist = [...state.adminlist];
        state.loading = false;
        state.data = payload;
        state.isSuccess = true;
      },

      [deleteJob.rejected]: (state, { payload }) => {
        state.loading = false;
        state.isSuccess = false;
        state.message = "failed";
      },

      [applnstatus.rejected]: (state,{ payload }) => {

        state.loading = false;

        state.isSuccess = false;

        state.message = "failed";

      },



      [applnstatus.fulfilled]: (state, { payload }) => {

        state.loading = false;

        state.appdetails= payload;

        state.isSuccess = true;

      },



      [applnstatus.pending]: (state, action) => {

        state.loading = true;

      },
      
    }
  }, 
  );

  export default talentPortal;
