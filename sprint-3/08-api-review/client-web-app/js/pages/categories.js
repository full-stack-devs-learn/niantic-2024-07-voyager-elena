let categoryService;
let addFormScreen;
let addForm;
let editFormScreen;
let editForm;

document.addEventListener("DOMContentLoaded", function () {
    categoryService = new CategoryService();
    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");
    editFormScreen = document.getElementById("edit-form-screen");
    editForm = document.getElementById("edit-form");

    document.getElementById("add-button").addEventListener("click", showAddForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);
    document.getElementById("cancel-edit-button").addEventListener("click", cancelEdit);
    document.getElementById("save-edit-button").addEventListener("click", updateCategory);

    loadCategories();
})

function loadCategories() {
    categoryService.getAllCategories()
        .then(categories => {
            const categoryContainer = document.getElementById('categories-container');
            categoryContainer.innerHTML = '';

            categories.forEach(category => {
                const template = document.getElementById('category-template').content.cloneNode(true);
                template.getElementById('category-header').innerText = category.categoryName;
                template.getElementById('category-image').src = `images/${category.categoryId}.webp`;

                const deleteButton = template.querySelector('#delete-button');
                deleteButton.addEventListener('click', () => {
                    categoryService.deleteCategory(category.categoryId).then(() => {
                        loadCategories();
                    })
                });
                const editButton = template.querySelector('#edit-button');
                editButton.addEventListener('click', () => {
                    editCategory(category.categoryId);
                });

                categoryContainer.appendChild(template);
            })
        });
}

function showAddForm() {
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event) {
    event.preventDefault();
    addFormScreen.classList.add("d-none");
    addForm.reset();
}

function cancelEdit(event) {
    event.preventDefault();
    editFormScreen.classList.add("d-none");
    editForm.reset();
}

function addCategory(event) {
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if (addForm.checkValidity()) {
        const name = addForm.querySelector("#category-name").value;
        const description = addForm.querySelector("#category-description").value;

        const category = {
            categoryName: name,
            description: description,
        }

        categoryService.addCategory(category).then(response => {
            addForm.reset();
            loadCategories();
        })

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}

function editCategory(categoryId) {
    console.log('Edit category');
    console.log(categoryId);
    //TODO: fill the form field with the category data
    editFormScreen.classList.remove("d-none");
}

function updateCategory(event) {
    event.preventDefault();
    event.stopPropagation();

    editForm.classList.add("was-validated");

    if (editForm.checkValidity()) {
        const name = editForm.querySelector("#category-name").value;
        const description = editForm.querySelector("#category-description").value;


        const category = {
            categoryName: name,
            description: description,
        }

        categoryService.editCategory(category).then(response => {
            editForm.reset();
            loadCategories();
        })

        editFormScreen.classList.add("d-none");
        editForm.classList.remove("was-validated");
    }
}

