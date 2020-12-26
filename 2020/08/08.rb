lines = File.readlines('2020/08/input.txt')
lines = lines.map{|line| line.split(' ')}
acc = 0
beforeLineIndices = []
currLine = 0

while not beforeLineIndices.include? currLine
    beforeLineIndices.push(currLine)
    if lines[currLine][0] == "nop"
    elsif lines[currLine][0] == "acc"
        acc += lines[currLine][1].to_i
    elsif lines[currLine][0] == "jmp"
        currLine += lines[currLine][1].to_i
        next
    end
    currLine+=1
end

puts acc