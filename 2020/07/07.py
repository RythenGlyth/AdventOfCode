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

queue = ["shiny gold"]
res = []

while len(queue) > 0:
    for q in dict:
        if(queue[0] in dict[q]):
            if(q not in queue): queue.append(q)
            if(q not in res): res.append(q)
    queue.pop(0)
print(len(res))