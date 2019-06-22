# todo-springboot-angular8
ToDo application is one of the more beautifully designed application. It offers most of the features you'd want in a to-do list application, including allow to add new todo, show list of all Todos, update a Todo item, delete a Todo item and delete multiple Todo items.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

1. Java version - 8  download and install from here : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html and https://www.guru99.com/install-java.html
2. Apche tomact - download and install from  here : https://tomcat.apache.org/download-90.cgi

#### Install Angular

1. Install nodejs, go the homepage https://nodejs.org/en/download/

2. Install angular 8
    `npm install -g @angular/cli`
    `cd ToDoList` (root path of ToDoApplication)
    
   Extra library
	`npm install bootstrap --save`	
	`npm install --save @ng-bootstrap/ng-bootstrap`
	`npm install --save font-awesome angular-font-awesome`
	`npm install ngx-toastr --save`

#### Add Springboot sts plugin and angular plugin eclipse

1. We have to add sts eclipse plugin
2. Go to eclipse market place(preference/eclipse market place)
3. Type spring and search and install it
4. You can find spring tool 3 add on http://marketplace.eclipse.org/content/spring-tools-3-add-aka-spring-tool-suite-3
5. For angualr project serach angular in eclipse market
6. You will find angular plugin http://marketplace.eclipse.org/content/angular-ide and insall it.

#### Import Spring, angular in eclipse and sql file

1. Find springboot-rest from downloaded package trunk folder and import it into eclipse.
2. click import with angular project and select todo-angular8 from dowloaded package trunk folder.
3. Right click on springboot-rest and mavan clean-install from eclipse
4. If any error occurs please check common error section https://github.com/eliteevince/todo-springboot-angular8/blob/master/README.md#common-errors
5. On downloaded package you will find sql folder, and import todo_manager.sql in mysql
6. Find application.properties from springboot-rest and change username and password according to MySql(Also change port if require)


#### Run projects
1. Right click on springboot-rest and run as Java Application
2. Select JavaApplication SpringDemoApplication (from package todoweb.SpringDemoApplication.java)
3. If any error occurs please check common error section https://github.com/eliteevince/todo-springboot-angular8/blob/master/README.md#common-errors
4. Right click on todo-angular8 and run with angular web application
5. Project will run on browser automaticall. It may take some time to run first time.

#### Common Errors
1. The requested profile "pom.xml" could not be activated because it does not exist.
	Step - 1 Right click on your project in Eclipse
	Step - 2 Click Properties
	Step - 3 Select Maven in the left hand side list.
	Step - 4 You will notice "pom.xml" in the Active Maven Profiles text box on the right hand side. Clear it and click Apply.

2. Ignor pom.xml error

3. Access denied for user 'root'@'localhost' (using password: NO) : Please check you application.properties from springboot-rest
