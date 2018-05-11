
import React, { Component } from 'react';
import autoBind from 'react-autobind';
import { Link } from 'react-router';

import metroApi from '../api/metroApi';


class MetroView extends Component {
  //
  state = {
    metroId: '',
    metro: null,
  };

  constructor(props) {
    super(props);
    autoBind(this);
  }


  onClickFind() {
    //
    const { metroId } = this.state;

    metroApi.findMetro(metroId)
      .then((result) => this.setState({ metro: result.data }));
  }

  onChangeMetroId(e) {
    this.setState({ metroId: e.target.value });
  }



  render() {
    //
    const { metroId, metro } = this.state;

    console.log(metro);

    return (
      <div>
        <h2>Metro List</h2>

        <label>MetroId</label>
        <input type="text" value={metroId} onChange={this.onChangeMetroId}/>
        <button onClick={this.onClickFind}>조회</button>
        <Link to="/app/metros/new"><button>Metro 등록</button></Link>

        <hr/>

        { metro &&
          <div>
            <p>
              <label>Name : </label>
              {metro.name}
            </p>
            <p>
              <label>Time : </label>
              {metro.time}
            </p>

            { metro.admins.admins.map((metroAdmin, index) =>
              <div key={`metro_admin_${index}`}>
                <p>
                  <label>Admin Id : </label>
                  {metroAdmin.id}
                </p>
                <p>
                  <label>Admin name : </label>
                  {metroAdmin.name}
                </p>
                <p>
                  <label>Admin name : </label>
                  {metroAdmin.email}
                </p>
              </div>
            )}
          </div>
        }

      </div>
    );
  }
}

export default MetroView;
