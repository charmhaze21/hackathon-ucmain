<?php



class User extends Eloquent {

	protected $table = 'users';

	protected $fillable = ['username', 'password', 'municipal_name' ];

	public function infos() {
		return $this->hasMany('Info');
	}


}
