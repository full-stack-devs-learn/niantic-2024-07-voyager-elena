document.addEventListener('DOMContentLoaded', () => {

    const categorySelector = document.querySelector('#category');
    categorySelector.addEventListener('change', () => console.log(`You selected category with id: ${categorySelector.value}`))

});