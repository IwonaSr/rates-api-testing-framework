TO RUN REST API TESTS WITH GENERATING TEST REPORTS:
Command to run rest api tests:
```
mvn clean verify
```

Path to generated reports:
```
target/site/serenity/index.html
```

I didn't have time to implement all possible test cases. I would like to show my way of thinking. 
Due to lack of detailed specification (also no schema defined) I assumed some requirements which I discovered during endpoints testing.

Scenarios check rates only against the Euro. It may not work for other base values. 
To calculate rate format I use informations which I found on wikipedia. 
I validate rates values using following rules:
 - value of rate should be more than zero
 - rates precision cannot be more than 6
 
Validation of date includes checking if value is last working day in UTC zone (except holidays).



