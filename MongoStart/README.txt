First Project (Mongo DB)

This project entails my first encounter with MongoDB and the MongoDB Java Driver. This README is supposed to help 
any developer out there trying to figure out how to use MongoDB through Java. I try to be as clear and descriptive
as possible; however, I will sumarize greatly certain steps. This tutorial is suitable for developers that are confortable with:
- Java.
- Command Prompt commands.
- Setting up Environment variables.


Prequisites to Run the Program and Tips.

1.- Set Up Mongo DB

Before using the MongoDB Java Driver it is necessary to set up MongoDB in your computer. In relation to OSX,
I recommendable installing MongoDB through the package manager Homebrew (http://brew.sh/), since it simplifies 
installation and allows starting a MongoDB shell from any directory in your computer. Also, I recommend trying 
out the MongoDB course in the E-learning webpage Team Treehouse (teamtreehouse.com) to learn more about setting 
up, benefits of the mentioned type of Database and how to get started.

2.- Set Up Maven

After setting up MongoDB, it is recommendable to set up the dependency manager Maven. This Java Tool allows a 
a project to describe how it depends from local or hosted libraries. Moreover, it automatically gets those 
libraries from the web or locally, such that developers do not need to worry about dowloading jar files and
adding them to the project's classpath. The following links describe how to set up Maven in OSX:

http://www.mkyong.com/maven/install-maven-on-mac-osx/
http://maven.apache.org/install.html


Although I think Homebrew is a great tool, their Maven install is buggy. There are a couple articles mentioning 
how to fix this issue. Nevertheless, I think it is easier to install this tool manually. Also you should check out 
the following links to learn how to use Maven:

https://spring.io/guides/gs/maven/#scratch
https://www.youtube.com/playlist?list=PL92E89440B7BFD0F6

3.- Understanding MongoDB Java Driver

I recommend following this tutorial in order to learn how to insert and query data from MongoDB. I based most of 
this application on it. However, there are problems with the tutorial that describes how to insert data. The lines 
that use the parse method make the compiler throw an error, since these calls might throw exceptions. The compiler 
forces you to build a try-catch block around them. This project tackles this issue.


