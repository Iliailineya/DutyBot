
ТЕХСТЕК
----------
Spring Boot
https://spring.io/projects/spring-boot
Thymeleaf
https://www.thymeleaf.org/
Lombok
https://projectlombok.org/
Bootstrap 5
https://getbootstrap.com/
https://getbootstrap.com/docs/5.3/getting-started/introduction/
https://getbootstrap.com/docs/5.3/extend/icons/
jQuery
https://jquery.com/
MySQL 8
https://www.mysql.com/

Додаткові ресурси
--------------------
https://favicon.io/favicon-converter/
https://pixabay.com/
https://unsplash.com/
https://www.flaticon.com/
https://pinetools.com/
https://www.iloveimg.com/
https://tinypng.com/

--------------------------------

1) Формуємо INFO/SQLs.sql

2) Переходимо до Spring Initializr
https://start.spring.io/

Конфігуруємо проект
(цифрові позначення версій можуть
змінюватись з розвитком фреймворку):
a) Project: Maven
b) Spring Boot: обираємо стабільну версію, 
без позначок в дужках
c) Project Metadata:
- Group: com.example.app
- Artifact: Spring-Boot-Web-Shop
- Name: WebShop
- Description: залишаємо так
- Packaging name: залишаємо так
- Packaging: Jar
- Java: 17
d) Dependencies:
- Spring Boot DevTools
- Lombok
- Spring Web
- Thymeleaf	
- Spring Data JPA
- MySQL Driver

Перевіряємо. Клікаємо GENERATE.
Має загрузитися zip-файл.

3) Зформований zip-файл розпакуємо,
переміщуємо в папку проектів.

4) Відкриваємо проект в IDE.
Досліджуємо
src/main/
pom.xml

5) Додаємо контент до
application.properties

6) Модифікуємо
com.example.app.SpringBootFruitShop.WebShopApplication

7) Формуємо контент в
- main.resources (папки static та templates, 
файл application.properties - повинні додатись 
дефолтно)
- com.example.app.SpringBootFruitShop

Можна додати карту Google до свого проекту:
- В браузері перейдіть до Google Maps і введіть адресу,
яку потрібно відображати на карті.
- Натисніть кнопку «Поділитися».
- З’явиться нове вікно. Натисніть вкладку «Вставити карту» та
скопіюйте наданий HTML.
- Вставте скопійований HTML у відповідну сторінку (здебільшого,
це сторінка контактів).

8) Стартуємо програму. Дивимося логи.

9) В браузері, в адресному рядку запускаємо:
для User localhost:8080
для Admin localhost:8080/admin
Повинен завантажитися Web-додаток.

10) Досліджуємо Web-додаток.

------------------------------------------------------------

Щодо роботи з ДИНАМІЧНИМ КОНТЕНТОМ.
Файли, які завантажуються (upload) на сервер є динамічним
контентом, тому недоцільно зберігати їх в static/ проекту.
Чому?
Нашу програму можуть повторно розгорнути або перемістити
на іншу машину. Доведеться робити резервні копії/переміщувати
зображення громіздким способом.
Тому краще зберігати завантажуваний вміст в окремому місці
за межами нашої програми, тобто, в кореневій папці проекту
зробити директорію, наприклад, uploads, куди будуть
завантажуватися файли, а їх найменування зберігатися в
базі даних.
Для сатичної візуалізації, зображення доцільно розміщувати
в static/images/, Spring Boot та Thymeleaf потім мають доступ
та опрацьовують їх.
Але для контенту за межами програми, необхідні додаткові
налаштування (com.example.app.SpringBootFruitShop.config).


