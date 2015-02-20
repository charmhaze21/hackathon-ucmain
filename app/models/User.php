<?php



class User extends Eloquent {

	protected $table = 'users';

	protected $fillable = ['username', 'password', 'email', 'municipal_name', 'user_id'];

	public function infos() {
		return $this->hasMany('Info');
	}


}
