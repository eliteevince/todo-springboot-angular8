# todo-springboot-angular8
ToDo application is one of the more beautifully designed application on this list. It offers most of the features you'd want in a to-do list application, including allow to add new todo, show list of all Todos, update a Todo item, delete a Todo item and delete multiple Todo items.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

1:Java version - 8  download from  here : 
2:Apche tomact -  download from  here : 
	- download  tomcat from 
	- extract download zip or tar.gz file in drive location

3:Define Java Home ,Maven Home
 - define System variable 
	:>Go to My Computer>Right Click >Go To Properties>Click on Advance System Setting >Find Environment variable>click on Varible >Find Sysem Varibles>Click on new 
	> Add variable_name and variable_value 
		--like  variable_name:JAVA_HOME
		--variable_value:C:\Program Files (x86)\Java\jdk1.8.0_60
		--same add JRE_HOME and MAVEN_HOME
		--Edit Path Varible
			JAVA_HOME
			C:\Program Files (x86)\Java\jdk1.8.0_60
			JRE_HOME
			C:\Program Files (x86)\Java\jre1.8.0_60
			M2_HOME
			D:\Software\apache-maven-3.5.2-bin\apache-maven-3.5.2
			MAVEN_HOME
			D:\Software\apache-maven-3.5.2-bin\apache-maven-3.5.2
			Path
			%MAVEN_HOME%\bin;%JAVA_HOME%\bin;

4. Install nodejs, go the homepage https://nodejs.org/en/download/

5. Install angular 8
    npm install -g @angular/cli
cd ToDoList (root path of ToDoApplication)
Entra library
npm install bootstrap --save	
npm install --save @ng-bootstrap/ng-bootstrap
npm install --save font-awesome angular-font-awesome
npm install ngx-toastr --save

6. Run the project using below command 
ng serve -o (-o is optional for open browser after compiling code)
