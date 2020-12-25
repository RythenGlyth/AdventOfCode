import 'dart:async';
import 'dart:developer';
import 'dart:io';

void main() async {
  print((await new File('input.txt').readAsString())
      .split("\n\n")
      .map((e) => Map.fromEntries(e.replaceAll("\n", " ").split(" ").map((e2) =>
          e2.split(":").length >= 2
              ? MapEntry(e2.split(":")[0], e2.split(":")[1])
              : MapEntry("", ""))))
      .toList()
      .where((element) =>
          element.containsKey("byr") &&
          element.containsKey("iyr") &&
          element.containsKey("eyr") &&
          element.containsKey("hgt") &&
          element.containsKey("hcl") &&
          element.containsKey("ecl") &&
          element.containsKey("pid"))
      .length);
}
