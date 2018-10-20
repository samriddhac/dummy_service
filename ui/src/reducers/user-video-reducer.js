import { FETCH_LEFT_NAV, FETCH_RIGHT_NAV } from '../actions/index';

const INITIAL_SATE ={ leftNav: [], rightNav: [] };

export default function(state= INITIAL_SATE, action ) {
	switch(action.type) {
		case FETCH_LEFT_NAV:
			return { ...state, leftNav: action.payload.data };
		case FETCH_RIGHT_NAV:
			return { ...state, rightNav: action.payload.data };
		default :
			return state;
	}
}