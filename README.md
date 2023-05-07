# Ticket App
## Description

There you can see little Cinema API that allows you to manage simple cinema model. You can create movies and cinema halls, open new movie sessions and make orders.

## Features

As User:
- Find movies and cinema halls
- Find available movie sessions
- Add tickets to shopping cart
- View shopping cart
- Make an order
- View oreder history

As Admin:
- Create movies and cinema halls
- Open new movie sessions
- Find user info by email

## Structure

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
