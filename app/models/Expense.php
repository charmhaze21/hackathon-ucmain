<?php

class Expense extends Eloquent {

	protected $table = 'expenses';

	protected $fillable = ['title', 'description', 'amount' ];

}
