console.log(require("fs").readFileSync("2020/06/input.txt").toString().split("\n\n").map(group => group.replaceAll("\n", "").replaceAll(/(.)(?=.*\1)/g, "").length).reduce((a,b) => a+b));