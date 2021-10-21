# Currency-analysis
Currency analysis in relation to USD 

Запуск сервиса: 
1) cd currency-analysis
2) ./gradlew bootBuildImage --imageName=localhost:8080/api/currency
3) docker run -p 8080:8080 -t localhost:8080/api/currency

Endpoints:

GET http://localhost:8080/api/currency/ -> для получения gif;
GET http://localhost:8080/api/currency/testing -> отображает информацию в json;

Сервис сравнивает курс USD по отношению к валюте нынешнего дня и вчерашнего. 

Все параметры вынесы в src/main/resources/application.properties

Использовались:
- api курса валют(https://openexchangerates.org)
- api gif(https://developers.giphy.com)
- feign client
- @mockbean
- docker для сборки
