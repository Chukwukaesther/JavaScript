
multiple = 0
for figure in range(1, 20001):
	if figure % 10 == 0 :
		multiple = multiple + figure
		print(figure)
print(multiple)