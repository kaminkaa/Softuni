import { AJAX_BEGIN, AJAX_ERROR, FETCH_USERUSERNAMES_SUCCESS, FETCH_USERINFO_SUCCESS, FETCH_USERSPERPAGE_SUCCESS, FETCH_USERSCOUNT_SUCCESS } from "./actionTypes";
import { getUsersUsernames, getUserInfo, getUsersPerPage, getUsersCount } from '../services/userRemote';

function fetchUsersUsernamesSuccess(data) {
    return {
        type: FETCH_USERUSERNAMES_SUCCESS,
        data
    };
}

function fetchUserInfoSuccess(data) {
    return {
        type: FETCH_USERINFO_SUCCESS,
        data
    };
}

function fetchUsersPerPageSuccess(data) {
    return {
        type: FETCH_USERSPERPAGE_SUCCESS,
        data
    };
}

function fetchUsersCountSuccess(data) {
    return {
        type: FETCH_USERSCOUNT_SUCCESS,
        data
    };
}

export function fetchUsersUsernamesAction() {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getUsersUsernames();
            dispatch(fetchUsersUsernamesSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchUserInfoAction(username) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getUserInfo(username);
            dispatch(fetchUserInfoSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchUsersPerPageAction(page, count) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getUsersPerPage(page, count);
            dispatch(fetchUsersPerPageSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchUsersCountAction() {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getUsersCount();
            dispatch(fetchUsersCountSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}
