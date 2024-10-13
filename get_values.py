file1 = open("currency_data", "r+")
file2 = open("value_data", "r+")
line = file1.readlines()

# GET USD
current_currency = line[0]

if (current_currency == "usd"):
	file2.write("usd_nin_anlik_degeri")

elif (current_currency == "eur"):
	file2.write("eur_nun_anlik_degeri")

elif (current_currency == "gbp"):
	file2.write("gbp_nin_anlik_degeri")

else:
	file2.write("jpy_nin_anlik_degeri")