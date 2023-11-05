import {useEffect, useState, useRef} from 'react';
 import {useDispatch, useSelector} from 'react-redux';
 import { FindJob } from '../jobseeker/findjob';
 import findJob from '../../actions/find_job';
 import React from 'react';
 import {Link} from 'react-router-dom'
import { AdminHomePage } from './adminhomepage';
import { SearchBySkill } from '../jobseeker/jobsearchbyskill';

const AllJobsPosted=(props)=>{
let skill=useRef();
let Title=useRef();
let Description=useRef();
let MinExp=useRef();
let Location=useRef();
let CreatedDate=useRef();
let [primarySkill,setSkills]=useState("");
    let dispatcher = useDispatch();  
    let jobs = useSelector((state)=>state.joblist);
    useEffect(
        ()=> {
            return ()=>dispatcher(findJob());
        }, [])

        if(jobs===undefined) 
             jobs = [];
             let jobsData =  jobs.map(function(job, index) {              
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
                            <h3 align="left" ref={Title}>{job.title}</h3> <br></br>
                  <h6 ref={Description}>{job.description}</h6>
                  <li class="nav-item" ref={skill}><span class="nav-link disabled"><i  style={{fontsize:"16px"}} ></i>Skill: {job.primarySkill}</span></li>
                  <li class="nav-item" ref={MinExp}><span class="nav-link disabled"><i  style={{fontsize:"16px"}}></i> Exp:  {job.minExp}-{job.maxExp} Yrs</span></li>
                  <li class="nav-item" ref={Location}><span class="nav-link disabled" ><i class="fa fa-map-marker" style={{fontsize:"16px"}}></i> {job.location}</span></li>
                  <li class="nav-item" ref={CreatedDate}><span class="nav-link disabled"><i class="fa fa-calendar" style={{fontsize:"16px"}}></i> {job.createdDate}</span></li>
                                </div>
                            </div>
                           
                    </div>
                </div>
            </div>
            
          </div>                                   
                  </ul>                   
                );
                  
             })  
    return(  <section>
            <div class="container">
    <ul class="nav nav-tabs" role="tablist">
      </ul>
    <div class="tab-content">
        <div id="all_jobs_posted" class="container tab-pane active"><br></br>
        <div class="job_detailsTab">
            {jobsData}
        </div>
        </div>
        </div>
        </div>

      </section>
    );
}

export {AllJobsPosted};