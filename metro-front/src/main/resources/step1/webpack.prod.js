
const webpack = require('webpack');
const webpackMerge = require('webpack-merge');
const path = require('path');

const commonConfig = require('./webpack.common.js');


module.exports = webpackMerge(commonConfig, {

  module: {
    loaders: [
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
    new webpack.optimize.UglifyJsPlugin({
      comments: false,
      compress: {
        warnings: false,
      },
      drop_console: false,
      mangle: {
        keep_fnames: true,
        except: ['$super'],
      },
    }),
  ]
});
