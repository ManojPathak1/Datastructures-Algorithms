//  Mexican Wave
//  https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/javascript

const replaceAt = (str, index, replaceStr) =>
  str.substring(0, index) + replaceStr + str.substring(index + replaceStr.length);

const wave = (str) => {
  const result = [];
  for (let i = 0; i < str.length; i++) {
    str[i] !== " " && result.push(replaceAt(str, i, str[i].toLocaleUpperCase()));
  }
  return result;
};