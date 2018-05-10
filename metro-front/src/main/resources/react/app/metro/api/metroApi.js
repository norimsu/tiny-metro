
import axios from 'axios';


const metroBaseUrl = '/metro';


function registerMetro(metroCdo) {
  //
  return axios.post(`${metroBaseUrl}/`, metroCdo);
}

function findMetro(metroId) {
  return axios.get(`${metroBaseUrl}/${metroId}`)
  // return Promise.resolve(mockMetros);
}


export default {
  registerMetro,
  findMetro,
};
