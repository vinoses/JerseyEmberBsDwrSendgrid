<!doctype html>
<html>
<jsp:include page="/resources/partials/header.jsp"/>

<body>

<!--Bootstrap Navbar-->

<div class="container-fullwidth m-0 p-0" style="border-bottom:1px solid black;">

    <nav class="navbar navbar-expand-sm navbar-light bg-light w-100">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <img src="/JerseyEmberBsDwrSendgrid_war_exploded/resources/images/vinoses.png" class="img-fluid" alt="4WN F4C3">

        <div class="col ml-2 mr-5">
            DWR
            <div class="loadTime">
            </div>
            <div class="badge badge-pill badge-primary my-0"><p class="d-inline-flex my-0">Emails: </p>
                <p id="counter" class="d-inline text-right mx-1 my-0" value="counter()"></p>
            </div>
        </div>

        <div class="collapse navbar-collapse offset-1" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                <li class="nav-item"><a class="text-primary nav-link alert-link" href="./index.jsp">Home <span class="sr-only"></span></a></li>

                <li class="nav-item"><a class="text-primary nav-link alert-link" href="webapi/myresource">Jersey <span class="sr-only"></span></a></li>

                <li class="nav-item"><a class="text-primary nav-link alert-link" href="emission/index.html">Ember </a></li>

                <li class="nav-item"><a class="text-primary nav-link alert-link" onclick="upDate(); return false;" href="#">DWR </a></li>

                <li class="nav-item"><form id="emailServlet" class="bg-light border-0" method="post" style="border:none;"><input class="bg-light text-primary nav-link alert-link" type="submit" value="Sendgrid" style="border:none;"></form></li>

                <li class="nav-item dropdown">
                    <a class="text-info nav-link dropdown-toggle alert-heading alert-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dev</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-center nav-link alert-link" href="https://maven.apache.org/archetype/project-info.html">Maven <span class="sr-only"></span></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://guides.github.com/introduction/git-handbook/">Git <span class="sr-only"></span></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://gruntjs.com/getting-started">Grunt</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="text-info nav-link dropdown-toggle alert-heading alert-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Tools</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item nav-link alert-link text-center" href="https://www.jetbrains.com/help/idea/mastering-keyboard-shortcuts.html">Intellij</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="http://www.gnu.org/software/bash/manual/bash.html">Bash</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="http://www.querytool.com/help/">AQT</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="text-info nav-link dropdown-toggle alert-heading alert-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">APIs</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item nav-link alert-link text-center" href="https://datatables.net/examples/styling/bootstrap4">DataTables</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://sendgrid.com/resources/">Sendgrid</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="text-info nav-link dropdown-toggle alert-heading alert-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Programming</a>

                    <div class="dropdown-menu">
                        <a class="dropdown-item nav-link alert-link text-center" href="https://docs.oracle.com/javase/tutorial/java/javaOO/index.html">Java</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://getbootstrap.com/docs/4.1/getting-started/introduction/">Bootstrap</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://guides.emberjs.com/release/">Ember</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5">HTML5</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://www.tutorialrepublic.com/css-reference/css3-properties.php">CSS3</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://sass-lang.com/guide">Sass</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://frontendmasters.com/books/front-end-handbook/2019/">Javascript</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://github.com/nefe/You-Dont-Need-jQuery">Jquery</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="text-info nav-link dropdown-toggle alert-heading alert-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Deployment</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item nav-link alert-link text-center" href="http://tomcat.apache.org/tomcat-9.0-doc/">Tomcat</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://wildscribe.github.io/WildFly/17.0/index.html">Wildfly</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item nav-link alert-link text-center" href="https://hibernate.org/orm/documentation/5.4/">Hibernate</a>
                    </div>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>



<!--Bootstrap DataTables-->
<div class="container">
    <div class="row" style="margin : 10%;">
        <div class="col-md-12 column sortable">
            <h1 class="text-center">Bootstrap Datatables</h1>
            <table id='table' class="display table" data-page-length="3">

            </table>
        </div>
    </div>
</div>

<!--Jersey-->
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

<!--Ember-->
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
