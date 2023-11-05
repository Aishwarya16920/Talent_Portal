import { useDispatch, useSelector } from "react-redux";
import {useEffect, useState, useRef} from 'react';
import readAllJobs from "../../actions/read_all_jobs";
import deleteJob from "../../actions/delete_job";
import { AllJobsPosted } from "./all_jobs_posted";
import { Link, useNavigate } from 'react-router-dom';
import logout from "../../actions/logoutaction";
import React from "react";
import ApplnStatus from "./applicationstatus";
import { PostNewJob } from "./postnewjob";

const AdminHomePage = (props) =>{

    let dispatcher = useDispatch();
    let navigate = useNavigate();
    let returnjobs = useSelector((state)=>state.adminlist);
    let authToken = localStorage.getItem("authToken");
const update=(id)=>{
localStorage.setItem("id",id);
navigate("/admin/editpostedjob")
}
    const logoutFunc = async()=>{ 

      let logoutResponse = dispatcher(logout(authToken));


      if(logoutResponse.payload){

       navigate('/login')

      } else {  
          navigate('/')
      }

  }
    const deleteFunc = (id)=>
    {   let storeid={id,authToken}
        let logoutResponse = dispatcher(deleteJob(storeid));
    }

    const[selectedTab, setSelectedTab] = React.useState("JOB_DETAILS");

    const changeTab = (tabName)=> {
      localStorage.setItem("ACTIVE_TAB", tabName);
      setSelectedTab(tabName);
    }

    useEffect(
        ()=> {
            return ()=>dispatcher(readAllJobs(authToken));
            
        }, [])
  

        if(returnjobs===undefined) 
        returnjobs = [];
            let returnjobsData =  returnjobs.map(function(returnjob, index) {
                return (
                    <ul class="nav" key={index} >
                     <div class="container">          
            <div class="card mt-3 c-card" >
                <div class="card-body">
                    <div class="row scroll-sm">                      
                        <div class="col-md-2 col-sm-2">
                        <div class="company-logo">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"></img>
                          </div>
                          </div>
                         <div class="col-md-8 col-sm-8">
                          <div class="job-info-head">
                            <h3 align="left">{returnjob.title}</h3>
                            <h6 align="left">About the job: {returnjob.description}</h6>
                            
                  <li class="nav-item"><span class="nav-link disabled"><i  style={{fontsize:"16px"}}></i>Primary Skill: {returnjob.primarySkill}</span></li>
                  <li class="nav-item"><span class="nav-link disabled"><i  style={{fontsize:"16px"}}></i>Secondary Skill: {returnjob.secSkills}</span></li>
                  <li class="nav-item"><span class="nav-link disabled"><i style={{fontsize:"16px"}}><i class="fa-regular fa fa-briefcase"></i></i>Exp: {returnjob.minExp}-{returnjob.maxExp}</span></li>
                  <li class="nav-item"><span class="nav-link disabled" ><i class="fa fa-map-marker" style={{fontsize:"16px"}}></i> {returnjob.location}</span></li>
                  </div>
                  </div>            
                  <div class="col-md-2 col-sm-2">
                    <div class="job-apply">
                    <button type="button" class="btn btn-primary  btn-sm m-1" onClick={update.bind(this,returnjob.id)}>Edit</button>
                    <button type="button" class="btn btn-danger  btn-sm mr-1" onClick={deleteFunc.bind(this, returnjob.id)}>Delete</button>
                    
                  </div>
                            </div>
                        </div>
                    </div>
                </div>     
                </div>    
            </ul> 
  );               
  }) 
  return(
      <section>
        <header>

{

     authToken === "" ?

    <nav class="navbar navbar-expand-lg header-navbar">

        <div class="container-fluid">

          <a class="navbar-brand" href="/">

            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100" align="left"/>

          </a>

        </div>

    </nav>



    :

    <nav class="navbar navbar-expand-lg header-navbar">

            <div class="container-fluid">

              <a class="navbar-brand" href="/">

                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfxOmhBy9N06InPK-TwMk9abz-EPgzF6GmLrG4OfUeqrLem5_uFIOx2Fpesfjrw94ETA&usqp=CAU" alt="logo" width="100"/>

              </a>

              <div class="col-12 col-md-auto mb-2 justify-content-center  mb-md-0">

                <h5>Admin Home Page</h5>

              </div>

                <div class="col-md-3 text-end">

                    <button type="button" class="btn btn-primary btn-sm" onClick={logoutFunc}>LOGOUT</button>

                  </div>

            </div>

          </nav>

    }

</header>
  <div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" data-bs-toggle="tab" href="#job_details" onClick={()=>changeTab("JOB_DETAILS")}>Jobs posted by me</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-bs-toggle="tab" href="#all_jobs_post" onClick={()=>changeTab("ALL_JOBS_POSTED")}>All Jobs posted</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-bs-toggle="tab" href="#job_Applicant" onClick={()=>changeTab("JOB_APPLICANT")}>Applicant Details</a>
        </li>
      </ul>
    <div class="tab-content"> 
      { selectedTab === "JOB_DETAILS" &&
        <div id="job_details" class="container tab-pane active"><br></br>
          <div class="job_detailsTab">
              <div class="col-md-12 text-end">
                  <Link to ="/admin/postnewjob"><button type="button" class="btn btn-primary  btn-sm">Post a new job</button></Link>
              </div>
              {returnjobsData}
            </div>
        </div>
      }
{ selectedTab === "ALL_JOBS_POSTED" &&
      <div id="all_jobs_post" class="container tab-pane active"><br></br>
      <div class="job_deatilsTab">
        <AllJobsPosted></AllJobsPosted>  
        </div>
      </div>
    }

{ selectedTab === "JOB_APPLICANT" &&
   <div id="job_Applicant" class="container tab-pane active"> <br></br>
    <div class="job_ApplicantTab">
      <ApplnStatus></ApplnStatus>
    </div>
    </div>   
}
    </div>
      </div>
</section>

);
    }

export {AdminHomePage};