<h1 align=center>
    Course
</h1>

<h2 align=center>
    Decoder Project
</h2>

<p align=center>
    <a href="#technologies">Technologies</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#project">Project</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#configuration">Configuration</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#running">Running</a>
</p>

<p align=center>
  <a href="https://github.com/delonborges/decoder-course/actions"> <img alt="qodana" src="https://img.shields.io/github/actions/workflow/status/delonborges/decoder-course/.github%2Fworkflows%2Fcode_quality.yml?style=flat-square&logo=githubactions&logoColor=white&label=qodana"></a>
  <a href="https://delon.com"> <img alt="Course" src=https://img.shields.io/badge/course-blue?style=flat-square&label=decoder%20project></a>
</p>
___

<h3 id="technologies">✨ Technologies</h3>

- [Java](https://www.oracle.com/java/technologies/downloads/)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [PostgresSQL](https://www.postgresql.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

___

<h3 id="project">💻 Project</h3>
The `course` project is a system designed to manage courses.  
This project was developed during the [Decoder Project](https://www.decoderproject.com/).

___

<h3 id="configuration">🛠️ Configuration</h3>
The project requires a PostgreSQL database, so you need to create a database with the following commands:

```sh
$ CREATE DATABASE decoder-course;
```

___

<h3 id="running">🚀 Running</h3>
To build and run this project, run the following command:

```sh
$ gradle bootRun
```
