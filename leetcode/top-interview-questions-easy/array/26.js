/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = nums => {
  let free = nums.length;
  while (free > 0) {
      let one = nums.shift();
      if (nums[nums.length - 1] != one) {
          nums.push(one);
      }
      free--;
  };
};