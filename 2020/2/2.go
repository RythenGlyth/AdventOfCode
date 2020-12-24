package main

import (
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strconv"
	"strings"
)

func main() {
	file, err := os.Open("2020/2/input.txt")
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
		containingRe := regexp.MustCompile(ssplitted[1])
		amount := int64(len(containingRe.FindAllStringIndex(fsplitted[1], -1)))
		minAmount, _ := strconv.ParseInt(tsplitted[0], 10, 64)
		maxAmount, _ := strconv.ParseInt(tsplitted[1], 10, 64)
		if amount >= minAmount && amount <= maxAmount {
			fmt.Println(line)
			count++
		}
	}
	fmt.Println(count)
}
