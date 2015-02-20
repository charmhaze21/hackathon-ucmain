<?php

class UserController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$users = User::all();

   
        //return View::make('userslist')
            //->with('users', $users);
         return Response::json(['users', $users]);
	}


	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('create');	}


	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		// $rules = array(
  //           'username'       => 'required',
  //           'password' => 'required',
  //           'email'      => 'required|email',
  //           'municipal_name' =>  'required'
  //       );
  //       $validator = Validator::make(Input::all(), $rules);

  //       if ($validator->fails()) {
  //           return Respone::json(['error'=>'Incorrect Fields. Try again.']);
  //       }else{
  //           $user = new User;
  //           $user->username       = Input::get('name');
  //           $user->email      = Input::get('email');
  //           $user->nerd_level = Input::get('nerd_level');
  //           $user->save();

  //           // redirect
  //           Session::flash('message', 'Successfully created nerd!');
  //           return Redirect::to('nerds');
  //       }

        return Response::json(['hello'=>'hello']);

	}


	/**
	 * Display the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		$user = User::find($id);

		$infos = $user->infos()->get();

		return Response::json(['user'=>$user, 'infos'=>$infos]);
	}


	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		//
	}


	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		//
	}


	/**
	 * Remove the specified resource from storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		//
	}

	function user_infos(){
		
	}
}
