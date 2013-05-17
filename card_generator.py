
cards = [2,3,4,5,6,7,8,9, 10, 11, 12, 13, 14]
#suits = ['C', 'D', 'H', 'S']suits = ['C', 'D', 'H', 'S']
suits = ['CLUB', 'DIAMOND', 'HEART', 'SPADE']


for i in range(0,52):
	print str(suits[i / 13]) + "_" + str(cards[i%13])+ "(" + str(cards[i%13]) + '),'
	# print i + suits[card % 13] 