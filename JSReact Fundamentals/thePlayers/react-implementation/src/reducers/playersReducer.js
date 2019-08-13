import { FETCH_PLAYERSFORSALECOUNT_SUCCESS, FETCH_PLAYERSFORSALEPERPAGE_SUCCESS, FETCH_PLAYERSCOUNT_SUCCESS, FETCH_PLAYERSPERPAGE_SUCCESS, FETCH_PLAYERINFO_SUCCESS, FETCH_PLAYERSPERUSER_SUCCESS, FETCH_LOGGEDINUSERPLAYERS_SUCCESS } from "../actions/actionTypes";

export default function playersReducer (state = { playersForSaleCount: 0, playersForSale: [], playersCount: 0, players: [], playerInfo: {}, userPlayers: [] }, action) {
    switch (action.type) {
        case FETCH_PLAYERSFORSALECOUNT_SUCCESS:
            return {
                ...state,
                playersForSaleCount: action.data
            };
        case FETCH_PLAYERSFORSALEPERPAGE_SUCCESS:
            return {
                ...state,
                playersForSale: action.data
            };
        case FETCH_PLAYERSCOUNT_SUCCESS:
            return {
                ...state,
                playersCount: action.data.count
            };
        case FETCH_PLAYERSPERPAGE_SUCCESS:
            return {
                ...state,
                players: action.data
            };
        case FETCH_PLAYERINFO_SUCCESS:
            return {
                ...state,
                playerInfo: action.data
            };
        case FETCH_PLAYERSPERUSER_SUCCESS:
            return {
                ...state,
                userPlayers: action.data
            };
        case FETCH_LOGGEDINUSERPLAYERS_SUCCESS:
            return {
                ...state,
                loggedInUserPlayers: action.data
            };
        default:
            return state;
    }
}

/*function reconcile(oldData, newData) {
    const newDataById = {};

    for (let entry of arguments) {
        newDataById[entry.id] = entry;
    }

    const result = [];

    for (let entry of oldData) {
        if (newDataById[entry.id]) {
            result.push(newDataById[entry.id]);
            delete newDataById[entry.id];
        } else {
            result.push(entry);
        }
    }

    for (let id in newDataById) {
        result.push(newDataById[id]);
    }

    return result;
}*/