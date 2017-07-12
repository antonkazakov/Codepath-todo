# Codepath-todo
[![Build Status](https://travis-ci.org/antonkazakov/Codepath-todo.svg?branch=master)](https://travis-ci.org/antonkazakov/Codepath-todo)

Project for codepath.com Android bootcamp.

## Language
I've chosen Kotlin for its beauty and development speed.

## Architecture
This project is pretty simple, actually it consists of 5-6 screens (in **v1.0** possible increase in later releases) 
and uses only one data source, so I've decided to use simple MVP where **M** - repository calling SQLite, **V** - activities/fragments,
**P** - presenter throwing Data to View and wrapping Repository calls into Kotlin coroutines.

## Libraries used:
### v1.0
* anko-sqlite
* anko-coroutines
* dagger2

