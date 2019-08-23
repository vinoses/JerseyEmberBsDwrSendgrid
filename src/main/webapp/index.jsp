<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Jersey Ember Bootstrap and DWR</title>

    <!-- JQuery -->
    <script type="text/javascript" src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/jquery-3.4.1.js"></script>

    <!-- Bootstrap Scripts -->
    <script type="text/javascript" src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/popper.js"></script>
    <script type="text/javascript" src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/bootstrap.js"></script>

    <!-- Bootstrap DataTables -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

    <!-- DWR Script -->
    <script type="text/javascript" src="/JerseyEmberBsDwrSendgrid_war_exploded/dwr/engine.js"></script>

    <!-- DWR JavaDate -->
    <script type="text/javascript" src="/JerseyEmberBsDwrSendgrid_war_exploded/dwr/interface/JavaDate.js"></script>

    <!-- Page JS -->
    <script type='text/javascript' src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/index.js"></script>

    <!-- CSS from Bootstrap - Font-Awesome - Override in style.css -->
    <link rel="stylesheet" type="text/css" href="/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/html5-boilerplate.css" />

    <%-- NOTE: changed .btn border to none, wouldn't override--%>
    <link rel="stylesheet" type="text/css" href="/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css"/>

    <%-- Styles.css - cascade after bootstrap.css to override--%>
    <link rel="stylesheet" type="text/css" href="/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/style.css" />
</head>
<body>

<%--Bootstrap Navbar--%>
<header>
    <div class="container">
            <nav class="navbar navbar-expand-sm navbar-light bg-light w-100">

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <img src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/images/vinoses.png" class="img-fluid">

                <div class="col ml-2 mr-5">
                    DWR
                    <div class="loadTime">
                    </div>
                </div>

                <div class="collapse navbar-collapse offset-1" id="navbarTogglerDemo03">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link alert-link" href="webapi/myresource">Jersey <span class="sr-only"></span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link alert-link" href="emission/index.html">Ember </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link alert-link" href="https://getbootstrap.com/docs/4.1/getting-started/introduction/">Bootstrap</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
</header>

<%--Bootstrap DataTables--%>
<div class="container">
    <div class="row" style="margin : 10%;">
        <div class="col-md-12 column sortable">
            <h1 class="text-center">Bootstrap Datatables</h1>
            <table id='table' class="display table" data-page-length="3">
                <thead>
                <tr class="row"><span class="caret"></span>
                    <th class="col">#</th>
                    <th class="col">Product</th>
                    <th class="col">Payment Taken</th>
                    <th class="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <tr class="row table-primary">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Default</td>
                </tr>
                <tr class="row table-success">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Approved</td>
                </tr>
                <tr class="row table-danger">
                    <td class="col">2</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">02/04/2012</td>
                    <td class="col">Declined</td>
                </tr>
                <tr class="row table-warning">
                    <td class="col">3</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">03/04/2012</td>
                    <td class="col">Pending</td>
                </tr>
                <tr class="row table-info">
                    <td class="col">4</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">04/04/2012</td>
                    <td class="col">Call in to confirm</td>
                </tr>
                <tr class="row table-primary">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Default</td>
                </tr>
                <tr class="table-success row">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Approved</td>
                </tr>
                <tr class="row table-danger">
                    <td class="col">2</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">02/04/2012</td>
                    <td class="col">Declined</td>
                </tr>
                <tr class="row table-warning">
                    <td class="col">3</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">03/04/2012</td>
                    <td class="col">Pending</td>
                </tr>
                <tr class="row table-info">
                    <td class="col">4</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">04/04/2012</td>
                    <td class="col">Call in to confirm</td>
                </tr>
                <tr class="row table-primary">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Default</td>
                </tr>
                <tr class="table-success row">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Approved</td>
                </tr>
                <tr class="row table-danger">
                    <td class="col">2</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">02/04/2012</td>
                    <td class="col">Declined</td>
                </tr>
                <tr class="row table-warning">
                    <td class="col">3</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">03/04/2012</td>
                    <td class="col">Pending</td>
                </tr>
                <tr class="row table-info">
                    <td class="col">4</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">04/04/2012</td>
                    <td class="col">Call in to confirm</td>
                </tr>
                <tr class="row table-primary">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Default</td>
                </tr>
                <tr class="table-success row">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Approved</td>
                </tr>
                <tr class="row table-danger">
                    <td class="col">2</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">02/04/2012</td>
                    <td class="col">Declined</td>
                </tr>
                <tr class="row table-warning">
                    <td class="col">3</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">03/04/2012</td>
                    <td class="col">Pending</td>
                </tr>
                <tr class="row table-info">
                    <td class="col">4</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">04/04/2012</td>
                    <td class="col">Call in to confirm</td>
                </tr>
                <tr class="row table-primary">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Default</td>
                </tr>
                <tr class="table-success row">
                    <td class="col">1</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">01/04/2012</td>
                    <td class="col">Approved</td>
                </tr>
                <tr class="row table-danger">
                    <td class="col">2</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">02/04/2012</td>
                    <td class="col">Declined</td>
                </tr>
                <tr class="row table-warning">
                    <td class="col">3</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">03/04/2012</td>
                    <td class="col">Pending</td>
                </tr>
                <tr class="row table-info">
                    <td class="col">4</td>
                    <td class="col">TB - Monthly</td>
                    <td class="col">04/04/2012</td>
                    <td class="col">Call in to confirm</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--Jersey--%>
<div class="bg-info w-100">
    <form class="container">
        <div class="row">
            <h2 class="col-12 text-center">Jersey RESTful Web Application!</h2>
            <p class="col-12 text-left"><a href="webapi/myresource">Jersey resource</a>
            </p>
            <p class="col-12 text-right alert-link" style="margin-bottom: 0px;">Visit <a href="http://jersey.java.net">Project Jersey website</a>
                for more information on Jersey!
            </p>
        </div>
    </form>
</div>

<%--Ember--%>
<div class="w-100 bg-success">
    <form class="container">
        <div class="row">
            <h2 class="col-12 text-center">Ember Web Application!</h2>
            <p class="col-12 text-left"><a href="emission/index.html">Ember Application</a>
            <p class="col-12 text-right alert-link" style="margin-bottom: 0px;">Visit <a href="https://guides.emberjs.com/v3.12.0/tutorial/ember-cli/">Emberjs v3.12 Guide</a>
                for more information on Emberjs!
            </p>
        </div>
    </form>
</div>

</body>
</html>
