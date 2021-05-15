# bitcoin-prices-api
Bitcoin Prices API

Read from cryptocurrencies API the Bitcoin prices for different Pairs, storing the data in SQLite3 DDBB.

### inspiring links
https://www.sqlite.org/download.html
https://github.com/gwenn/sqlite-jna
https://github.com/gwenn/sqlite-dialect

# build
gradle clean test
gradle clean build

# Play
gradle bootRun

### Release Notes
http://localhost:8087/bitcoin-prices-api/v1/releasenotes

### Create
curl -iX POST "http://localhost:8087/bitcoin-prices-api/v1/price/create" -H "accept: */*" -H "Content-Type: application/json" -d "{
\"id\": 0,
\"source\": \"TEST\",
\"instrument\": \"BTC_EUR\",
\"amount\": 50000,
\"created\": \"2021-05-15T11:19:00.000Z\" }"

### Read
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read/all" -H "accept: */*"
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read/0" -H "accept: */*"
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read?source=TEST" -H "accept: */*"
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read?instrument=BTC_EUR" -H "accept: */*"
curl -iX GET "http://localhost:8087/bitcoin-prices-api/v1/price/read?source=TESTinstrument=BTC_EUR" -H "accept: */*"

### Update
curl -iX PUT "http://localhost:8087/bitcoin-prices-api/v1/price/update/0" -H "accept: */*" -H "Content-Type: application/json" -d "{
\"source\": \"TEST\",
\"instrument\": \"BTC_USD\",
\"amount\": 60000,
\"created\": \"2021-05-15T11:20:00.000Z\" }"

### Delete
curl -X DELETE "http://localhost:8087/bitcoin-prices-api/v1/price/delete/0" -H "accept: */*"