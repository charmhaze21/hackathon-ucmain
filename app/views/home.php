<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BMS</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/DT_bootstrap.css">
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>

    <script type="text/javascript" charset="utf-8" language="javascript" src="js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf-8" language="javascript" src="js/DT_bootstrap.js"></script>


    

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i>  <span class="light"></span>BMS
                </a>
            </div>

            <?php
               // echo print_r($_GET['users']);
            ?>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">Search</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="login">Login</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h1 class="brand-heading">BMS</h1>
                        <p class="intro-text">A site that shows the expenses of Municipalities.</p>
                        <a href="#about" class="btn btn-circle page-scroll">
                            <i class="fa fa-angle-double-down animated"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- About Section -->
    <section id="about" class="container content-section text-center">
        <div class="row">

            <?php 

                
            ?>

            <h2>Municipal Expenses</h2>
            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-condensed" id="example">
                <thead>
                    <tr>
                        <!-- <th>Action</th> -->
                        <th>Municipal Name</th>
                        <th>Month</th>
                        <th>Description</th>
                        <th>Budget</th>
                        <th>Total Expenses</th>
                        <th>Balance</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <!-- <td align="center">
                            <a data-toggle="tooltip" data-placement="top" title="Edit">
                                <i class="fa fa-edit fa-fw"></i> <span class="network-name"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Delete">
                                <i class="fa fa-trash fa-fw"></i> <span class="network-name"></span>
                            </a>
                       </td>  -->
                        <td>Tabunok</td> 
                        <td>December</td> 
                        <td>Educational System</td> 
                        <td>P 500,000</td> 
                        <td>P 400,000</td> 
                        <td>P 100,000</td> 
                    </tr>

                    
                    <tr>
                        <!-- <td align="center">
                            <a data-toggle="tooltip" data-placement="top" title="Edit">
                                <i class="fa fa-edit fa-fw"></i> <span class="network-name"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Delete">
                                <i class="fa fa-trash fa-fw"></i> <span class="network-name"></span>
                            </a>
                       </td>   -->
                        <td>MInglanilla</td> 
                        <td>November</td> 
                        <td>Calamity Fund</td> 
                        <td>P 600,000</td> 
                        <td>P 500,000</td> 
                        <td>P 100,000</td> 
                    </tr>

                    <tr>
                        <!-- <td align="center">
                            <a data-toggle="tooltip" data-placement="top" title="Edit">
                                <i class="fa fa-edit fa-fw"></i> <span class="network-name"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Delete">
                                <i class="fa fa-trash fa-fw"></i> <span class="network-name"></span>
                            </a>
                       </td>  -->
                        <td>Cebu City</td> 
                        <td>January</td> 
                        <td>Road Projects</td> 
                        <td>P 1,500,000</td> 
                        <td>P 1,000,000</td> 
                        <td>P 500,000</td> 
                    </tr>             
                </tbody>
            </table>

        </div>
    </section>
    <!-- Footer -->
    <footer style="background-color: #000; color: white; ">
        <div class="container text-center">
            <p>Copyright &copy; BMS</p>
        </div>
    </footer>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>

</body>

</html>
