import React from 'react';
import { Route, IndexRoute } from 'react-router';

import App from './components/app';
import UserVideo from './components/user-video';

export default (
	<Route path="/" component={App}>
		<IndexRoute component={UserVideo}/>
	</Route>
);