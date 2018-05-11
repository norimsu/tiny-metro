
const webpack = require('webpack');
const webpackMerge = require('webpack-merge');
const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

const commonConfig = require('./webpack.common.js');


module.exports = webpackMerge(commonConfig, {
  devtool: '#cheap-module-eval-source-map',

  // prod webpack에 있는 publicPath 넣어주는것을 권장
  output: {
    path: path.join(process.cwd(), '/dist'),
    filename: '[name].[hash].js',
  },

  plugins: [
    new ExtractTextPlugin('[name].[hash].css'),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: JSON.stringify('development'),
      },
    }),
    new CopyWebpackPlugin([{
      from: 'resources/img',
      to: 'res/img',
      context: path.join(__dirname, 'app'),
    }, {
      from: 'resources/server',
      to: 'res/server',
      context: path.join(__dirname, 'app'),
    }, {
      from: 'resources/fonts',
      to: 'res/fonts',
      context: path.join(__dirname, 'app'),
    }]),
    new webpack.ProvidePlugin({
      $: 'jquery',
      jQuery: 'jquery',
      'window.jQuery': 'jquery',
    }),

    new StringReplacePlugin(),
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
