## Initialize spring.io project

1 - We saw how SpringBoot methods works (run() in this case

2 - How we fix the warning of MongoDB when we run the code of spring api.

3 - We worked with @RestController and @GetMapping method to see how an easy enpoint works.

## Logical of the movieAPI project.

1 - Configure the MongoDB database to succesfully connect to the cluster that we initialize before in MongoDB Atlas
    
    - Go to /src/main/resources/application.properties 
    One here we have to write the app properties related with our project.
    For example, configure de MongoDB DEPENDENCY (Look the code there)
        

        spring.data.mongodb.database='databaseName'
        spring.data.mongodb.uri='databaseUri'

2 - Okey but put this information in application.properties it's safe at all

    - So, because of this we create a new '.env' file in resources path
    - Then we put the data there
    - After that, let's put '.env' in the .gitignore file

3 - Look fot .env dependencies to add for out project. 
    
    - Go to 'maven dependencies' and search for spring-dotenv
    - Spring Dotenv by me.paulschwarz
            <dependency>
			<groupId>me.paulschwarz</groupId>
			<artifactId>spring-dotenv</artifactId>
			<version>2.5.4</version>
		</dependency>
    - THEN REPLACE IN application.properties the values in .env file
        -> ${env.MONGO_DATABASE}, ${env.MONGO_USER}...

4- Now let's continue with the logic of the Project itself.
    
    In Our application there will be two types of data to take in account.
        - First -> The Movies, then
        - Second -> The Reviews
    So, let's code TWO DIFFERENT CLASSES for this entities 

    The MOVIE CLASS and REVIEW CLASS:
        - Will be a @Document -> This class represents each DOCUMENT in the MOVIE/REVIEW collection
        - and then declare all ours variables for each data for movies/reviews
        - with Getters, Setters and Constructors

5 - Now, Let's work with the CONTROLLERS 

    - New class MovieController -> Our first RESTAPI Controller in our API
    - Using the previous concepts -> @RestController and @GetMapping for methods
    - Now we see a new concept :
        -> ResponseEntity<String> ; 
        -> return new ResponseEntity<String>("All Movies!", HttpStatus.OK);

### - ANY REST API OUT THERE SHOULD RETURN PROPER STATUS CODES! THATS WHY WE USE THE CODE ABOVE
    - Watch it out in terminal with the following code : curl -i http://localhost:8080/api/v1/movies

6 - Now let's put some data in the DATABASE

    - SERVICE class and REPOSITORY class for this
        -> MovieRepository which is an INTERFACE CLASS! THIS WILL EXTEND MongoRepository
        -> MovieService is just a normal CLASS

    1 - In MovieService we define the method calls 'allMovies()' for all movies.  
    2 - In MovieInterface we just extends our MongoRepository inheritance.
    3 - and last but not least, in our CONTROLLER we define the method 'getAllMovies()'
        to get all movies with the status response for a HTTP request
    ( DO NOT FORGET THE MOVIEREPOSITORY INSTANCE WITH THE @AUTOWIRED CONSTRUCTOR)

## So, a summary of what we have done so far in these 6 steps
    
- In REST API's we will have MULTIPLE LAYERS.

    - One of the Layers is the 'API' Layer which, in our case, is the MovieController and it will only consult itself about the task of getting a request from the user and provide a Response for that request and nothing else.
    - All it's doing is using a SERVICE Class and having the task of show all the movies in the Database.
    - The following path for MovieController:
  
        1 - Calls to the 'allMovies()' method inside MovieService, GETS the list of the Movie and return all movies with the HttpStatus

    - Going back with the Service Class, here is where our business will go.
    - What SERVICE CLASS is doing ?
    
        -> Uses the REPOSITORY CLASS (private MovieRepository movieRepository;) and TALKS to the database, get the movies and returns to the API Layer.

    - What the REPOSITORY Layer does?

        -> Is doing the access to the Data in DATABASE for our API.
        -> 'TALKING' to the database and getting the DATA BACK.

7 - Now let's trying to access to a single movie

    1 - Begin with a new @GetMapping METHOD (getSingleMovie) inside the CONTROLLER (@GetMapping("/{id}") )
    2 - In SERVICE controller we need to declare a new METHOD to get a single movie by an Id.
    3 - This method in SERVICE will use the REPOSITORY to talk to the database to get that single movie by Id, and with the method findById
    4 - Using the 'OPTIONAL'. This is for the case of not existing any movie with that ID.
    5 - Now test it in the browser.. "localhost:8080/api/v1/movies/{id}"

-> BUT the problem is that I don't want to expose the objects ID's of my collection entities to the public.
SO in order to do that, I will use the 'imdbId' to search new movies.

    - By implementing the method by ourself
        -> There some called 'Automatic Queries'. Let's jump into it, in MovieRepository interface
        1 - In MovieRepository add an Optional Movie findbyImdbID.
        2 - Then change it too in MovieService
        3 - After that, change it in CONTROLLER TOO!

8 - Now, let's work with REVIEWS from user. 

    - We will define a new interface calls 'ReviewRepository'
    - Same as MovieRepository with the extends and all that.
    - Define a new calls calls ReviewService to manage the review for the movie itself, working with the reviewBody and the imdbId
    - Now we have a new concept -> MongoTemplate and his METHODS to update and push into DB the reviews
    (LEARN MORE ABOUT THIS, IT'S COMPLICATED A LITTLE BIT!)

9 - Once done, we will define the ReviewController to manage the logic of the reviews for every movie

10 - Once this finish, we can test the API in POSTMAN.

## And that's it! Simple but efficient API!


