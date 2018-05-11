
const webpack = require('webpack');
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');


module.exports = {
  //
  entry: {
    'app': './app/App.js',
  },

  output: {
    path: path.join(process.cwd(), '..', 'dist'),
    filename: '[name].[hash].js',
  },

  resolve: {
    modules: [path.resolve(__dirname, 'app'), 'node_modules'],
    descriptionFiles: ['package.json'],
    extensions: ['.js', '.jsx'],
  },

  plugins: [
    // dist index.html 만들어주는 놈
    new HtmlWebpackPlugin({
      template: 'app/index.html',
      baseUrl: '/',
      xhtml: true,    // 태그 정상 닫히도록
    }),
    new webpack.DefinePlugin({
      WP_BASE_HREF: '/'
    }),
  ],
};
