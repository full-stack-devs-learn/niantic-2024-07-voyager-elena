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

    const url = `/products/category/${categoryId}`;

    fetch(url).then(response => {
        if (response.status === 200) {
            return response.text();
        }
        throw new Error(response);
    }).then(data => {
        container.innerHTML = data;
        const msgElement = document.querySelector('#products-msg');
        msgElement.style.display = 'none';
    }).catch(error => {
        console.log(error);
    });
};