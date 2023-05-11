# Ticket App
## Description

There you can see a little Cinema API that allows you to manage simple cinema models.
You can create movies and cinema halls, open new movie sessions and make orders.

## Features

As User:
- Find movies and cinema halls
- Find available movie sessions
- Add tickets to shopping cart
- View shopping cart
- Make an order
- View order history

As Admin:
- Find movies and cinema halls
- Find available movie sessions
- Create movies and cinema halls
- Open new movie sessions
- Find user info by email

## Structure

Project contains 7 models:
- User
- ShoppingCart
- Movie
- CinemaHall
- MovieSession
- Ticket
- Order

Each model has own repository to access from db and service for buisness logic.


There are all endpoints:
- Authentication:
  - POST /register - registration new user
  - POST /login - login
  - GET /logout - invalidate current session
- Cinema hall:
  - GET /cinema-halls/ - show list of all cinema halls
  - POST /cinema-halls/ - adds a new cinema hall
- Movie:
  - GET /movies/ - show list of all movies
  - POST /movies/ - adds a new movie
- Movie Sessions:
  - GET /movie-sessions/available/ - show all available movie sessions
  - POST /movie-sessions/ - adds a new movie session
  - PUT /movie-sessions/${id}/ - update movie session
  - DELETE /movie-sessions/${id} - delete movie session
- Shopping Cart:
  - GET /shopping-carts/by-user/ - show all tickets added to user's shopping cart
  - PUT /shopping-carts/movie-sessions/ - update shopping cart
- Order:
  - GET /orders/ - show user's order history
  - POST /orders/complete - complete order
- User:
  - GET /users/by-email/ - show user's information by email

## Technologies

- Java 17
- Apache Maven
- Apache Tomcat - version 9.X.X
- MySQL
- Hibernate
- Spring:
  - Core
  - Web Mvc
  - Security
  
## How to start
  
- Change values YOUR_DRIVER, YOURDATABASE_URL, YOUR_USERNAME, YOUR_PASSWORD on yours at the db.properties file.
- Build and start project
- Then you can register new user or login as an existing administrator with username ```admin@i.ua``` and password ```admin123```:
  - Send ```POST /register``` requests with parameters: ```login```, ```password``` and ```comfirmPassword``` to register new user.
  - Send ```POST /login``` requests with your or built-in ```username``` and ```password``` to get access to any endpoint.
- Send any http requests to endpoints from Structure part.
