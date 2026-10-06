# Blog Management
A blog website with user authentication.

## Tech Stack
* Spring Boot 4.1.1 on Java 25
* Spring Data JPA

## API

| Method | Path                             | Auth          | Description          |
|--------|----------------------------------|---------------|----------------------|
|  POST  | /api/v1/auth/logout              | authenticated | Logout of the system |
|  POST  | /api/v1/auth/login               | public        | Login to the system  |
|  POST  | /api/v1/auth/register            | public        | Create a new user    |
|||||
|  GET   | /api/v1/comments/{commentId}     | public        |----------------------|
|  PUT   | /api/v1/comments/{commentId}     | authenticated |----------------------|
| DELETE | /api/v1/comments/{commentId}     | authenticated |----------------------|
|||||
|  GET   | /api/v1/posts                    | public        |----------------------|
|  POST  | /api/v1/posts                    | authenticated |----------------------|
|  GET   | /api/v1/posts/{postId}           | public        |----------------------|
|  GET   | /api/v1/posts/{postId}/comments  | public        |----------------------|
|  POST  |  /api/v1/posts/{postId}/comment  | authenticated |----------------------|
|  PUT   | /api/v1/posts/{postId}           | authenticated |----------------------|
| DELETE | /api/v1/posts/{postId}           | authenticated |----------------------|
|||||
|  GET   | /api/v1/users/{id}               | public        |----------------------|
|  GET   | /api/v1/users/{id}/posts         | public        |----------------------|


