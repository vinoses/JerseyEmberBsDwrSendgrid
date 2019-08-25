package com.github.vinoses.jerseyemberbsdwrsendgrid;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getIt() {
        return "" +
                "<html>  " +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <title>Jersey Ember Bootstrap and DWR</title>\n" +
                "\n" +
                "    <!-- JQuery -->\n" +
                "    <script type=\"text/javascript\" src=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/jquery-3.4.1.js\"></script>\n" +
                "\n" +
                "    <!-- Bootstrap Scripts -->\n" +
                "    <script type=\"text/javascript\" src=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/popper.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/bootstrap.js\"></script>\n" +
                "\n" +
                "    <!-- Bootstrap DataTables -->\n" +
                "    <script type=\"text/javascript\" src=\"https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js\"></script>\n" +
                "\n" +
                "    <!-- DWR Script -->\n" +
                "    <script type=\"text/javascript\" src=\"/JerseyEmberBsDwrSendgrid_war_exploded/dwr/engine.js\"></script>\n" +
                "\n" +
                "    <!-- DWR JavaDate -->\n" +
                "    <script type=\"text/javascript\" src=\"/JerseyEmberBsDwrSendgrid_war_exploded/dwr/interface/JavaDate.js\"></script>\n" +
                "\n" +
                "    <!-- Page JS -->\n" +
                "    <script type='text/javascript' src=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/scripts/index.js\"></script>\n" +
                "\n" +
                "    <!-- CSS from Bootstrap - Font-Awesome - Override in style.css -->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/html5-boilerplate.css\" />\n" +
                "\n" +
                "    <!-- NOTE: changed .btn border to none, wouldn't override-->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/bootstrap.css\" />\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/bootstrap-responsive.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.18/css/jquery.dataTables.min.css\"/>\n" +
                "\n" +
                "    <!-- Styles.css - cascade after bootstrap.css to override-->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/css/style.css\" />\n" +
                "</head>" +

                "<body>" +
                "\n" +
                "<div class=\"container-fullwidth m-0 p-0\" style=\"border-bottom:1px solid black;\">\n" +
                "\n" +
                "    <nav class=\"navbar navbar-expand-sm navbar-light bg-light w-100\">\n" +
                "\n" +
                "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo03\" aria-controls=\"navbarTogglerDemo03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "            <span class=\"navbar-toggler-icon\"></span>\n" +
                "        </button>\n" +
                "\n" +
                "        <img src=\"/JerseyEmberBsDwrSendgrid_war_exploded/resources/images/vinoses.png\" class=\"img-fluid\" alt=\"4WN F4C3\">\n" +
                "\n" +
                "        <div class=\"col ml-2 mr-5\">\n" +
                "            DWR\n" +
                "            <div class=\"loadTime\">\n" +
                "            </div>\n" +
                "            <div class=\"badge badge-pill badge-primary my-0\"><p class=\"d-inline-flex my-0\">Emails: </p>\n" +
                "                <p id=\"counter\" class=\"d-inline text-right mx-1 my-0\">0</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"collapse navbar-collapse offset-1\" id=\"navbarTogglerDemo03\">\n" +
                "            <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n" +
                "\n" +
                "                <li class=\"nav-item\"><a class=\"text-primary nav-link alert-link\" href=\"../index.jsp\">Home <span class=\"sr-only\"></span></a></li>\n" +
                "                \n" +
                "                <li class=\"nav-item\"><a class=\"text-primary nav-link alert-link\" href=\"../webapi/myresource\">Jersey <span class=\"sr-only\"></span></a></li>\n" +
                "\n" +
                "                <li class=\"nav-item\"><a class=\"text-primary nav-link alert-link\" href=\"../emission/index.html\">Ember </a></li>\n" +
                "\n" +
                "                <li class=\"nav-item\"><a class=\"text-primary nav-link alert-link\" onclick=\"upDate(); return false;\" href=\"#\">DWR </a></li>\n" +
                "\n" +
                "                <li class=\"nav-item\"><form id=\"emailServlet\" class=\"bg-light border-0\" method=\"post\" style=\"border:none;\"><input class=\"bg-light text-primary nav-link alert-link\" type=\"submit\" value=\"Sendgrid\" style=\"border:none;\"></form></li>\n" +
                "\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"text-info nav-link dropdown-toggle alert-heading alert-link\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Dev</a>\n" +
                "                    <div class=\"dropdown-menu\">\n" +
                "                        <a class=\"dropdown-item text-center nav-link alert-link\" href=\"https://maven.apache.org/archetype/project-info.html\">Maven <span class=\"sr-only\"></span></a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://guides.github.com/introduction/git-handbook/\">Git <span class=\"sr-only\"></span></a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://gruntjs.com/getting-started\">Grunt</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"text-info nav-link dropdown-toggle alert-heading alert-link\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Tools</a>\n" +
                "                    <div class=\"dropdown-menu\">\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://www.jetbrains.com/help/idea/mastering-keyboard-shortcuts.html\">Intellij</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"http://www.gnu.org/software/bash/manual/bash.html\">Bash</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"http://www.querytool.com/help/\">AQT</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"text-info nav-link dropdown-toggle alert-heading alert-link\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">APIs</a>\n" +
                "                    <div class=\"dropdown-menu\">\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://datatables.net/examples/styling/bootstrap4\">DataTables</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://sendgrid.com/resources/\">Sendgrid</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"text-info nav-link dropdown-toggle alert-heading alert-link\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Programming</a>\n" +
                "\n" +
                "                    <div class=\"dropdown-menu\">\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://docs.oracle.com/javase/tutorial/java/javaOO/index.html\">Java</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://getbootstrap.com/docs/4.1/getting-started/introduction/\">Bootstrap</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://guides.emberjs.com/release/\">Ember</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5\">HTML5</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://www.tutorialrepublic.com/css-reference/css3-properties.php\">CSS3</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://sass-lang.com/guide\">Sass</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://frontendmasters.com/books/front-end-handbook/2019/\">Javascript</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://github.com/nefe/You-Dont-Need-jQuery\">Jquery</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "\n" +
                "                <li class=\"nav-item dropdown\">\n" +
                "                    <a class=\"text-info nav-link dropdown-toggle alert-heading alert-link\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Deployment</a>\n" +
                "                    <div class=\"dropdown-menu\">\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"http://tomcat.apache.org/tomcat-9.0-doc/\">Tomcat</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://wildscribe.github.io/WildFly/17.0/index.html\">Wildfly</a>\n" +
                "                        <div class=\"dropdown-divider\"></div>\n" +
                "                        <a class=\"dropdown-item nav-link alert-link text-center\" href=\"https://hibernate.org/orm/documentation/5.4/\">Hibernate</a>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "\n" +
                "            </ul>\n" +
                "            <form class=\"form-inline my-2 my-lg-0\">\n" +
                "                <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
                "                <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "</div>" +
                "<h1>Jersey Application!</h1>" +
                "</body>" +
                "</html>";
    }
}
