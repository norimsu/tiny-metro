
const webpack = require('webpack');
const webpackMerge = require('webpack-merge');
const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

const commonConfig = require('./webpack.common.js');


const ENV = process.env.NODE_ENV = process.env.ENV = 'production';

module.exports = webpackMerge(commonConfig, {

  output: {
    path: path.join(process.cwd(), '..', 'dist'),
    publicPath: 'res/',
    filename: '[name].[hash].js',
  },

  plugins: [
    new ExtractTextPlugin('[name].[hash].css'),
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify('production'),
      }
    }),
    new CopyWebpackPlugin([{
        from: 'resources/img',
        to: 'img',
        context: path.join(__dirname, 'app'),
      }, {
        from: 'resources/server',
        to: 'server',
        context: path.join(__dirname, 'app'),
      }, {
        from: 'resources/fonts',
        to: 'fonts',
        context: path.join(__dirname, 'app'),
    }]),
    new webpack.NoErrorsPlugin(),
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
