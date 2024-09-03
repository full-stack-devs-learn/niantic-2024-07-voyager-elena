let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div);
    // add event listeners to the list item
    // div.addEventListener('click', toggleComplete);
    // div.addEventListener('click', markComplete);
    // div.addEventListener('dblclick', markIncomplete);
    // div.addEventListener('click', () => console.log('Click!'));
    // div.addEventListener('dblclick', () => console.log('Double click!'));
    div.addEventListener("click", () => {
      div.classList.add("complete");
    })
    div.addEventListener("dblclick", () => {
      div.classList.remove("complete");
    })

    parent.appendChild(div);
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        item.classList.add("complete");
    })
}

const markComplete = (event) => {
  console.log('click')
  console.log(event.target);
}

const markIncomplete = (event) => {
  console.log('double click')
  console.log(event.target);
}

const toggleComplete = (event) => {
  const listItem = event.target;
  listItem.classList.toggle('complete');
}

// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();
});

