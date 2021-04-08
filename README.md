# CodeChallenge

###How to Run

 * Clone this repository
 * Make sure you are using JDK 1.8 and Maven 3.x
 * Once the application runs you should see something like this:
 
  2021-04-08 22:38:50.597  INFO 23228 --- [           main] c.e.s.SimpleRestApisApplication          : Started SimpleRestApisApplication in 1.539 seconds (JVM running for 1.843)
  2021-04-08 23:19:21.916  INFO 23228 --- [nio-9090-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
  2021-04-08 23:19:21.916  INFO 23228 --- [nio-9090-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
  2021-04-08 23:19:21.928  INFO 23228 --- [nio-9090-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 12 ms
  
 ###About the Service
   Here is what this little application demonstrates:
   * Full integration with the latest Spring Framework
   * Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the java -jar command
   * Writing a RESTful service using annotation and using BufferReader and JSONObject to get the values from WeatherAPI
   * Sending a request from Input.html file to the server and displaying the related list of cities on Console.
 
 Here are some endpoints you can call:
 
 ####Get information about 
 1.  http://localhost:9090/input?name=a
   Here the alphabet value assign to the name so that related cities which starts with given letter as output before this we get list of cities 
   from the WeatherAPI.
   
    name1a
    GET Response Code ---> :: 200
    Yafran
    Zuwarah
    Sabratah
    Gharyan
    Zawiya
    Tripoli
    Tarhuna
    Masallatah
    Al Khums
    Zlitan
    Birkirkara
    Ragusa
    Pozzallo
    Modica
    Rosolini
   output is : Al Khums

2. Using Index.html enter alphabet into the text field then after 'GetCities' hits the server an url which is placed inside http://localhost:9090/input?name="+input 
    matching cities which starts with given letter as output in Console with list of cities.
    
##From the Resource
https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b8dfa918d701e0fdf762cde4dc0b7df6

    #### Questions and Comments swethakse@gmail.com


   

