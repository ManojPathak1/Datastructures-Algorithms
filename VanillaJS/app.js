//  Fetching data in vanillaJS
function fetchData() {
  fetch("https://jsonplaceholder.typicode.com/todos/1")
    .then(res => res.json())
    .then(res => {
      console.log(res);
    });
}

function getCard(restraunts) {
  return restraunts.map(restraunt => {
    return cardTemplateString(restraunt);
  }).join("");
}

const cardTemplateString = ({ id, name, rating, location }) => {
  return `<div class="card"><div class="innerContainer">
          ${name ? `<span>${name}</span>` : `<input id="nameInput${id}" type="text" />`}
          <div>
            <span>${rating}</span><br>
            <span>${location}</span>
          </div>
        </div></div>`;
}

function appendCardContainer(restraunts) {
  const cardContainer = document.getElementById("cardsContainer");
  cardContainer.innerHTML = getCard(restraunts);
  document.getElementById(`nameInput${id}`).addEventListener("onchange", () => {
    console.log("Hello");
  });
}

appendCardContainer([
  { id: 1, name: "Restraunt 1", rating: "4", location: "Noida" },
  { id: 2, rating: "5", location: "Greater Noida" }
]);

// fetchData();