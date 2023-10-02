# springboot_exercise
## General Information:
This project is a simple Spring Boot REST API, based on a Youtube course I'm learning from.
The project generates test data: 100 posts and 100 comments, which we can view in swagger
by calling the appropriate methods.<br />
The Rest API is secured through Spring Security. Login data:<br />
Username: test<br />
Password: test<br />

- <b>method @GetMapping("/posts")</b> display 20 posts per page and sorts them ascending (ASC) or descending (DESC)
- <b>method @GetMapping("/posts/comments")</b> displays 20 posts per page with all comments and sorts them ascending (ASC) or descending (DESC)
- <b>method @GetMapping("/posts/{id}")</b> displays a single post after specifying id
- <b>method @PostMapping("/posts")</b> adding a new post
- <b>method @PutMapping("/posts")</b> editing a post
- <b>method @DeleteMapping("/posts/{id}")</b> deletes post after id
___

## Technologies Used:
- spring boot 3.1.2
- java 17
- swagger 2.0.3
- H2 Database
- Lombok
- Spring Data JPA
___

## Installation & Run

- IntelliJ 2022 or Higher
- Gradle 8.2.1

Download this project: 
https://github.com/MarlenaSP/springboot_exercise.git
<br />
Build and Run
<br />
API Endpoint : http://localhost:8080/swagger-ui/index.html
