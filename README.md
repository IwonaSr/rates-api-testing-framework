TO RUN REST API TESTS WITH GENERATING TEST REPORTS:
mvn clean verify

PATH TO GENERATED REPORTS:
target/site/serenity/index.html

I didn't have time to implement all possible test cases. I would like to show my way of thinking. 
Due to lack of detailed specification I assumed some requirements which I discovered during testing endpoints.

Scenarios check rates only against the Euro. It may not work for other base values. 
To calculate precision format I use informations which I found on wikipedia. 
I validate rates values using following rules:
 - value of should be more than zero
 - rates precision have to be more than 6
 
Validation of date include checking if value is last working day in UTC zone (except holidays).
 
If schema was available I would check also field types. 



