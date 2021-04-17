<?php

$fp = fopen(dirname(__FILE__) . "/input.txt", "r+");
$contents = stream_get_contents($fp);
$lines = explode("\n", $contents);

$estEarlTimestmp = $lines[0];

$buslist = explode(",", $lines[1]);
$buslist = array_filter ($buslist, function($l) {
    return $l != "x";
});
$mappdbuslist = [];
foreach ($buslist as $v) {
    $mappdbuslist[$v] = $v - $estEarlTimestmp % $v;
}
//var_dump($mappdbuslist);

$minWaitTime = min($mappdbuslist);
$minWaitId = array_keys($mappdbuslist, $minWaitTime)[0];

echo($minWaitTime * $minWaitId . "\n");

?>