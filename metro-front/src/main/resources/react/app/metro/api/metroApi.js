
import axios from 'axios';


const metroBaseUrl = '/metro';

const mockMetros = [
  { name: 'Test Metro 1', time: 1525965252959, admins: {
    admins: [{
      tier: 'Primary',
      id: 'tester2',
      name: 'tester2',
      email: 'tester1@test.com',
      time: 1525965252959,
    }]
  }},
  { name: 'Test Metro 2', time: 1525965252959, admins: {
    admins: [{
      tier: 'Primary',
      id: 'tester2',
      name: 'tester2',
      email: 'tester1@test.com',
      time: 1525965252959,
    }]
  }},
  { name: 'Test Metro 3', time: 1525965252959, admins: {
    admins: [{
      tier: 'Primary',
      id: 'tester2',
      name: 'tester2',
      email: 'tester1@test.com',
      time: 1525965252959,
    }]
  }},
];


function registerMetro(metroCdo) {
  //
  return axios.post(`${metroBaseUrl}/`, metroCdo);
  /*
  const metro = {
    name: metroCdo.name,
    time: new Date().getTime(),
    admins: {
      admins: [ metroCdo.admin ],
    },
  };

  mockMetros.push(metro);
  return Promise.resolve();
  */
}

function findMetro(metroId) {
  return axios.get(`${metroBaseUrl}/${metroId}`)
  // return Promise.resolve(mockMetros);
}


export default {
  registerMetro,
  findMetro,
};
