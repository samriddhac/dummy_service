import { combineReducers } from 'redux';
import UserVideoReducer from './user-video-reducer';

const rootReducer = combineReducers({
	userVideo:UserVideoReducer
});
export default rootReducer;