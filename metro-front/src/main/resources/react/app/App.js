
import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRedirect, browserHistory } from 'react-router';

import Metro from './metro/component/MetroView';
import MetroRegistration from './metro/component/MetroRegistrationView';


ReactDOM.render(
  <Router history={browserHistory}>
    <Route path='/' >

      <IndexRedirect to="/app/metro" />

      <Route path="app/metro" component={Metro} />
      <Route path="app/metros/new" component={MetroRegistration} />

    </Route>
  </Router>,
  document.getElementById('app'),
);
