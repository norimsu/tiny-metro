
import React, { Component } from 'react';
import { Link } from 'react-router';

import metroApi from '../api/metroApi';


class MetroListView extends Component {
  //
  state = {
    metros: [],
  };


  // @Override
  componentDidMount() {
    //
    metroApi.findMetros()
      .then((metros) => this.setState({ metros }));
  }


  render() {
    //
    const { metros } = this.state;

    return (
      <div>
        <h2>Metro List</h2>

        <Link to="/metros/new"><button>Metro 등록</button></Link>

        <hr/>

        <ul>
          { metros.map((metro, index) =>
            <li key={`metro_${index}`}>
              Name: {metro.name}  |  Time: {metro.time}  |  Admins: {JSON.stringify(metro.admins.admins)}
            </li>
          )}
        </ul>
      </div>
    );
  }
}

export default MetroListView;
