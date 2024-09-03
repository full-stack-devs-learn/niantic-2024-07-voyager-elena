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

function addListItem(item, parent) {
  const div = document.createElement("div")
  div.classList.add("list-item");
  if (item.isComplete) {
    div.classList.add("complete")
  }

  addItemTitle(item, div);
  addQuantity(item, div);
  // add event listeners to the list item
  if (item.isComplete) {
    div.addEventListener('dblclick', markIncomplete);
  } else {
    div.addEventListener('click', markComplete);
  }

  // div.addEventListener('click', toggleComplete);
  // div.addEventListener('click', () => console.log('Click!'));
  // div.addEventListener('dblclick', () => console.log('Double click!'));
  // div.addEventListener("click", () => {
  //   div.classList.add("complete");
  // })
  // div.addEventListener("dblclick", () => {
  //   div.classList.remove("complete");
  // })

  parent.appendChild(div);
}

function addItemTitle(item, parent) {
  const div = document.createElement("div")
  div.textContent = item.title;

  parent.appendChild(div);
}

function addQuantity(item, parent) {
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


const markAllComplete = () => {
  const listItems = document.querySelectorAll('.list-item');
  listItems.forEach(item => markItemComplete(item));
}

const markAllIncomplete = () => {
  const listItems = document.querySelectorAll('.list-item');
  listItems.forEach(item => markItemIncomplete(item));
}

const markComplete = (event) => {
  console.log('click');
  const listItem = event.target;
  markItemComplete(listItem);
}

const markIncomplete = (event) => {
  console.log('double click');
  const listItem = event.target;
  markItemIncomplete(listItem);
}

// it would be much simpler just to toggle item status on click
const toggleComplete = (event) => {
  const listItem = event.target;
  listItem.classList.toggle('complete');
}

const markItemComplete = (item) => {
  item.classList.add('complete');
  item.removeEventListener('click', markComplete);
  item.addEventListener('dblclick', markIncomplete);
}

const markItemIncomplete = (item) => {
  item.classList.remove('complete');
  item.removeEventListener('dblclick', markIncomplete);
  item.addEventListener('click', markComplete);
}

const handleMarkAllButtonClick = (event) => {
  console.log('Button was clicked!');
  const btn = event.target;
  const btnTextContent = btn.textContent;
 
  // did not notice the HINT at first
  // if (btnTextContent === 'Mark All Completed') {
    if (allItemsIncomplete) {
    btn.textContent = 'Mark All Incomplete';
    allItemsIncomplete = false;
    markAllComplete();
  } else {
    btn.textContent = 'Mark All Completed';
    allItemsIncomplete = true;
    markAllIncomplete();
  }
}

const handleMarkAllButton = () => {
  const markAllButton = document.querySelector('#allCompleteButton');
  markAllButton.textContent = 'Mark All Completed';
  markAllButton.addEventListener('click', handleMarkAllButtonClick);
}

// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
  service = new ShoppingService();
  list = service.getShoppingList();

  displayListTitle();
  displayShoppingList();
  handleMarkAllButton();
});

