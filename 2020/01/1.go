package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	lines, err := readLines("2020/01/input.txt")
	if err != nil {
		fmt.Println(err)
	}
	nums, product, has := findNumbers(lines, 3, 2020, 0)
	if has {
		fmt.Printf("numbers: %v; product: %v\n", nums, product)
	} else {
		fmt.Printf("has no solution\n")
	}
	/*var i, j int
	for i = 0; i < len(lines); i++ {
		for j = i + 1; j < len(lines); j++ {
			var li, _ = strconv.ParseInt(lines[i], 10, 64)
			var lj, _ = strconv.ParseInt(lines[j], 10, 64)
			if li+lj == 2020 {
				fmt.Printf("i:%d j: %d, product: %d\n", li, lj, li*lj)
			}
		}
	}*/
}

func findNumbers(lines []string, numCount int, sum int, startIndex int) ([]int, int, bool) {
	for i := startIndex; i < len(lines); i++ {
		var numi, _ = strconv.Atoi(lines[i])
		if numCount == 1 {
			if numi == sum {
				return []int{numi}, numi, true
			}
		} else {
			nums, product, hasSolution := findNumbers(lines, numCount-1, sum-numi, i+1)
			if hasSolution {
				return append(nums, numi), numi * product, true
			}
		}
	}
	return nil, 0, false
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
