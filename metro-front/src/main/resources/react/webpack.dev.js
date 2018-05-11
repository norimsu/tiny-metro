
const webpack = require('webpack');
const webpackMerge = require('webpack-merge');
const path = require('path');

const commonConfig = require('./webpack.common.js');


module.exports = webpackMerge(commonConfig, {

  devtool: '#cheap-module-eval-source-map',

  module: {
    loaders: [
      {
        test: /\.js?$/,
        exclude: /(node_modules|bower_components)/,
        loaders: ['react-hot-loader']
      },
      {
        test: /\.js?$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015', 'stage-2', 'react'],
          compact: false
        }
      },
    ],
  },

  plugins: [
    new webpack.HotModuleReplacementPlugin(),
  ],

  devServer: {
    historyApiFallback: true,   // 비정상 URL 루트로 리다이렉트 추정
    stats: 'minimal',
    inline: true,
    hot: true,
    headers: { 'Access-Control-Allow-Origin': '*' },
    proxy: {
      '/metro': {
        target: 'http://localhost:8080',
        secure: false,
      },
    },
  },
});
