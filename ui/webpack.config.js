var webpack = require('webpack'),
path = require('path'),
HtmlWebpackPlugin = require('html-webpack-plugin'),
CopyWebpackPlugin = require('copy-webpack-plugin');

var config = {
	entry: [
		'./src/index'
	],

	output: {
		path: path.join(__dirname, 'dist'),
		filename: 'app.bundle.js',
		publicPath: '/'
	}, 

	resolve: {
		extensions: ['.js', '.jsx']
	},

	plugins: [
		new HtmlWebpackPlugin({
			template: './src/index.html'
		}),
		new CopyWebpackPlugin([
			{ from: './css', to: './style'}
		])
	],

	module: {
		loaders: [
			{
				test: /\.js$/,
				loader: 'babel-loader',
				exclude: /node_modules/
			}
		]
	},

	devServer: {
		port: 7070,
		contentBase: './dist',
		historyApiFallback: true
	}
};
module.exports = config;