
import React, { Component } from 'react';
import autoBind from 'react-autobind';

import metroApi from '../api/metroApi';


class MetroView extends Component {
  //
  state = {
     metro: {
       name: '',
       admin: {
         id: '',
         name: '',
         email: '',
       },
     },
  };


  constructor(props) {
    super(props);
    autoBind(this);
  }


  onClickCancel() {
    this.props.router.push('/metros');
  }

  onClickSave() {
    //
    const { metro } = this.state;

    metroApi.registerMetro(metro)
      .then(() => window.alert('Metro가 등록 되었습니다'))
      .then(() => this.props.router.push('/metros'));
  }

  onChangeProp(propName, value) {
    //
    this.setState({
      metro: {
        ...this.state.metro,
        [propName]: value,
      },
    })
  }

  onChangeAdminProp(propName, value) {
    //
    this.setState({
      metro: {
        ...this.state.metro,
        admin: {
          ...this.state.metro.admin,
          [propName]: value,
        },
      },
    })
  }



  render() {
    //
    const { metro } = this.state;

    return (
      <div>
        <h2>Metro</h2>

        <p>
          <label>Name : </label>
          <input type="text" value={metro.name} onChange={(e) => this.onChangeProp('name', e.target.value)} />
        </p>
        <p>
          <label>Admin Id : </label>
          <input type="text" value={metro.admin.id} onChange={(e) => this.onChangeAdminProp('id', e.target.value)} />
        </p>
        <p>
          <label>Admin name : </label>
          <input type="text" value={metro.admin.name} onChange={(e) => this.onChangeAdminProp('name', e.target.value)} />
        </p>
        <p>
          <label>Admin email : </label>
          <input type="text" value={metro.admin.email} onChange={(e) => this.onChangeAdminProp('email', e.target.value)} />
        </p>

        <button onClick={this.onClickCancel}>취소</button>
        <button onClick={this.onClickSave}>등록</button>

      </div>
    );
  }
}

export default MetroView;
