
import axios from 'axios';


const metroBaseUrl = '/api/s/metros';

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
  // axios.post(`${metroBaseUrl}/metros`);
  const metro = {
    name: metroCdo.name,
    time: new Date().getTime(),
    admins: {
      admins: [ metroCdo.admin ],
    },
  };

  mockMetros.push(metro);
  return Promise.resolve();
}

function findMetros() {
  return Promise.resolve(mockMetros);
}


export default {
  registerMetro,
  findMetros,
};
