<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/
Route::get('/', function()
{
	return View::make('home');
});

Route::get('/home', function()
{
	$users = Route::resource('users', 'UserController');
	return View::make('home')->with(array('users', $users));
});

Route::get('/index', function()
{
	return View::make('home');
});

Route::get('/login', function()
{
	return View::make('login');
});

Route::get('/main', function()
{
	return View::make('main');
});
//Route::get('/users','UserController@store');
//Route::get('/users2', 'UserController@userslist2');

Route::resource('users', 'UserController');
Route::resource('infos', 'InfoController');
