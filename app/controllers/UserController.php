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


			$input = Input::all();

            $user = new User;
            $user->username   = $input['username'];
            $user->password   = $input['password'];
            $user->email      = $input['email'];
            $user->municipal_name = $input['municipal_name'];
            $user->save();


            // redirect
           return Response::json(['Response' => 'OK']);
  //       }

       // return Response::json(['Sucess'=>'Registered!']);

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
