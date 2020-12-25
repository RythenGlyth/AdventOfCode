console.log(
    require("fs").readFileSync("2020/06/input.txt").toString().split("\n\n").map(
        group => group.split("\n").map(
            (person, index, persons) => index == 0 ? person.split("").filter(
                char => !persons.find(
                    (val, oind) => oind != index && !val.includes(char)
                )
            ) : ""
        )[0].length
    ).reduce((a, b) => a+b)
);