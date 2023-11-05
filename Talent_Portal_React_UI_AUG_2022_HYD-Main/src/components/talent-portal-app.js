import React from "react";
import { Header } from "./header";
import UserInfo from './jobseeker/userprofile';
import {BrowserRouter,Route,Routes} from 'react-router-dom';
import {Registration} from "./registration";
import {Login} from "./login";
import { useNavigate } from "react-router-dom";
import { FindJob } from "./jobseeker/homepage";
import { PostNewJob } from "./admin/postnewjob";
import { EditPostedJob } from "./admin/editpostedjobs";
import {AdminHomePage} from "./admin/adminhomepage";
import UserAppliedJobs from './jobseeker/findjob';
import { AllJobsPosted } from "./admin/all_jobs_posted";
import ApplnStatus from "./admin/applicationstatus";



const TalentPortalApp=()=>{
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<FindJob></FindJob>}/>
                <Route path="/header" element={<Header></Header>}/>
                <Route path="/login" element={<Login></Login>}/>
                <Route path="/registration" element={<Registration></Registration>}/>
                <Route path="/findjob" element={<FindJob></FindJob>}/>
                <Route path="/admin/postnewjob" element={<PostNewJob></PostNewJob>}/>
                <Route path="/admin/editpostedjob" element={<EditPostedJob></EditPostedJob>}/>
                <Route path='/myprofile' element = {<UserInfo></UserInfo>}></Route>
                <Route path="/admin" element={<AdminHomePage></AdminHomePage>}/>
                <Route path="/findjob/user" element={<UserAppliedJobs></UserAppliedJobs>}/>
                <Route path="/admin/alljobsposted" element={<AllJobsPosted></AllJobsPosted>}/>
                <Route path="/admin/applicationstatus" element={<ApplnStatus></ApplnStatus>}/>
                
            </Routes> 
        </BrowserRouter>


    )
    
}




export {TalentPortalApp};
