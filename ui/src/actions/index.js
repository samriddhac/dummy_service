import axios from 'axios';
 
export const FETCH_LEFT_NAV = 'FETCH_LEFT_NAV';
export const FETCH_RIGHT_NAV = 'FETCH_RIGHT_NAV';
export const SAVE_MAPPING = 'SAVE_MAPPING';

export const USERS = 'users';
export const VIDEOS = 'videos';
export const GROUPS = 'groups';

const ROOT_URL = 'http://localhost:8080';

export function fetchNavData(context,type) {
	let url = `${ROOT_URL}/${context}/`;
	if(type) {
		url = `${url}${type}`;
	}
	let context_type = FETCH_LEFT_NAV;
	if(context===VIDEOS) {
		context_type = FETCH_RIGHT_NAV;
	}
	let request = axios.get(url);
	return {
		type:context_type,
		payload: request
	};
}

export function saveMapping(requestObj) {
	let url = `${ROOT_URL}/${VIDEOS}/${USERS}`;
	axios.put(url, requestObj);
    return {
		type:SAVE_MAPPING
	};
}