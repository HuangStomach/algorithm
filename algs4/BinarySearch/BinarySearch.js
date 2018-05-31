const rank = (key, whitelist) => {
  let low = 0;
  let high = whitelist.length - 1;
  while (low <= high) {
    mid = Math.floor((low + high) / 2);
    if (key < whitelist[mid]) high = mid - 1;
    else if (key > whitelist[mid]) low = mid + 1;
    else return mid;
  }
  return -1;
}

const key = process.argv[2];
if (!key) {
  console.log('没有传递参数')
}
else {
  const whitelist = new Array(1024).fill(0).map((el, i) => i);
  const index = rank(key, whitelist); 
  if (index < 0) console.log(`没有找到值[${key}]`);
  else console.log(`值[${key}]在索引[${index}]处`);
}
