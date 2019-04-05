# fizzbuzz

MAIN INFOS

Developed in Java 8 / Spring / MongoDB / Jongo / Gradle

Provides a rest API to compute a fizzbuzz with given data and get stats on asked data

Swagger doc : server/swagger-ui.html
If local : http://localhost:8080/swagger-ui.html

USAGE

File fizz-rest-service-1.0.jar (backend\build\libs) can be launched with command :
java -jar fizz-rest-service-1.0.jar
Change properties in application.properties for external mongodb server
DB_SERVER=localhost
DB_PORT=27017

API

Route for computing fizzbuzz :
v1/getFizz with params {
int int1
int int2
int limit
String str1
String str2
}

Returns a list of String :
[
    "1",
    "2"
]

Example :
http://localhost:8080/v1/getFizz?int1=3&int2=7&limit=23&str1=C&str2=G

Route for getting fizzbuzz stats (most occured fizz) :
v1/getFizzStats with no parameters

Returns a json object with asked params and number of occurences :
{
    "name": "3723CG",
    "int1": 3,
    "int2": 7,
    "limit": 23,
    "str1": "C",
    "str2": "G",
    "occurences": 14
}
Example :
http://localhost:8080/v1/getFizzStats