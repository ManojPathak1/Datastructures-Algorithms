//  Adding Big Numbers
//  https://www.codewars.com/kata/525f4206b73515bffb000b21/train/javascript

const add = (a, b) => {
  const aArr = a.split("").reverse();
  const bArr = b.split("").reverse();
  const aLen = aArr.length;
  const bLen = bArr.length;
  const min = Math.min(aLen, bLen);
  const result = [];
  let carry = 0;
  let i = 0;
  for (i = 0; i < min; i++) {
    const num1 = Number(aArr[i]);
    const num2 = Number(bArr[i]);
    const sum = num1 + num2 + carry;
    carry = Math.floor(sum / 10);
    const rem = sum % 10;
    result.push(rem);
  }
  for (; i < aLen; i++) {
    const num1 = Number(aArr[i]);
    const sum = num1 + carry;
    carry = Math.floor(sum / 10);
    const rem = sum % 10;
    result.push(rem);
  }
  for (; i < bLen; i++) {
    const num2 = Number(bArr[i]);
    const sum = num2 + carry;
    carry = Math.floor(sum / 10);
    const rem = sum % 10;
    result.push(rem);
  }
  if (carry !== 0) result.push(carry);
  return result.reverse().join("");
};