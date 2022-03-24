# M Booking Requests

Application that ranks suggestions of rental cars given a list of available cars and a booking request.

## Input Data
The input data of the application should be in the form of json files with the following structures:

### Car Suggestions
```json
{
  "suggestions": [
    {
      "carColor": "BLUE",
      "timeOffset": 30,
      "location": "3,2"
    },
    {
      "carColor": "GREEN",
      "timeOffset": 30,
      "location": "6,2"
    }
  ]
}
```
### Booking Request
```json
{
  "carColor": "GREEN",
  "location": "5,2"
}
```

## Usage
Running the project requires:
* Maven
* Java 11

To build and run the program the command below. Filepaths are given as relative paths from the ``/src/main/resources`` folder.
For example, the path of the current [suggestions](src/main/resources/data/suggestions.json) file is given as `/data/suggestions.json`
```shell
mvn exec:java \
-Dexec.mainClass=bookingrequests.Main \
-Dexec.args="<path to suggestions file> <path to booking request file>"
```


To run all tests run:
```shell
mvn test
```
