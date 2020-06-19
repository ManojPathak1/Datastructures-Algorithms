const buttonContainer = document.getElementById("buttonContainer");
const count = 10;

function addButtons() {
  const fragment = new DocumentFragment();
  for (let i = 0; i < count; i++) {
    const button = document.createElement();
    button.innerHTML = `Button ${i + 1}`;
    button.addEventListener('click', addButtons);
    fragment.appendChild(button);
  }
  buttonContainer.appendChild(fragment);
}