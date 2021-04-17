<?php

$fp = fopen(dirname(__FILE__) . "/input.txt", "r+");
$contents = stream_get_contents($fp);
$lines = explode("\n", $contents);

$estEarlTimestmp = $lines[0];

$buslist = explode(",", $lines[1]);



$timestamp = 0;
$pos = 0;
$toAdd = 1;
while(true) {
    if($buslist[$pos] == "x") {
        $pos++;
        continue;
    }
    if(($timestamp + $pos) % $buslist[$pos] == 0) {
        $toAdd *= $buslist[$pos];
        $pos++;
    }
    if($pos == count($buslist)) {
        break;
    }
    $timestamp += $toAdd;
}
echo($timestamp . "\n");

?>