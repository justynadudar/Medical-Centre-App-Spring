# Medical-Centre-App-Spring
A simple application for managing a medical center conducting research on various diseases. Application made as part of a recruitment assignment.

## Table of contents
* [Technologies](#technologies)
* [Features](#features)
* [Planned data model](#planned-data-model)
* [Setup](#setup)
* [Examples of use](#examples-of-use)

## Technologies:
- Java (version 19) 
- Spring framework
- PostgreSQL 


## Features:
- Create/modify/delete patients and their contact information.  

- Creating/modifying/deleting research projects. 

- Adding/withdrawing a patient's agreement to participate in a given project. 

- Assigning/deleting a patient's association with a research project (subject to existing consent).  </br>
   The linkage involves the creation of a patient agreement object; when the agreement is removed, the linkage is also removed

- Adding the patient's laboratory test orders, for a specific date within a given research project.  </br>
   Realized as a separate table, linked to the research project. When creating an order, it is checked whether there is an agreement between the patient and the research project. TestDate is of type timestamp so that the time of the laboratory test can also be specified. 

- Adding/modifying/deleting lab results of a particular patient performed on an order. </br>
  A table has been created for this, and the results are stored in a pdf file, so any modification, addition, or deletion involves editing the file field.

- Withdrawal of a patient's consent for a given project means withdrawal of participation in the project.  </br>
   When consent is removed, the link is also removed
### To do:
- Validation of data, such as phone number, email, date of birth, etc.
- Assigning roles to persons


## Planned data model:
![image](https://user-images.githubusercontent.com/62484042/202971121-5d513f72-acbf-4771-98d6-92d4130b13f2.png)
-------------
The program is created on the basis of a local PostgreSQL database, so in order for the application to work properly, you need to create a local database with the properties described in application.properties, namely:


- url = jdbc:postgresql://localhost:5432/task

- username = postgres

- password = netlab

## Setup

If you already have Java 19 and the above-mentioned database, then the program can be run in two ways:
- you can clone the repository, open it with the compiler and then run the TaskApplication located in src.main.java.com.example.task
- or you can download only the task-0.0.1-SNAPSHOT.jar file located in target and run it by double-clicking on the file, or via the command line using the command "java -jar task-0.0.1-SNAPSHOT.jar" of course being in the folder where the file is located

## Examples of use

In the screens below I show the results from Postman.</br>

### Adding a person:</br>

![image](https://user-images.githubusercontent.com/62484042/202925035-15d065ff-4fb5-404b-ab29-9f8d61d532d0.png)</br>
</br>

### Displaying people:</br>
![image](https://user-images.githubusercontent.com/62484042/202925064-69af0c30-9292-4284-803a-a4d9acc96e68.png)</br>
</br>

### Deleting a person:</br>
![image](https://user-images.githubusercontent.com/62484042/202926255-f0be9592-bd48-4437-a312-aca066849481.png)</br>
</br>

### Editing a person, is done by specifying the id in the parameter and sending the body of the edited object:</br>
![image](https://user-images.githubusercontent.com/62484042/202926425-c16c4fa4-6a27-406b-a858-471e33eb3401.png)</br>
</br>

### Adding a research project:</br>
![image](https://user-images.githubusercontent.com/62484042/202925081-3aebd269-abea-4fcc-bb69-6317b02a5c4d.png)</br>
</br>

### Displaying research projects:</br>
![image](https://user-images.githubusercontent.com/62484042/202925102-f25f04d1-fef8-467e-bbda-503303aab17c.png)</br>
</br>

### Agreement to participate in a research project, specify the patient to whom the agreement is being given and the project for which the agreement is being given:</br>
![image](https://user-images.githubusercontent.com/62484042/202925117-35f14274-9175-4fa8-b40c-fc9c92e13545.png)</br>
</br>

### Displaying research agreements:
![image](https://user-images.githubusercontent.com/62484042/202925131-82b39cb2-8568-4eee-b413-949b192c55ee.png)</br>
</br>

### Adding orders for laboratory tests, enter the patient, the ordering doctor, the project for which the test is being performed and the date of the test: </br>
![image](https://user-images.githubusercontent.com/62484042/202925260-ce684e75-79e1-4d6b-b4c9-dabd5cd8a271.png)</br>
</br>

### Displaying of test orders:
![image](https://user-images.githubusercontent.com/62484042/202925724-9860e9cd-696d-499c-8bd9-1afad259879f.png)</br>
</br>

#### If we try to task a patient who is not participating in a particular research project, an error is thrown:</br>
![image](https://user-images.githubusercontent.com/62484042/202925956-47351342-41c9-4ea6-8db8-1cf937bfa42f.png)
![image](https://user-images.githubusercontent.com/62484042/202925980-8e06cac0-1eb5-4e6a-b68c-e6b5b55e53fa.png)</br>
</br>

### Adding a laboratory test based on the agreement to it:</br>
![image](https://user-images.githubusercontent.com/62484042/202925332-b276aaaa-0b54-42eb-b18f-54cc3e9a4620.png)</br>
</br>

### Displaying laboratory tests: </br>
![image](https://user-images.githubusercontent.com/62484042/202925779-4da9b148-0999-4443-ada7-f44d18468dce.png)</br>
</br>

### Adding a test result file to an existing test: </br>
![image](https://user-images.githubusercontent.com/62484042/202925387-a6de4524-4d23-4c32-8802-1f83281a8779.png)
