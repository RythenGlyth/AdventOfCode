file = open('input.txt')
text = file.read()
dict = {}
for line in text.splitlines():
    splitted = line[:len(line) - 1].replace(" bags", "").replace(" bag", "").split(" contain ")
    bag = splitted[0]
    bagsin = {}
    for res in splitted[1].split(", "):
        if splitted[1] != "no other": bagsin[res[2:]] = res[:1]
    dict[bag] = bagsin
#print(dict["light aqua"])

queue = [("shiny gold", 1)]
amount = 0

while len(queue) > 0:
    for bag in dict[queue[0][0]]:
        tAm = int(dict[queue[0][0]][bag]) * queue[0][1]
        amount += tAm
        queue.append((bag, tAm))
    queue.pop(0)
print(amount)