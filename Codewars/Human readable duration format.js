//  Human readable duration format
//  https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/javascript

// 1 Year = 31536000 seconds
// 1 day = 86400 seconds
// 1 hour = 3600 seconds
// 1 minute = 60 seconds
// 1 seond = 1 second

const aYear = 31536000;
const aDay = 86400;
const aHour = 3600;
const aMinute = 60;

const getPlaceholder = (str, value) => `${value} ${str}${value > 1 ? 's' : ''}`;

const formatDuration = (seconds) => {
  if (seconds === 0) return "now";
  let result = [];
  if (seconds >= aYear) result.push(getPlaceholder('year', Math.floor(seconds / aYear)));
  seconds %= aYear;
  if (seconds >= aDay) result.push(getPlaceholder('day', Math.floor(seconds / aDay)));
  seconds %= aDay;
  if (seconds >= aHour) result.push(getPlaceholder('hour', Math.floor(seconds / aHour)));
  seconds %= aHour;
  if (seconds >= aMinute) result.push(getPlaceholder('minute', Math.floor(seconds / aMinute)));
  seconds %= aMinute;
  if (seconds > 0) result.push(getPlaceholder('second', seconds));
  const lastElem = result.pop();
  if (result.length === 0) return lastElem;
  return `${result.join(", ")} and ${lastElem}`;
};
