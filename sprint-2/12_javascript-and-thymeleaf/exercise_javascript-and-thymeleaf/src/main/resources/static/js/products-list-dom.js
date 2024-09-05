document.addEventListener('DOMContentLoaded', () => {
    const categorySelector = document.querySelector('#category');
    const categoryId = categorySelector.value;
    if (categoryId > 0) {
        loadProducts(categoryId);
    }
    categorySelector.addEventListener('change', () => loadProducts(categorySelector.value));
});

const loadProducts = (categoryId) => {
    const container = document.querySelector('#product-container');
    container.innerHTML = '';

    const url = `/api/products/category/${categoryId}`;

    fetch(url).then(response => {
        if (response.status === 200) {
            return response.json();
        }
        throw new Error(response);
    }).then(data => {
        const msgElement = document.querySelector('#products-msg');
        msgElement.style.display = 'none';
        data.forEach(product => {
            displayProduct(product, container);
        })
    }).catch(error => {
        console.log(error);
    });
};

const displayProduct = (product, container) => {
    const productRow = createElement('tr');

    productRow.appendChild(createElement('td', product.productId));
    
    const productNameCell = createElement('td');
    productNameCell.appendChild(createLinkElem(`/products/${product.productId}`, product.productName,));
    productRow.appendChild(productNameCell);

    productRow.appendChild(createElement('td', product.unitPrice));

    const buttonsContainer = createElement('td');
    buttonsContainer.appendChild(createLinkElem(`/products/${product.productId}/edit`, 'Edit', ['btn', 'btn-success', 'me-2']));
    buttonsContainer.appendChild(createLinkElem(`/products/${product.productId}/delete`, 'Delete', ['btn', 'btn-danger']));
    productRow.appendChild(buttonsContainer);

    container.appendChild(productRow);
};

const createElement = (elemType, textContent) => {
    const elem = document.createElement(elemType);
    if (textContent) {
        elem.textContent = textContent;
    }
    return elem;
};

const createLinkElem = (href, textContent, classNames = '') => {
    const elem = document.createElement('a');
    if (classNames) {
        elem.classList.add(...classNames);
    }
    elem.textContent = textContent;
    elem.href = href;
    return elem;
}
