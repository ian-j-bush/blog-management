# Blog Management
A blog website with user authentication.

## Tech Stack
* Spring Boot 4.1.1 on Java 25
* Spring Data JPA
* React frontend

## API

| Method | Path                             | Auth          | Description                                         |
|--------|----------------------------------|---------------|-----------------------------------------------------|
|  POST  | /api/v1/auth/logout              | authenticated | Logout of the system                                |
|  POST  | /api/v1/auth/login               | public        | Login to the system                                 |
|  POST  | /api/v1/auth/register            | public        | Create a new user                                   |
|||||
|  GET   | /api/v1/comments/{commentId}     | public        | Retrieve the comment with the following ID          |
|  PUT   | /api/v1/comments/{commentId}     | authenticated | Update the comment with the specified ID            |
| DELETE | /api/v1/comments/{commentId}     | authenticated | Delete the comment with the specified ID            |
|||||
|  GET   | /api/v1/posts                    | public        | Get all posts                                       |
|  POST  | /api/v1/posts                    | authenticated | Submit a new blog post                              | 
|  GET   | /api/v1/posts/{postId}           | public        | Get the post with the specified ID                  |
|  GET   | /api/v1/posts/{postId}/comments  | public        | Get all comments for the post with the specified ID |
|  POST  |  /api/v1/posts/{postId}/comment  | authenticated | Post a comment on the post with the specified ID    |
|  PUT   | /api/v1/posts/{postId}           | authenticated | Update a post with the specified ID                 |
| DELETE | /api/v1/posts/{postId}           | authenticated | Delete a post with the specified ID                 |
|||||
|  GET   | /api/v1/users/{id}               | public        | Get the user with the specified ID                  |
|  GET   | /api/v1/users/{id}/posts         | public        | Get posts created by user with the specified ID     |


