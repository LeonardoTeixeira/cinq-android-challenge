# CINQ Android Challenge

This challenge was done following the instructions of [this project](https://github.com/cinqtechnologies/frontend-and-mobile-test).

## Project technologies

- Native Android
- Kotlin
- MVP Architecture
- Retrofit
- RxJava

## Configuration steps

1) Run [this project](https://github.com/cinqtechnologies/frontend-and-mobile-test)  locally
2) Edit the `API_BASE_URL` constant by entering the URL of the API in the following file: `app/src/main/java/br/com/leonardoteixeira/cinqchallenge/Config.kt`
3) Add the IP that gives access to your machine on your local network in the following file: `app/src/main/res/xml/network_security_config.xml`

## Running

Connect an Android device via USB to your machine and run the following command inside the project folder:

> gradlew installDebug

If you prefer, import the project into Android Studio and run it within the program.

## Author

Leonardo Teixeira ([@LeonardoTeixeira](https://github.com/LeonardoTeixeira))