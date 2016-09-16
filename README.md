# Dictionary

#### Epicodus Java exercise to practice routing and using Spark

#### By Sandro Alvarez

## Description

This is a dictionary app that lets the user input their own word and definitions.

## Specifications

Input Behavior | Input | Output |
---------------|-------|--------|
creates a new word | "hello" | "hello" |
creates a definition for selected word | "a greeting" | "Hello, Definition: A greeting" |

### Routing

| Behavior                                                          | Path                     | HTTP Verb | App.java Example                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Process                                                                                                                                                                            |
|-------------------------------------------------------------------|--------------------------|-----------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Home Page                                                         | /                        | GET       | get("/", (request, response) -> Map<String, Object> model = new HashMap<String, Object>(); model.put("words", Word.all()); model.put("template", "templates/index.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine());                                                                                                                                                                                                                | User requests page. Server sends HTTP GET request. Spark matches request to "/" route.                                                                                             |
| Display word form                                                 | /word-form               | GET       | get("/word-form", (request, response) -> {Map<String, Object> model = new HashMap<String, Object>(); model.put("template", "templates/word-form.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine());                                                                                                                                                                                                                                  | User requests form to create new word. Server returns page with word form. *Form action and method must match path/verb of route below.*                                           |
| Display definitions for selected word                             | /word/:id/definition     | GET       | get("/word/:id/definition", (request, response) -> {Map<String, Object> model = new HashMap<String, Object>(); Word word = Word.find(Integer.parseInt(request.params(":id"))); model.put("word", word); model.put("template", "templates/word-definitions.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine());                                                                                                                        | User requests page. Server collects selected word, renders template. Velocity loops through definitions and displays them.                                                         |
| Display definition form                                           | /word/:id/definition/new | GET       | get("/word/:id/definition/new", (request, response) -> {Map<String, Object> model = new HashMap<String, Object>(); Word word = Word.find(Integer.parseInt(request.params(":id"))); model.put("word", word); model.put("template", "templates/definition-form.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine());                                                                                                                     | User requests form to create new definition for selected word. Server returns page with definition form. *Form action and method must match path/verb of route below.*             |
| Creates new word with definition when word form is submitted      | /                        | POST      | post("/", (request, response) -> {Map<String, Object> model = new HashMap<String, Object>(); Definition newDefinition = new Definition(request.queryParams("description")); Word newWord = new Word(request.queryParams("name")); newWord.addDefinition(newDefinition); model.put("words", Word.all()); model.put("template", "templates/index.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine());                                   | User submits word form. Server grabs attributes from form. Uses them to create new word. Server renders the home page with all words listed.                                       |
| Creates new definition for word when definition form is submitted | /word/:id/definition/new | POST      | post("/word/:id/definition/new", (request, response) -> {Map<String, Object> model = new HashMap<String, Object>(); Word word = Word.find(Integer.parseInt(request.params(":id"))); Definition newDefinition = new Definition(request.queryParams("description")); word.addDefinition(newDefinition); model.put("word", word); model.put("template", "templates/word-definitions.vtl"); return new ModelAndView(model, layout);}, new VelocityTemplateEngine()); | User submits description form. Server grabs attributes from form. Uses them to create new description for selected word. Server renders page with all definitions of selected word.|

## Setup

* Clone this repository

* Type gradle run in terminal and go to localhost:4567 in browser

## Technologies Used

* Java

* Gradle

* JUnit

* Spark

* VelocityTemplateEngine

## Support

If you run into any problems, contact me at sandromateo22@gmail.com

### Legal

Copyright (c) 2016 Sandro Alvarez.

Licensed under the MIT license
