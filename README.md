# survey-app
survey-app

# Technologies

JDK 1.8.0

Maven 4.0

SpringBoot 1.4.0.RELEASE

H2 DB

cd survey-app

Then run 

mvn clean package

Then run the 

java -jar target/survey-app-0.0.1-SNAPSHOT.jar

Application will start running on port 8080

# API Services

POST call

    {
        "surveyId": 2,
        "startDate": 1540105200000,
        "endDate": 1542700800000,
        "description": "Programming language used in 2020 ",
        "questionsList": [
        	{
                "questionId": 2,
                "text": "Which language do you use for OOP 2020?",
                "answerList": [
                    {
                        "answerId": 1,
                        "answerText": "JAVA"
                    },
                    {
                        "answerId": 2,
                        "answerText": "C#"
                    },
                    {
                        "answerId": 3,
                        "answerText": "Python"
                    },
                    {
                        "answerId": 4,
                        "answerText": "Scala"
                    }
                ]
            }
        ]
    }


GET call
```
[
    {
        "surveyId": 1,
        "startDate": 1540623600000,
        "endDate": 1543219200000,
        "description": "Programming language used in 2018",
        "questionsList": [
            {
                "questionId": 1,
                "text": "Which language do you use for OOP ?",
                "answerList": [
                    {
                        "answerId": 1,
                        "answerText": "JAVA"
                    },
                    {
                        "answerId": 2,
                        "answerText": "C#"
                    },
                    {
                        "answerId": 3,
                        "answerText": "Python"
                    },
                    {
                        "answerId": 4,
                        "answerText": "Scala"
                    }
                ]
            }
        ]
    },
    {
        "surveyId": 2,
        "startDate": 1540105200000,
        "endDate": 1542700800000,
        "description": "Programming language used in 2020 ",
        "questionsList": [
            {
                "questionId": 2,
                "text": "Which language do you use for OOP 2020?",
                "answerList": [
                    {
                        "answerId": 1,
                        "answerText": "JAVA"
                    },
                    {
                        "answerId": 2,
                        "answerText": "C#"
                    },
                    {
                        "answerId": 3,
                        "answerText": "Python"
                    },
                    {
                        "answerId": 4,
                        "answerText": "Scala"
                    }
                ]
            }
        ]
    }
]    

```


PUT 
```
{
        "surveyId": 2,
        "startDate": 1540105200000,
        "endDate": 1542700800000,
        "description": "Programming language used in 2021",
        "questionsList": [
        	{
                "questionId": 2,
                "text": "Which language do you use for OOP 2020?",
                "answerList": [
                    {
                        "answerId": 1,
                        "answerText": "JAVA"
                    },
                    {
                        "answerId": 2,
                        "answerText": "C#"
                    },
                    {
                        "answerId": 3,
                        "answerText": "Python"
                    },
                    {
                        "answerId": 4,
                        "answerText": "Scala"
                    }
                ]
            }
        ]
    }
```

Delete 

http://localhost:8080/survey/1



Questions



GET call

```
[
    {
        "questionId": 1,
        "text": "Which language do you use for OOP ?",
        "answerList": [
            {
                "answerId": 1,
                "answerText": "JAVA"
            },
            {
                "answerId": 2,
                "answerText": "C#"
            },
            {
                "answerId": 3,
                "answerText": "Python"
            },
            {
                "answerId": 4,
                "answerText": "Scala"
            }
        ]
    },
    {
        "questionId": 2,
        "text": "Which language do you use for OOP 2020?",
        "answerList": [
            {
                "answerId": 1,
                "answerText": "JAVA"
            },
            {
                "answerId": 2,
                "answerText": "C#"
            },
            {
                "answerId": 3,
                "answerText": "Python"
            },
            {
                "answerId": 4,
                "answerText": "Scala"
            }
        ]
    }
]
```

POST call

```
{
        "questionId": 3,
        "text": "Which language do you use for function programming in 2020?",
        "answerList": [
            {
                "answerId": 5,
                "answerText": "Scala"
            },
            {
                "answerId": 6,
                "answerText": "Clojure"
            },
            {
                "answerId": 7,
                "answerText": "Python"
            },
            {
                "answerId": 8,
                "answerText": "Go"
            }
        ]
    }
```

PUT Call

```
{
        "questionId": 3,
        "text": "Which language do you use for function programming in 2020?",
        "answerList": [
            {
                "answerId": 5,
                "answerText": "Scala"
            },
            {
                "answerId": 6,
                "answerText": "Clojure"
            },
            {
                "answerId": 7,
                "answerText": "Python"
            },
            {
                "answerId": 8,
                "answerText": "Go"
            }
        ]
    }
```

Delete call

http://localhost:8080/questions/3





Survey Response 

Get call

http://localhost:8080/response/1

```
{
    "response_id": 1,
    "surveyId": 1,
    "userId": 1,
    "answer": {
        "answerId": 1,
        "answerText": "JAVA"
    },
    "question": {
        "questionId": 1,
        "text": "Which language do you use for OOP ?",
        "answerList": [
            {
                "answerId": 1,
                "answerText": "JAVA"
            },
            {
                "answerId": 2,
                "answerText": "C#"
            },
            {
                "answerId": 3,
                "answerText": "Python"
            },
            {
                "answerId": 4,
                "answerText": "Scala"
            }
        ]
    }
}
```

GET response distribution

http://localhost:8080/response/survey/1/question/1

```
{
    "question": "Which language do you use for OOP ?",
    "totalResponseReceived": 6,
    "answerDistribution": {
        "C#": "33.0%",
        "JAVA": "33.0%",
        "Scala": "16.0%",
        "Python": "16.0%"
    }
}
```
Post http://localhost:8080/response

```
{
    "responseId":7,
    "surveyId": 1,
    "userId": 1,
    "answerId": 1,
    "questionId": 1
}
```

PUT http://localhost:8080/response
```
{
    "responseId":7,
    "surveyId": 1,
    "userId": 1,
    "answerId": 1,
    "questionId": 1
}
```

Delete http://localhost:8080/response/1


