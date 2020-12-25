<?php

$theid = 0;
$arr = [];
$fp = fopen(dirname(__FILE__) . "./input.txt", "r+");
while (($line = stream_get_line($fp, 1024 * 1024, "\n")) !== false) {
    $thisone = bindec(str_replace("F", "0", str_replace("B", "1", str_replace("L", "0", str_replace("R", "1", $line)))));
    array_push($arr, $thisone);
}
for($i = 0; $i <= 0b1111111111; $i++) {
    if(!in_array($i, $arr) && in_array($i + 1, $arr) && in_array($i - 1, $arr)) {
        echo $i . "\n";
    }
}
fclose($fp);

?>