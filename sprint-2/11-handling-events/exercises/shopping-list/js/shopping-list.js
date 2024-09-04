let service;
let list = []

let allItemsIncomplete = true;

let form;
let itemNameInput;
let itemNameError;
let quantityInput;
let quantityError;


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
  // add event listener to the list item
  if (item.isComplete) {
    div.addEventListener('dblclick', () => markItemIncomplete(div));
  } else {
    div.addEventListener('click', () => markItemComplete(div));
  }

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

// do not work as expected
// const markComplete = (event) => {
//   console.log('click');
//   if(event.target.classList.contains('.list-item')) {
//     const listItem = event.target;
//     markItemComplete(listItem);
//   }  
// }

// const markIncomplete = (event) => {
//   console.log('double click');
//   const listItem = event.target;
//   console.log(listItem.classList)
//   markItemIncomplete(listItem);
// }

// it would be much simpler just to toggle item status on click
const toggleComplete = (event) => {
  const listItem = event.target;
  listItem.classList.toggle('complete');
}

const markItemComplete = (item) => {
  item.classList.add('complete');
  item.removeEventListener('click', () => markItemComplete(item));
  item.addEventListener('dblclick', () => markItemIncomplete(item));
}

const markItemIncomplete = (item) => {
  item.classList.remove('complete');
  item.removeEventListener('dblclick', () => markItemIncomplete(item));
  item.addEventListener('click', () => markItemComplete(item));
}

const handleMarkAllButtonClick = (event) => {
  console.log(`Button was clicked! allItemsIncomplete is ${allItemsIncomplete}`);
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

const handleAddNewItem = (event) => {
  event.preventDefault();

  if (formValidation()) {
    // add new item
    addNewItemToList();

    // reset form 
    form.reset();
  };

}

const formValidation = () => {
  let isValid = true;

  if (itemNameInput.validity.valid) {
    itemNameError.textContent = '\u00a0'; // 'empty' line so that gaps between inputs do not change
    itemNameInput.classList.remove('error');
  } else {
    itemNameError.textContent = 'Item name is required';
    itemNameInput.classList.add('error');
    isValid = false;
  }

  if (quantityInput.validity.valid) {
    quantityError.textContent = '\u00a0';
    quantityInput.classList.remove('error');
  } else {
    const quantityValue = quantityInput.value
    if (quantityValue.trim() === '') {
      quantityError.textContent = 'Quantity is required';
    } else {
      console.log(`quantityValue = ${quantityValue}`);
      quantityError.textContent = 'Quantity must be a whole number';
    }
    quantityInput.classList.add('error');
    isValid = false;
  }

  return isValid;
}

const setupFormValidation = () => {
  itemNameInput = document.querySelector('#itemName');
  itemNameError = document.querySelector('#nameError');
  quantityInput = document.querySelector('#quantity');
  quantityError = document.querySelector('#quantityError');
};

const addNewItemToList = () => {
  // create list item object
  const newItemObject = {
    id: list.length,
    title: itemNameInput.value,
    quantity: quantityInput.value,
    isComplete: false
  };

  list.push(newItemObject); // do not need to do it actually, just to keep track of number of items to create a new item id

  // get parent element
  const shoppingListElement = document.querySelector('#shopping-list');

  // call addListItem(item, parent) that is already defined
  addListItem(newItemObject, shoppingListElement);
}

// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
  service = new ShoppingService();
  list = service.getShoppingList();

  displayListTitle();
  displayShoppingList();
  handleMarkAllButton();

  form = document.querySelector('form');
  form.addEventListener('submit', handleAddNewItem);

  setupFormValidation();
});
