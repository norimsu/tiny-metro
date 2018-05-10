
import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRedirect, browserHistory } from 'react-router';

import MetroList from './metro/component/MetroListView';
import Metro from './metro/component/MetroView';


ReactDOM.render(
  <Router history={browserHistory}>
    <Route path='/' >

      <IndexRedirect to="metros" />

      <Route path="metros" component={MetroList} />
      <Route path="metros/new" component={Metro} />

    </Route>
  </Router>,
  document.getElementById('app'),
);
