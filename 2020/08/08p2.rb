lines = File.readlines('2020/08/input.txt')
lines = lines.map{|line| line.split(' ')}
acc = 0
beforeLineIndices = []
currLine = 0

instructionChangeIndex = 0

while currLine < lines.length
    acc = 0
    beforeLineIndices = []
    currLine = 0
    instructionIndex = 0

    while not beforeLineIndices.include? currLine and currLine < lines.length
        beforeLineIndices.push(currLine)
        if (lines[currLine][0] == "nop" and instructionIndex != instructionChangeIndex) or (lines[currLine][0] == "jmp" and instructionIndex == instructionChangeIndex)
            instructionIndex += 1
        elsif lines[currLine][0] == "acc"
            acc += lines[currLine][1].to_i
        elsif (lines[currLine][0] == "jmp" and instructionIndex != instructionChangeIndex) or (lines[currLine][0] == "nop" and instructionIndex == instructionChangeIndex)
            currLine += lines[currLine][1].to_i
            instructionIndex += 1
            next
        end
        currLine+=1
    end
    instructionChangeIndex += 1
end

puts acc