let arrayOfNumber = [1,2,3,4,5,6,7]

const evenNumbers = (number) => {
    let evenIndex = [];
    for (let i = 0; i < number.length; i++){
        if (number[i] % 2 === 0){
            evenIndex.pop(number[i])
        }
    
    }
    
    return evenIndex;   
}
console.log(arrayOfNumber)

// console.log(evenNumbers(arrayOfNumber))