# Movie Rental
***

# Overview
The Movie Rental website is created with the view to allow the users to rent movies. The movies can be filtered based on **_genre_**. The user can select one or more movies and proceed to rent the same.

# Execution
Run the application on the server.

# Technologies

Views 
> HTML5, Java Server Pages, CSS3, Javascript

Languages
>   Java 11

Database
>   Maria DB v2.7.3
 
Web Server
>    Apache Tomcat v9.0

Spring Framework
>    Spring MVC v5.3.9, Spring Data JPA v2.3.8 Release, Spring Security v5.5.1

---
# Technical Specification
***

    This application is created using Spring MVC and Spring Data JPA framework. The view pages are created using HTML5, CSS3, Javascript and Java Server Pages. This application uses MariaDb as the database.

    The JSP pages make use of various tags, images, tables and forms of HTML. The forms include text boxes, drop down boxes and submit buttons. The text on the pages are displayed in web fonts. 

    The styles on the pages are done using CSS3. The styles on the sheets are incorporating inline, internal and external styling. The CSS stylesheets use different selectors such as tag selectors, selector combinators, by class, by id and by pseudo classes.

    The front end validation for the forms is written in Javascript . The scripts are external scripts and are linked in the pages. The javascript files make use of variables, if statements, retrieves collections and iterates over the collection using for loops. It also includes functions/call back methods and invokes the event handler when an event is triggered.

# User Stories

* As a user I should be able to create an account so that I can access the movies.
* As a user I should be able to log into the application with the credentials to see a list of movies available.
* As a user I should be able to change my password so that I can keep my account secure. 
* As a user I should be able to log out of my account so that no one else can use my account.
* As a user I should have access to the list of all the available movies so that I can choose from the list.
* As a user I should be able to view the information of a particular movie.
* As a user I should be able to filter the movies based on genres.
* As a user I should be able to select one or more movies so that I can proceed with my rental.
* As a user I should be shown the selection and be asked for confirmation.
* As a user I should be able to remove the movie from the selection before completing the transaction.
* As a user I should be displayed with the confirmation page showing my completed transaction.
* As a user I should be able to navigate to home page. 
* As a user I should be able to view my account page to see the history of transactions.
* As a user I should be able to delete my account if I wish to.

# Challenges
   * This application uses Spring Data JPA. One of the biggest challenges I faced was when a user, selects movie(s) to rent,and completes the entire flow, the data would not persist in the data base. I had to change the way I was creating the relationship table and continue with the development of the application. I initially had an embedded id in my classes, but it would give me value by reflection error when trying to save the data.On changing the mapping between the entites and also removed the additional attributes for the association, when trying to persist the data, I was getting detach object error. I removed the cascade type and then it worked.
   * CSS file fails to reload on the page when a movie is removed from the list. I had to put the css inline in the page. But image is not being loaded. 
   * Javascript file was throwing space issues. I had to remove all the spaces between my checks and also put the {} in the next line.



