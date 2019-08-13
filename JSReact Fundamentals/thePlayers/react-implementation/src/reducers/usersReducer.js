import { FETCH_USERUSERNAMES_SUCCESS, FETCH_USERINFO_SUCCESS, FETCH_USERSPERPAGE_SUCCESS, FETCH_USERSCOUNT_SUCCESS } from "../actions/actionTypes";

export default function usersReducer (state = { usersUsernames: [], userInfo: {}, usersPerPage: [], usersCount: 0 }, action) {
    switch (action.type) {
        case FETCH_USERUSERNAMES_SUCCESS:
            return {
                ...state,
                usersUsernames: action.data
            };
        case FETCH_USERINFO_SUCCESS:
            return {
                ...state,
                userInfo: (action.data)[0]
            };
        case FETCH_USERSPERPAGE_SUCCESS:
            return {
                ...state,
                usersPerPage: action.data
            };
        case FETCH_USERSCOUNT_SUCCESS:
            return {
                ...state,
                usersCount: action.data.count
            };
        default:
            return state;
    }
}
