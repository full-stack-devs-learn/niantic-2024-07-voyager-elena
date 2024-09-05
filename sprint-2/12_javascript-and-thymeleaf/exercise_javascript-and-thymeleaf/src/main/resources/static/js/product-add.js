document.addEventListener('DOMContentLoaded', () => {

    const addProductForm = document.querySelector('#add-product-form');
    const productName = document.querySelector('#productName');
    const quantityPerUnit = document.querySelector('#quantityPerUnit');

    productName.addEventListener('input', () => {
        addProductForm.classList.remove('was-validated');
    });
    quantityPerUnit.addEventListener('input', () => {
        addProductForm.classList.remove('was-validated');
    });

    addProductForm.addEventListener('submit', (event) => {
        if (!addProductForm.checkValidity()) {
            event.preventDefault();
            addProductForm.classList.add('was-validated');
        }
    });
    
});