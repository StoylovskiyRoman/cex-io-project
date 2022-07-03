# cex-io-project
Collect data.
You need to fetch cryptocurrency data prices from CEX.IO. For this task you should pull last prices for the following pairs: BTC/USD, ETH/USD and XRP/USD. This data should be stored in database, since you will use this data in the next two parts of the task. Feel free to store any additional information to database like 'createdAt' date etc.
Rest Endpoints.
You need to create a rest controller with the following endpoints
GET /cryptocurrencies/minprice?name=[currency_name] - should return record with the lowest price of selected cryptocurrency.
GET /cryptocurrencies/maxprice?name=[currency_name] - should return record with the highest price of selected cryptocurrency [currency_name] possible values: BTC, ETH or XRP. If some other value is provided then appropriate error message should be thrown.
GET /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - should return record with name, page number and page size.

swagger-ui: http://localhost:8080/swagger-ui/index.html
