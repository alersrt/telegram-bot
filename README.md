Telegram Time Bot
=================

### Build Application

Before build you have to place `telegramBot_dev.properties` in to `src/main/resources/` directory.
This file must contains the following lines:
```bash
# Token for bot's authorizing (https://core.telegram.org/bots/api#authorizing-your-bot).
bot.token=[Telegram Bot API token]

# Datetime format (https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
bot.datetime.format="yyyy-MM-dd HH:mm:ss.SSS"

# Timeout pooling queries for bot
bot.timeout=1000
```

You can read about datetime format [there][15].

For build the application with Gradle you need to run this command in console (be sure that you are in the root directory of the project):
```bash
$ gradle build
```

Also you can build the application with Gradle via Docker's container:
```bash
$ make build
```
But you must be sure that your user can to read/write in to `/var/run/docker.sock` (or any because it depends from your distro) it reaching of user's adding to `docker` group.


### Run Application

For running of the application you need to type and enter this command (be sure that you are in the root directory of the project):
```bash
$ gradle bootRun
```
Also you can run this application via docker-container. For this you have to run this command:
```bash
$ make run
```
It runs application via `openjdk:alpine` container.

### Test Application

For running of the tests for this application you should to run the next command:
```bash
$ make test
```
It runs tests, shows process of the testing and shows information about summary coverage at the end of the process.

Also you can run the application with Gradle via Docker's container:
```bash
$ make run
```
Reports about code coverage and tests result are available by this paths: 
```
# code coverage
<project dir>/build/reports/jacoco
# test results
<project dir>/build/reports/tests
```

### Generate html-documentation

For generate of JavaDoc via Docker-container you need to run the next command:
```bash
$ make docs
```
Generated documentation will be available by this path: `<project dir>/build/docs/`.

### Linter

You can check your code with help of [PMD code analyzer][16] via docker-container. For this needs type the next command:
```bash
$ make lint
```
Also, this analyzer generates report which available by this path: `<project dir>/build/reports/pmd`.

[1]: http://mediatoolbox.ru/blog/botyi-telegram-vsyo-chto-vyi-hoteli-pro-nih-sprosit/
[4]: https://en.wikipedia.org/wiki/Polling_(computer_science)
[5]: https://core.telegram.org/bots/api
[6]: https://gradle.org/
[7]: https://projects.spring.io/spring-framework/
[8]: https://www.docker.com/
[9]: https://www.javaworld.com/article/2073587/javac-s--xlint-options.html
[10]: https://github.com/ftomassetti/effectivejava
[11]: http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[12]: https://ru.wikipedia.org/wiki/Make
[13]: https://developers.google.com/maps/documentation/timezone/intro?hl=ru
[14]: https://en.wikipedia.org/wiki/Time_zone
[15]: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
[16]: https://pmd.github.io/
