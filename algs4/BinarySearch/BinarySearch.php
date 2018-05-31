<?php

function rank($key, $whitelist) {
    $low = 0;
    $high = count($whitelist) - 1;
    while ($low <= $high) {
        $mid = floor(($low + $high) / 2);
        if ($key < $whitelist[$mid]) $high = $mid - 1;
        elseif ($key >  $whitelist[$mid]) $low = $mid + 1;
        else return $mid;
    }
    return -1;
}

$key = $argv[1];
if (!$key) {
    echo "没有传递参数\n";
}
else {
    $whitelist = range(0, 1023);
    $index = rank($key, $whitelist);
    if ($index < 0) echo "没有找到值[{$key}]\n";
    else echo "值[{$key}]在索引[{$index}]处\n";
}