Telegram Time Bot
=================

Выполнить поочередно 3 задания, реализовав тем самым минимально простой [бот для Telegram][1].

Каждое задание должно выполняться в рамках отдельного Gitlab issue/MR в соответствии с [Development Workflow][2]. 
Исходный код должен соответствовать принятому [Code Style][3].

В качестве языка программирования используйте Java.



### 1. Реализовать минимальный функционал чат бота

Необходимо разработать простой [chat-bot для Telegram][1]. Используйте [polling][4] метода [Telegram Bot API][5] `getUpdates` для получения команд пользователей.

Функционал:
- Бот должен реагировать на команду `/time`, возвратом  текущего времени по Гринвичу в формате `yyyy-MM-dd HH:mm:ss.SSS`.

Требования к реализации:
- Формат даты должен быть доступен для редактирования из настроек приложения.
- Таймаут запросов должен быть в настраиваемым параметром конфигурации приложения.
- Токен бота должен подтягиваться из конфигурации приложения.
- Проект должен собираться [Gradle][6] скриптом. 
- Наименование задач удовлетворения зависимостей, сборки, тестирования и запуска приложения должны быть добавлены в Readme.md.
- Используйте [Spring Framework][7]
- Код должен соответствовать [Google Java Style Guide][3]
- Код проекта должен быть покрыт Unit тестами.



### 2. Поддержка корпоративных стандартов разработки и публикации приложения

Необходимо адаптировать проект к корпоративным стандартам резработки, сборки, тестирования и публикации проектов.

Эта задача состоит из ряда подзадач:
1. Реализуйте сборку проекта в [Docker контейнере][8].
2. Реализуйте [CLI Линтинг][9]. В качестве рекомендации, можно использовать [Effective Java][10].
3. Реализуйте генерацию [Java doc][11].
4. Реализуйте проект в docker контейнере.
5. Дополните [Makefile]() коммандами управления docker-контейнерами удовлетворения зависимостей, сборки, тестирования и запуска приложения.



### 3. Расширение функционала чат бота.

Дополните функционал приложения следующими возможностями:
- Получите от бота координаты пользователя.
- Определите по координатам часовой пояс, используя один из публичных сервисов. Например [Google Maps Time Zone API][13].
- Вернуте пользователю локальное время с учетом его местоположения и указанием [Time Zone][14].


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

### Run Application

For running of the application you need to type and enter this command (be sure that you are in the root directory of the project):
```bash
$ gradle bootRun
```

[1]: http://mediatoolbox.ru/blog/botyi-telegram-vsyo-chto-vyi-hoteli-pro-nih-sprosit/
[2]: https://git.instrumentisto.com/common/documentation/blob/master/developers/workflow.md#issue-lifecycle
[3]: https://git.instrumentisto.com/common/documentation/blob/master/developers/codestyle.md#java
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
