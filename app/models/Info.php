<?php



class Info extends Eloquent {

	protected $table = 'infos';

	protected $fillable = ['month', 'budget', 'balance', 'expenses', 'amount'];

	public function expenses() {
		return $this->hasMany('Expense');
	}


}
