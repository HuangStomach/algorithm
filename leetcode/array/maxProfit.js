/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = prices => {
  if (prices.length <= 0) return 0;
  let profit = 0;
  for (let i = 0; i < prices.length; i++) {
      if (prices[i] < prices[i + 1]) {
          profit += prices[i + 1] - prices[i];
      }
  }
  return profit;
};