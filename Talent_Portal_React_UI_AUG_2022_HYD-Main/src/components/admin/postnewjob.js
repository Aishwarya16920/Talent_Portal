import {useRef, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import addNewJob from '../../actions/postnewjob';
import React, { Component }  from 'react';
import { current } from '@reduxjs/toolkit';
import { Link } from 'react-router-dom';
import logout from '../../actions/logoutaction';

const PostNewJob = () =>{
    let jobTitle_ref=useRef();
    let description_ref=useRef();
    let primarySkill_ref=useRef();
    let secondarySkill_ref=useRef();
    let minExp_ref=useRef();
    let maxExp_ref=useRef();
    let location_ref=useRef();

    const[jobTitleError,setJobTitleError]=useState("");
    const[descriptionError,setDescriptionError]=useState("");
    const[primarySkillError,setPrimarySkillError]=useState("");
    const[secondarySkillError,setSecondarySkillError]=useState("");
    const[minExpError,setMinExpError]=useState("");
    const[maxExpError,setMaxExpError]=useState("");
    const[temp, settemp] = useState(true);

    let dispatcher=useDispatch();
    let navigate = useNavigate();
    let authToken = localStorage.getItem("authToken");

    const logoutFunc = async()=>{ 

        let logoutResponse = dispatcher(logout(authToken));
  
  
        if(logoutResponse.payload){
  
         navigate('/login')
  
        } else {  
            navigate('/')
        }
  
    }

    const postJob=()=>{
                let title = jobTitle_ref.current.value;
                let description = description_ref.current.value;
                let minExp = minExp_ref.current.value;
                let maxExp = maxExp_ref.current.value;
                let primarySkill = primarySkill_ref.current.value;
                let secSkills = secondarySkill_ref.current.value;
                let location = location_ref.current.value;
                if(title!=="" && description!=="" && minExp!=="" && maxExp!=="" && primarySkill!=="" && secSkills!==""){
               
                    let newJob = { title, description, minExp, maxExp, primarySkill, secSkills,location, authToken}
	                dispatcher(addNewJob(newJob));
                }
    }
    
    const jobTitle_Error=()=>{
        if(jobTitle_ref.current.value == "") {
            setJobTitleError(jobTitle_ref.current.value?"": "Please enter job title");
        }
        else{
            if(jobTitle_ref.current.value.trim() == ""){
                setJobTitleError("Job title cannot be empty")
            }

            else if(!jobTitle_ref.current.value.match(/[A-Z]/i)){
                setJobTitleError("Job title should start with alphabet")
            }

            else{
                setJobTitleError("");
            }
        }
    }
    const description_Error=()=>{
        if(description_ref.current.value == ""){
            setDescriptionError(description_ref.current.value?"":"Please enter description");
        }

        else{
            if(description_ref.current.value.trim() == ""){
                setDescriptionError("Description cannot be empty")
            }

            else if(!description_ref.current.value.match(/[A-Z0-9]/i)){
                setDescriptionError("Description should start with alphabet or number")
            }

            else{
                setDescriptionError("");
            }
        }
    }
    const primarySkill_Error=()=>{
        if(primarySkill_ref.current.value == ""){
            setPrimarySkillError(primarySkill_ref.current.value?"":"Please enter primary skill");
        }

        else{
            if(primarySkill_ref.current.value.trim() == ""){
                setPrimarySkillError("Primary skill cannot be empty")
            }

            else if(!primarySkill_ref.current.value.match(/[A-Z]/i)){
                setPrimarySkillError("Primary skill should start with alphabet")
            }

            else{
                setPrimarySkillError("");
            }
        }
    }
    const secondarySkill_Error=()=>{
        if(secondarySkill_ref.current.value == ""){
            setSecondarySkillError(secondarySkill_ref.current.value?"":"Please Enter secondarySkill");
        }

        else{
            if(secondarySkill_ref.current.value.trim() == ""){
                setSecondarySkillError("Secondary skill cannot be empty")
            }

            else if(!secondarySkill_ref.current.value.match(/[A-Z]/i)){
                settemp(true);
                setSecondarySkillError("Secondary skill should start with alphabet")
            }

            else{
                setSecondarySkillError("");
            }
        }
    }
    const minExp_Error=()=>{
        if(minExp_ref.current.value == ""){
            setMinExpError(minExp_ref.current.value?"":"Please enter min exp");
        }
        else{
            if(minExp_ref.current.value.trim() == ""){
                setMinExpError("Min exp cannot be empty");
            }
            else if(minExp_ref.current.value < 0  || minExp_ref.current.value > 50){
                setMinExpError("Min exp should be between the range 0-50");
            }

            else if(minExp_ref.current.value == maxExp_ref.current.value){
                setMinExpError("Invalid Input")
            }

            else if(!minExp_ref.current.value.match(/[0-9]/)){
                setMinExpError("Invalid Input")
            }

            else if(minExp_ref.current.value.match(/[0-9][0-9][0-9]/)){
                setMinExpError("Invalid Input")
            }

            else{
                setMinExpError("");
            }
        }
    }
    const maxExp_Error=()=>{
        if(maxExp_ref.current.value == ""){
            setMaxExpError(maxExp_ref.current.value?"":"Please enter max exp");
        }
        else{
            if(maxExp_ref.current.value.trim() == ""){
                setMaxExpError("Max exp cannot be empty");
            }

            else if(maxExp_ref.current.value <= 0 || maxExp_ref.current.value > 50){
                setMaxExpError("Max exp should be between the range 1-50");
            } 

            else if((maxExp_ref.current.value - minExp_ref.current.value) < 0){
                settemp(true);
                setMaxExpError("Max exp should be greater than min exp");
            } 

            else if(minExp_ref.current.value == maxExp_ref.current.value){
                setMaxExpError("Invalid Input")
            }

            else if(!maxExp_ref.current.value.match(/[0-9]/)){
                setMaxExpError("Invalid Input")
            }

            else if(maxExp_ref.current.value.match(/[0-9][0-9][0-9]/)){
                setMaxExpError("Invalid Input")
            }

            else{
                setMaxExpError("");
            }
        }
    }

    const test=()=>{
        let title = jobTitle_ref.current.value;
                let description = description_ref.current.value;
                let minExp = minExp_ref.current.value;
                let maxExp = maxExp_ref.current.value;
                let primarySkill = primarySkill_ref.current.value;
                let secSkills = secondarySkill_ref.current.value;

                if(title!=="" && description!=="" && minExp!=="" && maxExp!=="" && primarySkill!=="" && secSkills!=="" && title.trim()!=="" && description.trim()!=="" && primarySkill.trim()!=="" &&  secSkills.trim()!=="" && minExp >= 0 && minExp <= 50 && maxExp > 0 && maxExp <= 50  && minExp < maxExp && maxExp > minExp && (maxExp-minExp) >= 0 && jobTitle_ref.current.value.match(/[A-Z]/i) && description_ref.current.value.match(/[A-Z0-9]/i) && primarySkill_ref.current.value.match(/[A-Z]/i) && secondarySkill_ref.current.value.match(/[A-Z]/i) && !maxExp_ref.current.value.match(/[^0-9]/) && !minExp_ref.current.value.match(/[^0-9]/) && !maxExp_ref.current.value.match(/[0-9][0-9][0-9]/) && !minExp_ref.current.value.match(/[0-9][0-9][0-9]/)){
                    settemp(false);  
                }
                else{
                    settemp(true);
                }
        }

    return (

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

                <div class="col-md-3 text-end">

                    <button type="button" class="btn btn-primary btn-sm" onClick={logoutFunc}>LOGOUT</button>

                  </div>

            </div>

          </nav>

    }

</header>
        <br></br>
        <div class="container h-100">
        <div class="row justify-content-sm-center h-100">
          <div class="col-md-4 mb-3">
            <br></br>
              <h1 class="fs-4 card-title mb-5" >Posting a new job</h1>
              <form method="POST" class="needs-validation" novalidate="" autocomplete="off">
                  <div class="mb-3">
                      <input id="Job_Title" type="text" placeholder='Job Title' class="form-control" name="Job_Title" required="" ref={jobTitle_ref} onInput={jobTitle_Error} onChange={test}/>
                  </div>
                  {jobTitleError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{jobTitleError}</div>}
                  
                          <div class="mb-3">
                              <select class="form-select" aria-label="Location" ref={location_ref}>
                                  <option selected>Bangalore</option>
                                  <option value="Bangalore">Bangalore</option>
                                  <option value="Delhi">Delhi</option>
                                  <option value="Pune">Pune</option>
                                  <option value="Chennai">Chennai</option>
                                  <option value="Hyderabad">Hyderabad</option>
                                </select>
                          </div>
                  
                  <div class="row">
                      <div class="col-md-6">
                          <div class="mb-3">
                              <input  type="number" placeholder='Min Experience' class="form-control" name="min" min = "0" max = "50" required="" ref={minExp_ref} onInput= {minExp_Error} onChange={test}/>
                          </div>
                          {minExpError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{minExpError}</div>}
                      </div>
                      
                      
                      <div class="col-md-6">
                          <div class="mb-3">
                              <input  type="number"  placeholder='Max Experience' class="form-control" name="Max" min= "1" max= "50" required="" ref={maxExp_ref} onInput= {maxExp_Error} onChange={test}/>
                          </div>
                          {maxExpError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{maxExpError}</div>}
                      </div>
                  </div>
                  
                  
                  <div class="row">
                      <div class="col-md-6">
                          <div class="mb-3">
                              <input id="Primary_Skill" type="text" placeholder='Primary Skill'  class="form-control" name="Primary_Skill" required="" ref={primarySkill_ref} onInput= {primarySkill_Error} onChange={test}/>
                          </div>
                          {primarySkillError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{primarySkillError}</div>}
                      </div>
                      
                      
                      <div class="col-md-6">
                          <div class="mb-3">
                              <input id="Secondary_Skill" type="text"  placeholder='Secondary Skill' class="form-control" name="Secondary_Skill" required="" ref={secondarySkill_ref} onInput= {secondarySkill_Error} onChange={test}/>
                          </div>
                          {secondarySkillError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{secondarySkillError}</div>}
                      </div>

                      <div class="mb-3">
                      <div class="form-floating">
                          <textarea class="form-control" placeholder='Description' id="floatingTextarea2" style={{height:"50px"}} required="" ref={description_ref} onInput={description_Error} onChange={test}></textarea>
                        </div>         
                        {descriptionError && <div class="alert alert-danger" role="alert" style={{padding: "5p 15px"}}>{descriptionError}</div>}
                    </div>
                  </div>
                  <div class="align-items-center d-flex" >
                      <Link to = '/admin'><button type="button" onClick = {postJob} class="btn btn-primary ms-auto" disabled={temp} >
                          Post	
                      </button></Link>
                  </div>
              </form>
          </div>
          </div>
        </div>
        
    </section>
    )
}


export {PostNewJob};