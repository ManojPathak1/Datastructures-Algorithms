const nodes = document.body.querySelectorAll("*");
function getElementByAttribute(attrName, attrValue) {
  return Array.from(nodes)
    .find(e =>
      Array.from(e.attributes).find(e2 => (e2.nodeName === attrName) && (attrValue ? e2.nodeValue === attrValue : true)));
}

console.log(getElementByAttribute("type"));