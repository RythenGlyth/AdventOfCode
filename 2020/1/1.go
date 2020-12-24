package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	lines, err := readLines("2020/1/input.txt")
	if err != nil {
		fmt.Println(err)
	}
	var i, j int
	for i = 0; i < len(lines); i++ {
		for j = i + 1; j < len(lines); j++ {
			var li, _ = strconv.ParseInt(lines[i], 10, 64)
			var lj, _ = strconv.ParseInt(lines[j], 10, 64)
			if li+lj == 2020 {
				fmt.Printf("i:%d j: %d, product: %d\n", li, lj, li*lj)
			}
		}
	}

}

func readLines(path string) ([]string, error) {
	file, err := os.Open(path)
	if err != nil {
		return nil, err
	}
	defer file.Close()

	var lines []string
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	return lines, scanner.Err()
}
