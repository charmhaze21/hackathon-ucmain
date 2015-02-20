<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateInfosTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('infos', function(Blueprint $table)
		{
			$table->increments('id');
			$table->string('month', 50);
			$table->decimal('budget', 10, 2);
			$table->decimal('balance', 10, 2);
			$table->string('expenses', 100);
			$table->decimal('amount', 10,2);
			$table->integer('user_id')->unsigned();

			$table->foreign('user_id')->references('id')->on('users');
		});
	}

	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::dropIfExists('infos');	}

}
