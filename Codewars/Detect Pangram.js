//  Detect Pangram
//  https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/javascript

function isPangram(string) {
  const alphabets = new Set(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']);
  return string.split("").some(e => {
    alphabets.delete(e.toLocaleLowerCase());
    return alphabets.size === 0;
  });
}