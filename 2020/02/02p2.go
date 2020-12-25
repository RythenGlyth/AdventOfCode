package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	file, err := os.Open("2020/02/input.txt")
	if err != nil {
		fmt.Println(err)
		return
	}
	defer file.Close()

	var count int

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()
		fsplitted := strings.Split(line, ": ")
		ssplitted := strings.Split(fsplitted[0], " ")
		tsplitted := strings.Split(ssplitted[0], "-")

		pos1, _ := strconv.Atoi(tsplitted[0])
		pos2, _ := strconv.Atoi(tsplitted[1])
		if (len(fsplitted[1]) >= pos1 && string(fsplitted[1][pos1-1]) == ssplitted[1]) != (len(fsplitted[1]) >= pos2 && string(fsplitted[1][pos2-1]) == ssplitted[1]) {
			char1 := ""
			if len(fsplitted[1]) >= pos1 {
				char1 = string(fsplitted[1][pos1-1])
			} else {
				char1 = ""
			}
			char2 := ""
			if len(fsplitted[1]) >= pos2 {
				char2 = string(fsplitted[1][pos2-1])
			} else {
				char2 = ""
			}
			fmt.Printf("line: \"%v\", char1: %v, char2: %v\n", line, char1, char2)
			count++
		}
	}
	fmt.Println(count)
}
