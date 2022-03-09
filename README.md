Brief:

I am part of MTU's REACH programme which aims to establish meaningful relationships between students and academic staff. 

I have been assigned students (mentees). I need a system to allow me to make notes about mentees. These notes must be date stamped so I can view the history of my interactions with the student.

Other users also need access to the service, for example, the Head of Department and REACH coordinators who wish to ensure that I am fulfilling my role. They should be given read but not write access to the system.  

You are required to create a web-based, secure application that allows me to make notes about, and keep track of, my mentees. 

The data stored about each User is:

Email address (username)
Password
Role (REVIEWER or MENTOR or API)
First name
Last name
The data stored each Mentee (Student) is:

Student id
Email address
First name
Surname
Notes about the student
Each Note should have

Date of creation
Text
Once authenticated, I should be able to

Add a student
Search for a student by student id and view their information and notes including date of creation
Add a note about a student
List those students who are not active in the REACH programme i.e. who have no notes.
Once authenticated, a reviewer should be able to

Search for a student by student id and view their information and note(s)
some statistics
number of mentees
average number of notes per mentee
View students who have more than 4 notes and are therefore taking up a lot of my time
This system should only work for one mentor at present - me - so don't worry about creating complicated relationships here. The database will consist of a table for users (me plus some reviewers with read-only access), a table of students/mentees and a table of notes. You must establish relationships between the students and their notes.

REST API
You are required to create 2 endpoints for an authenticated API user:

returns all notes for a student
delete a student
Instructions
You must use the following:

Spring Boot
Spring MVC
Thymeleaf for the front-end
Spring Data JPA 
Spring Security
H2 for an embedded database
Maven
Unit tests are not required.

You may use Project Lombok if you wish but it is not a requirement.
