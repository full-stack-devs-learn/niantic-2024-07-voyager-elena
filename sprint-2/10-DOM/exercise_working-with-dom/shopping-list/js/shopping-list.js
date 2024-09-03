const shoppingListService = new ShoppingService();

// add pageTitle

// add groceries

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
const displayListTitle = () => {
  const titleElement = document.querySelector('#title');
  titleElement.textContent = shoppingListService.getListName();
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
const displayGroceries = () => {
  const shoppingListItemsContainer = document.querySelector('#groceries');
  const shoppingList = shoppingListService.getShoppingList();
  shoppingList.forEach(item => addShoppingListItemElement(item, shoppingListItemsContainer));
}

/**
 * This function creates shopping list item element and appends it to the items container
 */
const addShoppingListItemElement = (item, container) => container.appendChild(createShoppingListItemElement(item));


const createShoppingListItemElement = (item) => {
  const classNames = ['list-item'];
  if (item.isComplete) {
    classNames.push('complete');
  }
  const itemElement = createElement('li', classNames);
  itemElement.appendChild(createShoppingListItemTitleDiv(item.title));
  itemElement.appendChild(createShoppingListItemQuantityDiv(item.quantity));
  return itemElement;
}

const createShoppingListItemTitleDiv = (title) => {
  return createElement('div', '', title);
}

const createShoppingListItemQuantityDiv = (quantity) => {
  const quantityElement = createElement('div', 'quantity-container');
  const quantityTextSpan = createElement('span', 'super', 'quantity');
  quantityElement.appendChild(quantityTextSpan);
  quantityElement.appendChild(document.createTextNode(quantity));
  return quantityElement;
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
const markCompleted = () => {
  const itemElementsList = document.querySelectorAll('.list-item');
  itemElementsList.forEach(item => item.classList.add('complete'));
}


const markUncompleted = () => {
  const itemElementsList = document.querySelectorAll('.list-item');
  itemElementsList.forEach(item => item.classList.remove('complete'));
}


displayListTitle();
displayGroceries();

