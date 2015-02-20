<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Anti-Napoles</title>

        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/styles.css"> <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <i class="fa fa-bars" style="color:white;"></i>
                    </button>
                    <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i>  <span class="light"></span>BMS
                </a>
                </div>

                <div class="collapse navbar-collapse navbar-main-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li>
                            <a href="">Administrator</a>
                        </li>
                        <li>
                            <a href="">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container">
        	<form class="container-main" role="form" method="post">
                <div class="col-lg-6 col-lg-offset-3">
                    <h2>Municipal Expenses</h2>
                    <div class="form-group">
                        <input class="form-control" type="text" name="municipal_name" placeholder="Municipal Name" autofocus required>
                        <select class="form-control" name="month">
                          <option>Choose Month</option>
                          <option value="January">January</option>
                          <option value="February">February</option>
                          <option value="March">March</option>
                          <option value="April">April</option>
                          <option value="May">May</option>
                          <option value="June">June</option>
                          <option value="July">July</option>
                          <option value="August">August</option>
                          <option value="September">September</option>
                          <option value="October">October</option>
                          <option value="November">November</option>
                          <option value="December">December</option>
                        </select>
                        <input class="form-control" type="text" name="Description" placeholder="Description" autofocus required>
                        <input class="form-control" type="text" name="budget" placeholder="Budget" autofocus required>
                        <input class="form-control" type="text" name="total_expenses" placeholder="Total Expenses" autofocus required>

                        <button class="btn btn-primary btn-sm">Submit</button>
                    </div>
                </div>
            </form>
        </div>
	</body>
</hmtl>