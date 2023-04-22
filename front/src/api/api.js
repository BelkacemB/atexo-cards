import axios from 'axios';

const API_URL = 'http://localhost:8080';

export const getAllCards = async () => {
    return axios.get(`${API_URL}/cards`);
}

export const shuffleCards = async () => {
    return axios.get(`${API_URL}/cards/hand/new`);
}

export const getHand = () => {
    return axios.get(`${API_URL}/cards/hand`);
}

export const getSuitOrder = () => {
    return axios.get(`${API_URL}/cards/suit-order`);
}

export const getValuesOrder = () => {
    return axios.get(`${API_URL}/cards/value-order`);
}

export const getSortedHand = () => {
    return axios.get(`${API_URL}/cards/hand/sorted`);
}
