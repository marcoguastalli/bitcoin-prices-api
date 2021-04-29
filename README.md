# bitcoin-prices-api
Bitcoin Prices API

Read from cryptocurrencies API the Bitcoin prices for different Pairs, storing the data in SQLite3 DDBB.

### inspiring links
https://www.sqlite.org/download.html
https://github.com/gwenn/sqlite-jna
https://github.com/gwenn/sqlite-dialect

# Play
### Release Notes
http://localhost:8087/bitcoin-prices-api/v1/releasenotes

### Create
curl -iX POST "http://localhost:8087/bitcoin-prices-api/v1/price/create" -H "accept: */*" -H "Content-Type: application/json" -d "{
\"currency\": \"BTC_EUR\",
\"amount\": 50000,
\"created\": \"2021-04-28T19:19:00.000Z\" }"

### Read
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read/all" -H "accept: */*"
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read/1" -H "accept: */*"

### Update
curl -iX PUT "http://localhost:8087/bitcoin-prices-api/v1/price/update/1" -H "accept: */*" -H "Content-Type: application/json" -d "{
\"currency\": \"BTC_USD\",
\"amount\": 60000,
\"created\": \"2021-04-28T19:20:00.000Z\" }"

### Delete
curl -X DELETE "http://localhost:8087/bitcoin-prices-api/v1/price/delete/1" -H "accept: */*"