# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## NPM PACKAGES TO INTEGRATE TO OUR MOVIE APP

- Axios : Https request from our react client to our API build in java and out MongoDB database.
- Bootstrap : For css styles and adding in index.js the boostrap import (import 'bootstrap/dist/css/bootstrap.min.css';)
- Bootstrap related components :  npm install react-bootstrap
- Font awesome icons : npm i @fortawesome/react-fontawesome
- Second font awesome component : npm i @fortawesome/free-solid-svg-icons
- React player controller : npm i react-player
- Declare our component in order to map the routes: relevants components to routes and dom : npm i react-router-dom
- Carousel for the movies : material UI -> npm install @mui/material @emotion/react @emotion/styled
- Material UI carousel component -> npm install react-material-ui-carousel


### Steps

    1 - First, we setting up the 'axiosConfig' for the api requests, with the code in there
        CAREFOUL HERE!
            - In my Java code for my API, I needed to add the feature @CrossOrigin(origins = "*") Because of a problem between the conections in localhost. El problem 
            was because the Tomcat’s port is 8080 and the React’s port is 3000, there is a cross-domain problem, and requests will be blocked by the CORS policy.
        And then we set up, in App.js, the method to get all the movies from the database through API call (getMovie()).

    2 - Now, let's build the frontend components for the design and everything related with that.

