package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	fmt.Println(getTreeCount(1, 1) * getTreeCount(3, 1) * getTreeCount(5, 1) * getTreeCount(7, 1) * getTreeCount(1, 2))
}

func getTreeCount(xJump int, yJump int) int {
	file, err := os.Open("2020/03/input.txt")
	if err != nil {
		fmt.Println(err)
		return 0
	}
	defer file.Close()

	var count int
	xpos := 0

	index := 0

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		if index%yJump == 0 {
			if string(scanner.Text()[xpos%len(scanner.Text())]) == "#" {
				count++
			}
			xpos += xJump
		}
		index++
	}
	return count
}
