import 'dart:io';

void main() async {
  RegExp hclExp = new RegExp(r"^#[0-9a-f]{6}$");
  print((await new File('input.txt').readAsString())
      .split("\n\n")
      .map((e) => Map.fromEntries(e.replaceAll("\n", " ").split(" ").map((e2) => e2.split(":").length >= 2
          ? MapEntry(e2.split(":")[0], e2.split(":")[1])
          : MapEntry("", ""))))
      .toList()
      .where((element) =>
          (element.containsKey("byr") && element["byr"].length == 4 && tryParse(element["byr"]) >= 1920 && tryParse(element["byr"]) <= 2002) &&
          (element.containsKey("iyr") &&
              element["iyr"].length == 4 &&
              tryParse(element["iyr"]) >= 2010 &&
              tryParse(element["iyr"]) <= 2020) &&
          (element.containsKey("eyr") &&
              element["eyr"].length == 4 &&
              tryParse(element["eyr"]) >= 2020 &&
              tryParse(element["eyr"]) <= 2030) &&
          (element.containsKey("hgt") &&
              ((element["hgt"].endsWith("cm") &&
                      tryParse(element["hgt"].substring(0, element["hgt"].length - 2)) >=
                          150 &&
                      tryParse(element["hgt"].substring(0, element["hgt"].length - 2)) <=
                          193) ||
                  (element["hgt"].endsWith("in") &&
                      tryParse(element["hgt"].substring(0, element["hgt"].length - 2)) >= 59 &&
                      tryParse(element["hgt"].substring(0, element["hgt"].length - 2)) <= 76))) &&
          (element.containsKey("hcl") && hclExp.hasMatch(element["hcl"])) &&
          (element.containsKey("ecl") && (element["ecl"] == "amb" || element["ecl"] == "blu" || element["ecl"] == "brn" || element["ecl"] == "gry" || element["ecl"] == "grn" || element["ecl"] == "hzl" || element["ecl"] == "oth")) &&
          (element.containsKey("pid") && element["pid"].length == 9))
      .length);
}

int tryParse(String source) {
  int parsed = int.tryParse(source);
  return parsed != null ? parsed : 0;
}
