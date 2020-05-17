const grandParent = document.getElementById("grandparent");
const parent = document.getElementById("parent");
const child = document.getElementById("child");
const logs = document.getElementById("logs");
const clearButton = document.getElementById("clearButton");

function logger(log) {
  logs.appendChild(getCard(log));
}

function getCard(logs) {
  const fragment = new DocumentFragment();
  if (!Array.isArray(logs)) logs = [logs];
  logs.forEach(log => {
    const e1 = document.createElement('DIV');
    const e2 = document.createElement('SPAN');
    e1.style.backgroundColor = log.color;
    e2.style.color = "#fff";
    e2.textContent = log.text;
    e1.appendChild(e2);
    fragment.appendChild(e1);
  });
  return fragment;
}

function clear() {
  logs.innerHTML = '';
}

clearButton.addEventListener("click", clear);

function onChangeInput(event) {
  registerListeners(event.target.id);
}

function grandParentCB() {
  logger({ text: "grandparent : click", color: "#fc6262" });
}

function parentCB() {
  logger({ text: "parent : click", color: "#48f748" });
}

function childCB() {
  logger({ text: "child : click", color: "#48c3f7" });
}

function registerListeners(type) {
  const isCapture = type === "capture";
  // Remove event listeners
  grandParent.removeEventListener("click", grandParentCB, !isCapture);
  parent.removeEventListener("click", parentCB, !isCapture);
  child.removeEventListener("click", childCB, !isCapture);
  // Add event listeners
  grandParent.addEventListener("click", grandParentCB, isCapture);
  parent.addEventListener("click", parentCB, isCapture);
  child.addEventListener("click", childCB, isCapture);
}

registerListeners("bubble");
