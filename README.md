# DiaDraw Interview Tasks

<h2>1. Login wizard</h2>

The project includes a react frontend and java spring boot backend. 

Backend - diadraw folder:
Java 17, Maven, Spring Boot 3.1.0, IntelliJ Community Edition

The program can be run by opening it with the IntelliJ IDE while having setup the Java 17 SDK and Maven. 
The project should get built automatically with all of the maven dependencies.
One environment variable is needed for it to work - INFO_BIP_API_KEY. This key can be obtained by creating an account on <a href="https://www.infobip.com">InfoBip</a> or by contacting me at 
losfrenn@gmail.com. This is needed to gain access to the mail and sms send api which is used for validation codes. The project will start on port localhost:8080. Make sure it is free or
just change the port in the configuration in necessary.

Frontend - diadraw-fe folder:
I believe the project in the repo includes all of the dependencies and libraries and should be easily run by just entering the directory and running - npm start in the console. The program will start on port
localhost:3000

After having both programs running locally testing should be possible. 

Disclaimer: The backend will attempt to send verification codes via the mail and sms send api but the code is also returned by the endpoints and can be seen in the browser console on the FE side. I did this
since the API I am using is in development mode and phone numbers, emails need to be registered beforehand in order to send messages to them. Please write to me if you want me to include credentials so this can
be tested.

<h2>2. Geometric shape calculator</h2>

geometry folder

The program should only require a version of Java 17 SDK and a copy of IntelliJ or another IDE to be run and tested.
