<?php

$highest = 0;
$fp = fopen(dirname(__FILE__) . "./input.txt", "r+");
while (($line = stream_get_line($fp, 1024 * 1024, "\n")) !== false) {
    $thisone = bindec(str_replace("F", "0", str_replace("B", "1", str_replace("L", "0", str_replace("R", "1", $line)))));
    if ($thisone > $highest) {
        $highest = $thisone;
    }
}
fclose($fp);
echo($highest);

?>