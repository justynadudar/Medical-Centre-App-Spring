# Recruitment-Task
<b>Task completed as part of a recruitment assignment, done with a time constraint, so it is not fully worked out yet. </b>

Implementation technology: Java (version 19) + Spring framework

-------------
Planned data model: <br /><br />
![image](https://user-images.githubusercontent.com/62484042/202924751-51249946-2875-46e6-a18b-235ee4cf0efc.png)
-------------
The program is created on the basis of a local PostgreSQL database, so in order for the application to work properly, you need to create a local database with the properties described in application.properties, namely:


- url = jdbc:postgresql://localhost:5432/task

- username = postgres

- password = netlab
-------------
If you already have Java 19 and the above-mentioned database, then the program can be run in two ways:
- you can clone the repository, open it with the compiler and then run the TaskApplication located in src.main.java.com.example.task
- or you can download only the task-0.0.1-SNAPSHOT.jar file located in target and run it by double-clicking on the file, or via the command line using the command "java -jar task-0.0.1-SNAPSHOT.jar" of course being in the folder where the file is located
-------------
In the screens below I show the results from Postman

## Person
![image](https://user-images.githubusercontent.com/62484042/202925035-15d065ff-4fb5-404b-ab29-9f8d61d532d0.png)
![image](https://user-images.githubusercontent.com/62484042/202925064-69af0c30-9292-4284-803a-a4d9acc96e68.png)
![image](https://user-images.githubusercontent.com/62484042/202926255-f0be9592-bd48-4437-a312-aca066849481.png)
![image](https://user-images.githubusercontent.com/62484042/202926425-c16c4fa4-6a27-406b-a858-471e33eb3401.png)
![image](https://user-images.githubusercontent.com/62484042/202926443-a5a999f7-ba07-454e-884f-02b05f1f2e30.png)

-------------
## Research Project
![image](https://user-images.githubusercontent.com/62484042/202925081-3aebd269-abea-4fcc-bb69-6317b02a5c4d.png)
![image](https://user-images.githubusercontent.com/62484042/202925102-f25f04d1-fef8-467e-bbda-503303aab17c.png)
-------------
## Agreement To Participate
![image](https://user-images.githubusercontent.com/62484042/202925117-35f14274-9175-4fa8-b40c-fc9c92e13545.png)
![image](https://user-images.githubusercontent.com/62484042/202925131-82b39cb2-8568-4eee-b413-949b192c55ee.png)
-------------
## Order For Laboratory Test
![image](https://user-images.githubusercontent.com/62484042/202925260-ce684e75-79e1-4d6b-b4c9-dabd5cd8a271.png)
![image](https://user-images.githubusercontent.com/62484042/202925724-9860e9cd-696d-499c-8bd9-1afad259879f.png)

### If we try to task a patient who is not participating in a particular research project, an error is thrown:
![image](https://user-images.githubusercontent.com/62484042/202925956-47351342-41c9-4ea6-8db8-1cf937bfa42f.png)
![image](https://user-images.githubusercontent.com/62484042/202925980-8e06cac0-1eb5-4e6a-b68c-e6b5b55e53fa.png)

-------------
## Laboratory Test
![image](https://user-images.githubusercontent.com/62484042/202925332-b276aaaa-0b54-42eb-b18f-54cc3e9a4620.png)
![image](https://user-images.githubusercontent.com/62484042/202925779-4da9b148-0999-4443-ada7-f44d18468dce.png)
![image](https://user-images.githubusercontent.com/62484042/202925387-a6de4524-4d23-4c32-8802-1f83281a8779.png)
![image](https://user-images.githubusercontent.com/62484042/202925825-59cf9a7b-6dcd-44b4-80d8-cf5b788d3008.png)
