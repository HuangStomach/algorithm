let pokers = [
  3, 2, 1, 3, 1, 3, 2, 2, 4, 2, 1, 1, 4, 
  1, 4, 1, 1, 2, 2, 4, 1, 2, 2, 4, 4, 3, 
  4, 4, 1, 1, 4, 3, 2, 4, 2, 4, 4, 3, 3, 
  2, 3, 3, 2, 3, 4, 1, 3, 1, 1, 3, 2, 3
];


// 2.1.14
let sort = pokers => {
  for (let i = 1; i < pokers.length; i++) {
    for (let j = 1; j < pokers.length; j++) {
      let a = pokers.shift();
      let b = pokers.shift();
      
      if (a > b) {
        pokers.push(b);
        pokers.unshift(a);
      }
      else {
        pokers.push(a);
        pokers.unshift(b);
      }
    }
    pokers.push(pokers.shift());
  }
}

sort(pokers);
