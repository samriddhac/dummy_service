import React, { Component } from 'react';
import { connect } from 'react-redux';
import {fetchNavData, saveMapping, USERS, VIDEOS, GROUPS} from '../actions/index';

class UserVideo extends Component {

	constructor(props) {
		super(props);
		this.state = {
			activeLeft:1,
			activeRight:1
		};

		this.leftSelection = [];
		this.rightSelection = [];

		this.handleChange = this.handleChange.bind(this);
	}

	_assign() {
		let req = {};
		if(this.state.activeLeft === 1) {
			req.userIds = this.leftSelection;
		}
		else {
			req.userGroupIds = this.leftSelection;
		}
		if(this.state.activeRight === 1) {
			req.videoIds = this.rightSelection;
		}
		else {
			req.videoGroupIds = this.rightSelection;
		}
		console.log(req);
		this.props.saveMapping(req);
	}

	componentWillMount() {
		this.props.fetchNavData(USERS);
		this.props.fetchNavData(VIDEOS);
	}

	handleChange(e,type) {
		var options = e.target.options;
		var value = [];
		for (var i = 0, l = options.length; i < l; i++) {
			if (options[i].selected) {
		    	value.push(options[i].value);
		    }
		}
		if(type==='left') {
			this.leftSelection = value;
		}
		else if(type==='right') {
			this.rightSelection = value;
		}
	}

	_getToggleCss(id,type) {
		let val = this.state.activeLeft;
		let cornerCss = "toggle-btn-round-left";
		if(type==='right') {
			val = this.state.activeRight;
		}
		if (id ===2) {
			cornerCss = "toggle-btn-round-right";
		}
		if(val === id) {
			return "btn-xs btn-primary "+cornerCss;
		}
		else {
			return "btn-xs btn-link "+cornerCss;
		}
		
	}

	_renderToggleBar(type) {
		let firstText = 'User';
		let secondText = 'Group';

		if (type==='right') {
			firstText = 'Video';
		}
		return (
			<div>
				<button className={this._getToggleCss(1,type)} 
					onClick={()=>{this._toggleClick(1,type)}}>{firstText}</button>
				<button className={this._getToggleCss(2,type)} 
					onClick={()=>{this._toggleClick(2, type)}}>{secondText}</button>
			</div>
		);
	}

	_toggleClick(id,type) {
		let context = undefined;
		let subtype = undefined;
		if (type==='right' && id!==this.state.activeRight) {
			this.setState({activeRight:id});
			context = VIDEOS;
		}
		else if(type==='left' && id!==this.state.activeLeft){
			this.setState({activeLeft:id});
			context = USERS;
		}
		if(id === 2) {
			subtype = GROUPS;
		}
		if(context!==undefined) {
			this.props.fetchNavData(context, subtype);
		}
	}

	_renderList(type) {
		let options = [];
		if(type==='left') {
			options = this.props.userVideo.leftNav;
		}
		else {
			options = this.props.userVideo.rightNav;
		}
		return (
			<select multiple className="form-control select-box" onChange={(e)=>{
				this.handleChange(e,type);	
			}}>
			{options.map((item)=>{
				return (
					<option value={item.id}>{item.name}</option>
				);
			})}
			</select>
		);
	}

	_renderBlock(type) {
		let headerText = 'User';
		if(type ==='right') {
			headerText = 'Video';
		}
		return (
			<div className='section-item'>
				<div className='header-text'>{headerText}</div>
				{this._renderToggleBar(type)}
				{this._renderList(type)}
			</div>
		);
	}

	render() {

		return(
			<div className='main-container'>
				<div className='section-container'>
					{this._renderBlock('left')}
					{this._renderBlock('right')}
				</div>
				<div className='assign-btn-container'>
					<button className="btn-xs btn-success" onClick={()=>{
						this._assign();
					}}>Assign</button>
				</div>
			</div>	
		);
	}
}
function mapStateToProps({userVideo}) {
	return { userVideo };
}

export default connect(mapStateToProps,{fetchNavData, saveMapping})(UserVideo);