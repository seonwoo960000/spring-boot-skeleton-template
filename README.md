# Spring Boot All In One 
## What is this project? 
This is a basic CRUD template project which include below dependencies: 
- Web
  - spring-boot-starter-web 
  - spring-boot-starter-validation(for validation)
- Data layer: 
  - spring-boot-starter-data-jpa
  - liquibase-core(for database scheme versioning)
  - mysql-connector-j(we use mysql)
  - testcontainers(for test profile only)
- Utility 
  - mapstruct 
  - lombok 
  - commons-io
  - commons-lang3 

## Schema Changes 
- Jpa entity, dto 
  - use JPA Buddy 
  - Use JPA Buddy to create entities/dto/spring data repository 
    - ![img_1.png](img_1.png)
- Apply schema changes in liquibase   
  - ![img.png](img.png)
  - ![image](https://user-images.githubusercontent.com/69591622/202469316-3f4fbddf-3d91-4e47-95b0-6115d05efb96.png)
## Testing 
- In order to use test containers, you should run docker locally 
# spring-boot-skeleton-template
