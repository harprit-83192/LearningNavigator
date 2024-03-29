# LearningNavigator

This repository contains the codebase for the LearningNavigator project.

## Introduction

LearningNavigator is a Learning Management System (LMS) that provides exam enrollment functionality for students. It allows students to enroll in subjects and register for exams related to those subjects.

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Set up a MySQL database and configure the connection details in the `application.properties` file.
4. Run the application using Maven: `mvn spring-boot:run`.

## Endpoints

The following are the RESTful endpoints provided by the application:

- `POST /students`: Create a new student.
- `GET /students/{id}`: Get information about a specific student.
- `GET /subjects`: Get a list of all subjects.
- `GET /subjects/{id}`: Get information about a specific subject.
- `POST /exams/{examId}`: Register a student for a specific exam.
- `GET /hidden-feature/{number}`: Generate a fact about the number provided in the path parameter (Easter Egg feature).

## Testing

The project includes unit tests to ensure the functionality of the endpoints. To run the tests, use the following command:
mvn test

## Below are the results of the API requests made during testing:

POST /students: Created successfully.
GET /students/{id}: OK.
GET /subjects: OK.
GET /subjects/{id}: OK.
POST /exams/{examId}: OK.
GET /hidden-feature/{number}: OK.
Other endpoints: No content (204).

## Collection Data

{
	"id": "0873284c-af15-4a48-a06d-f91bccb6aa4c",
	"name": "LearningNavigator",
	"timestamp": "2024-03-29T11:47:59.461Z",
	"collection_id": "33745963-2e4af2e3-d3a8-4500-8b3d-7bb06d155f83",
	"folder_id": 0,
	"environment_id": "0",
	"totalPass": 0,
	"delay": 0,
	"persist": true,
	"status": "finished",
	"startedAt": "2024-03-29T11:47:40.409Z",
	"totalFail": 0,
	"results": [
		{
			"id": "d35cc0bd-0fbd-4fba-bd06-ceb2a844a0f3",
			"name": "http://localhost:8080/students",
			"url": "http://localhost:8080/students",
			"time": 590,
			"responseCode": {
				"code": 201,
				"name": "Created"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				590
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "2a0cdc75-0ed9-4733-b616-ad81fe97c30d",
			"name": "http://localhost:8080/students/1",
			"url": "http://localhost:8080/students/1",
			"time": 48,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				48
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "aa7a65fc-7fb0-4555-8a34-9d7e375215eb",
			"name": "http://localhost:8080/students",
			"url": "http://localhost:8080/students",
			"time": 55,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				55
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "7b80e801-75b7-4fd0-aa90-d050261b7762",
			"name": "http://localhost:8080/subjects",
			"url": "http://localhost:8080/subjects",
			"time": 1024,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1024
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "f91d8400-2d04-448b-ad6d-fe438b6878e8",
			"name": "http://localhost:8080/subjects",
			"url": "http://localhost:8080/subjects",
			"time": 1310,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1310
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "70dee3ee-8b4f-412a-843a-66d2f24b998f",
			"name": "http://localhost:8080/subjects/1",
			"url": "http://localhost:8080/subjects/1",
			"time": 37,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				37
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "a3cced53-c03d-4251-be3c-12510219a689",
			"name": "http://localhost:8080/exams",
			"url": "http://localhost:8080/exams",
			"time": 1010,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1010
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "ad4116c7-635a-461e-916c-3416b94ac46b",
			"name": "http://localhost:8080/students/1/enroll/1",
			"url": "http://localhost:8080/students/1/enroll/1",
			"time": 1843,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1843
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "f45fa381-b328-4957-b209-9e36fe84f520",
			"name": "http://localhost:8080/students/1/register/1",
			"url": "http://localhost:8080/students/1/register/1",
			"time": 1993,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				1993
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "d11e158c-d5d9-4142-92da-3ce175b01bf6",
			"name": "http://localhost:8080/hidden-feature/11",
			"url": "http://localhost:8080/hidden-feature/11",
			"time": 757,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				757
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "5e184a77-9920-4e05-95c1-a12f3ff29827",
			"name": "http://localhost:8080/students/1",
			"url": "http://localhost:8080/students/1",
			"time": 6599,
			"responseCode": {
				"code": 204,
				"name": "No Content"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				6599
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "02d42b1d-7144-45f7-975e-95850a2b781e",
			"name": "http://localhost:8080/subjects/1",
			"url": "http://localhost:8080/subjects/1",
			"time": 523,
			"responseCode": {
				"code": 204,
				"name": "No Content"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				523
			],
			"allTests": [
				{}
			]
		},
		{
			"id": "33fe2dc4-d76c-4c47-9d0b-b38adc87d294",
			"name": "http://localhost:8080/exams/1",
			"url": "http://localhost:8080/exams/1",
			"time": 611,
			"responseCode": {
				"code": 204,
				"name": "No Content"
			},
			"tests": {},
			"testPassFailCounts": {},
			"times": [
				611
			],
			"allTests": [
				{}
			]
		}
	],
	"count": 1,
	"totalTime": 16400,
	"collection": {
		"requests": [
			{
				"id": "d35cc0bd-0fbd-4fba-bd06-ceb2a844a0f3",
				"method": "POST"
			},
			{
				"id": "2a0cdc75-0ed9-4733-b616-ad81fe97c30d",
				"method": "GET"
			},
			{
				"id": "aa7a65fc-7fb0-4555-8a34-9d7e375215eb",
				"method": "GET"
			},
			{
				"id": "7b80e801-75b7-4fd0-aa90-d050261b7762",
				"method": "POST"
			},
			{
				"id": "f91d8400-2d04-448b-ad6d-fe438b6878e8",
				"method": "POST"
			},
			{
				"id": "70dee3ee-8b4f-412a-843a-66d2f24b998f",
				"method": "GET"
			},
			{
				"id": "a3cced53-c03d-4251-be3c-12510219a689",
				"method": "POST"
			},
			{
				"id": "ad4116c7-635a-461e-916c-3416b94ac46b",
				"method": "POST"
			},
			{
				"id": "f45fa381-b328-4957-b209-9e36fe84f520",
				"method": "POST"
			},
			{
				"id": "d11e158c-d5d9-4142-92da-3ce175b01bf6",
				"method": "GET"
			},
			{
				"id": "5e184a77-9920-4e05-95c1-a12f3ff29827",
				"method": "DELETE"
			},
			{
				"id": "02d42b1d-7144-45f7-975e-95850a2b781e",
				"method": "DELETE"
			},
			{
				"id": "33fe2dc4-d76c-4c47-9d0b-b38adc87d294",
				"method": "DELETE"
			}
		]
	}
}
