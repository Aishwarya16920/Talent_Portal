import { createAsyncThunk, createSlice, configureStore, applyMiddleware } from '@reduxjs/toolkit'
import talentPortal from '../reducers/talentportal';

const talentPortalStore = configureStore({
  reducer: talentPortal.reducer
});

export default talentPortalStore;