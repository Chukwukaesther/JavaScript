const user = require("./functions.js");  


test("add two numbers", () => {
	let numOne = 2;
	let numTwo = 5;
	let ans = user(2, 5)
	expect(ans).toBe(7);
});