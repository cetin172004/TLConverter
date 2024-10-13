from bs4 import BeautifulSoup
import requests
import os

# reset previous value
os.system("rm value_data")
os.system("touch value_data")

file1 = open("currency_data", "r+")
file2 = open("value_data", "r+")
line = file1.readlines()

# GET USD
current_currency = line[0]

if (current_currency == "usd"):
	url = "https://www.google.com/finance/quote/USD-TRY"

elif (current_currency == "eur"):
	url = "https://www.google.com/finance/quote/EUR-TRY"

elif (current_currency == "gbp"):
	url = "https://www.google.com/finance/quote/GBP-TRY"

else:
	url = "https://www.google.com/finance/quote/JPY-TRY"
	
response = requests.get(url)
html_content = response.content
soup = BeautifulSoup(html_content, 'html.parser')
	
elements = soup.find("div", class_="YMlKec fxKbKc")
number = ""
for element in elements:
	if (" " in element):
		break
	else:
		number += element.get_text()
	
file2.write(number)