<?php
	
class UserController extends BaseController{

	function userslist() {
		
		//return View::make('userslist'); //return view
		return View::make('userslist', array('mystring' => 'hellllo string'));
	}

	function userslist2(){
		return View::make('userslist2', array('mystring2' => 'hellllo string2'));
	}

}