import { AJAX_BEGIN, AJAX_ERROR, FETCH_PLAYERSFORSALECOUNT_SUCCESS, FETCH_PLAYERSFORSALEPERPAGE_SUCCESS, FETCH_PLAYERSCOUNT_SUCCESS, FETCH_PLAYERSPERPAGE_SUCCESS, FETCH_PLAYERINFO_SUCCESS, FETCH_PLAYERSPERUSER_SUCCESS, FETCH_LOGGEDINUSERPLAYERS_SUCCESS } from "./actionTypes";
import { getPlayersForSaleCount, getPlayersForSalePerPage, getPlayersCount, getPlayersPerPage, getPlayerInfo, getPlayersPerUser } from '../services/playersRemote';

function fetchPlayersForSaleCountSuccess(data) {
    return {
        type: FETCH_PLAYERSFORSALECOUNT_SUCCESS,
        data: data.length
    };
}

function fetchPlayersForSalePerPageSuccess(data) {
    return {
        type: FETCH_PLAYERSFORSALEPERPAGE_SUCCESS,
        data
    };
}

function fetchPlayersCountSuccess(data) {
    return {
        type: FETCH_PLAYERSCOUNT_SUCCESS,
        data
    };
}

function fetchPlayersPerPageSuccess(data) {
    return {
        type: FETCH_PLAYERSPERPAGE_SUCCESS,
        data
    };
}

function fetchPlayerInfoSuccess(data) {
    return {
        type: FETCH_PLAYERINFO_SUCCESS,
        data
    };
}

function fetchPlayersPerUserSuccess(data) {
    return {
        type: FETCH_PLAYERSPERUSER_SUCCESS,
        data
    };
}

function fetchLoggedInPlayersSuccess(data) {
    return {
        type: FETCH_LOGGEDINUSERPLAYERS_SUCCESS,
        data
    };
}

export function fetchPlayersForSaleCountAction() {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        const data = await getPlayersForSaleCount();
        dispatch(fetchPlayersForSaleCountSuccess(data));
    };
}

export function fetchPlayersForSalePerPageAction(page) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getPlayersForSalePerPage(page);
            dispatch(fetchPlayersForSalePerPageSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchPlayersCountAction() {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        const data = await getPlayersCount();
        dispatch(fetchPlayersCountSuccess(data));
    };
}

export function fetchPlayersPerPageAction(page, count) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});
        try {
            const data = await getPlayersPerPage(page, count);
            dispatch(fetchPlayersPerPageSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchPlayerInfoAction(id) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});

        try {
            const data = await getPlayerInfo(id);
            dispatch(fetchPlayerInfoSuccess (data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchPlayersPerUserAction(username) {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});

        try {
            const data = await getPlayersPerUser(username);
            dispatch(fetchPlayersPerUserSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}

export function fetchLoggedInPlayersAction() {
    return async (dispatch) => {
        dispatch({ type: AJAX_BEGIN});

        try {
            const data = await getPlayersPerUser(localStorage.getItem('username'));
            dispatch(fetchLoggedInPlayersSuccess(data));
        } catch (error) {
            dispatch({
                type: AJAX_ERROR,
                error
            });
        }
    };
}